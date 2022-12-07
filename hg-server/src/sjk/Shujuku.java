package sjk;

import gongju.CreatPicName;
import gongju.GongJu;
import gongju.ImageBinary;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Vector;

public class Shujuku {
	/*
	 * Connection ct; PreparedStatement ps = null; ResultSet rs = null; String
	 * driver = "sun.jdbc.odbc.JdbcOdbcDriver"; String url = "jdbc:odbc:sql server";
	 * String user = "sa"; String passwd = "3354wcn6679fuck0617";
	 */

	Connection ct;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/huagao?useSSL=false&serverTimezone=UTC";
	String user = "root";
	String passwd = "12345678";

//    static final String JdbcDriver = "com.mysql.cj.jdbc.Driver";  
////  static final String Url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
//  static final String Url = "jdbc:mysql://localhost:3306/huagao?useSSL=false&serverTimezone=UTC";//这里的huagao是database name
//
//  //输入连接数据库的用户名与密码
//  static final String User = "root";//输入你的数据库库名
//  static final String PassWord = "12345678";//输入你的数据库连接密码

	/* renamed from: gongju reason: collision with root package name */
	GongJu f0gongju;

	// -------------
//	public static void main(String[] args) {
////    	new Shujuku();
////		new Shujuku().searchOrderInfo("select * from kehuinfo");
//		new Shujuku().searchOrderInfo("select orderno,orderdate,customername,"
//				+ "customeradd,contactno,orderquantity,unitprice,printsizewidth,"
//				+ "printsizehigh,printcolors,paperquantity,"
//				+ "fhpro from orderxx where fhpro='未完成' order by orderdate desc");
//	}

	// -----------

	public Shujuku() {
		this.ct = null;
		try {
			Class.forName(this.driver);
			this.ct = DriverManager.getConnection(this.url, this.user, this.passwd);
		} catch (Exception e) {
		}
		this.f0gongju = new GongJu();
	}

	public Vector searchOrderInfo(String sql) {		
		Vector jilu = new Vector();
		try {
			this.ps = this.ct.prepareStatement(sql);
			this.rs = this.ps.executeQuery();

			ResultSetMetaData meta = this.rs.getMetaData();
			// System.out.println("meta=:"+meta);//-------------
			String[] zdnamesql = new String[meta.getColumnCount()];
			String[] zdtype = new String[meta.getColumnCount()];

			for (int i = 1; i <= meta.getColumnCount(); i++) {
				zdnamesql[i - 1] = new String(meta.getColumnName(i));
				zdtype[i - 1] = new String(meta.getColumnTypeName(i));
			}

			// -------------------------
//			for (int i = 0; i < zdnamesql.length; i++) {
//				System.out.println(zdnamesql[i]);//---------------------
//			}
//			for (int i = 0; i < zdtype.length; i++) {
//				System.out.println(zdtype[i]);//----------------------
//			}
//			// -------------------------

			jilu.add(zdnamesql);
			jilu.add(zdtype);
			
			for (int quantity = 1; this.rs.next() && quantity < 50; quantity++) {
				Vector hang = new Vector();
				for (int i2 = 0; i2 < zdtype.length; i2++) {
//					if (zdtype[i2].equals("nvarchar")) {//原来
					if (zdtype[i2].equals("VARCHAR")) {
						hang.add(this.rs.getString(i2 + 1));
					} else if (zdtype[i2].equals("DECIMAL") && !zdnamesql[i2].equals("unitprice")) {//原来是 numeric
						hang.add(Integer.valueOf(this.rs.getInt(i2 + 1)));
					} else if (zdtype[i2].equals("DECIMAL") && zdnamesql[i2].equals("unitprice")) {//原来是 numeric
						hang.add(NumberFormat.getInstance().format(this.rs.getBigDecimal(i2 + 1)));
					} else if (zdtype[i2].equals("DATETIME")) {//原来是小写的 datetime
						hang.add(this.rs.getDate(i2 + 1, Calendar.getInstance()));
					}
				}
				 //System.out.println(hang);//--------------------------
				jilu.add(hang);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jilu;
	}

	public Vector searchKcInfo(String sql) {
		Vector jilu = new Vector();
		try {
			this.ps = this.ct.prepareStatement(sql);
			this.rs = this.ps.executeQuery();
			ResultSetMetaData meta = this.rs.getMetaData();
			String[] zdnamesql = new String[meta.getColumnCount()];
			String[] zdtype = new String[meta.getColumnCount()];
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				zdnamesql[i - 1] = new String(meta.getColumnName(i));
				zdtype[i - 1] = new String(meta.getColumnTypeName(i));
			}
			jilu.add(zdnamesql);
			jilu.add(zdtype);
			for (int quantity = 1; this.rs.next() && quantity < 50; quantity++) {
				Vector hang = new Vector();
				for (int i2 = 0; i2 < zdtype.length; i2++) {
					if (zdtype[i2].equals("VARCHAR")) {
						hang.add(this.rs.getString(i2 + 1));
					} else if (zdtype[i2].equals("DECIMAL") && !zdnamesql[i2].equals("unitprice")) {
						hang.add(Integer.valueOf(this.rs.getInt(i2 + 1)));
					} else if (zdtype[i2].equals("DECIMAL") && zdnamesql[i2].equals("unitprice")) {
						hang.add(NumberFormat.getInstance().format(this.rs.getBigDecimal(i2 + 1)));
					} else if (zdtype[i2].equals("DATETIME")) {
						hang.add(this.rs.getDate(i2 + 1, Calendar.getInstance()));
					}
				}
				jilu.add(hang);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		new ImageBinary(jilu);
		return jilu;
	}

	public boolean upDate(String sql, Vector<String> upinfo) {
		boolean b = false;
		try {
			new GongJu().dateToDate(upinfo);
			this.ps = this.ct.prepareStatement(sql);
			for (int i = 1; i < upinfo.size(); i++) {
				this.ps.setString(i, upinfo.get(i));
			}
			this.ps.setString(upinfo.size(), upinfo.get(0));
			if (this.ps.executeUpdate() == 1) {
				b = true;
			}
			close();
		} catch (Exception e) {
		}
		return b;
	}

	public boolean insert(String sql, Vector<String> inputdata) {// add order, 开单

//		System.out.println("---a1a2a3----");//------------------------
//
//		System.out.println(sql);
//		for (int i = 0; i < inputdata.size(); i++) {
//			System.out.println(inputdata.get(i));
//		}
//
//		System.out.println("---a1a2a3----");//------------------
		
		boolean b = false;
		try {
			new GongJu().dateToDate(inputdata);
			this.ps = this.ct.prepareStatement(sql);
			for (int i = 1; i <= inputdata.size(); i++) {
				this.ps.setString(i, inputdata.get(i - 1).toString());
			}
			if (this.ps.executeUpdate() == 1) {
				b = true;
			}
			close();
		} catch (Exception e) {
		}
		return b;
	}

	public boolean insertKc(String sql, Vector<String> inputdata) {
		inputdata.set(inputdata.size() - 1, new ImageBinary()
				.base64StringToImage(inputdata.get(inputdata.size() - 1).toString(), new CreatPicName().getPicName()));
		boolean b = false;
		try {
			this.ps = this.ct.prepareStatement(sql);
			for (int i = 1; i <= inputdata.size(); i++) {
				this.ps.setString(i, inputdata.get(i - 1).toString());
			}
			if (this.ps.executeUpdate() == 1) {
				b = true;
			}
			close();
		} catch (Exception e) {
		}
		return b;
	}

	public boolean delete(String sql, Vector<String> value) {
		boolean b = false;
		try {
			this.ps = this.ct.prepareStatement(sql);
			this.ps.setString(1, value.get(0));
			if (this.ps.executeUpdate() == 1) {
				b = true;
			}
			close();
		} catch (Exception e) {
		}
		return b;
	}

	public String userQuery(String sql, Vector<String> paras) {
		String a = "false";
		try {
			this.ps = this.ct.prepareStatement(sql);
			for (int i = 0; i < paras.size(); i++) {
				this.ps.setString(i + 1, paras.get(i));
			}
			this.rs = this.ps.executeQuery();
			if (this.rs.next()) {
				a = this.rs.getString(1);
			}
			close();
		} catch (Exception e) {
		}
		return a;
	}

	public void close() {
		try {
			if (this.rs != null) {
				this.rs.close();
			}
			if (this.ps != null) {
				this.ps.close();
			}
			if (this.ct != null) {
				this.ct.close();
			}
		} catch (Exception e) {
		}
	}
}
