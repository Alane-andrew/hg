package jiemian;

import gongju.GongJu;
import gongju.If_notEdit;
import gongju.If_notNeed;
import gongju.LiemingAndRemarks;
import gongju.OrderInfo;
import gongju.SqlOrderInfoShow;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import moshi.CaoZuo;
import zidingyi.SPanel;

public class Xiugai extends JDialog implements ActionListener {
	String[] lucog;
	String[] zdnamesql;
	String[] zdtype;
	JLabel[] bq_remarks;
	OrderInfo data;
	int hang;
	Vector zdname_value;
	Vector zdname_sql;
	SqlOrderInfoShow sois;
	Vector<JLabel> bq = new Vector<>();
	CaoZuo cz = new CaoZuo();
	ArrayList wbkjcblist = new ArrayList();
	If_notEdit if_notedit = new If_notEdit();

	GongJu f10gongju = new GongJu();
	boolean uptable = false;
	JButton an1 = new JButton("提交");
	JButton an2 = new JButton("取消");

	public Xiugai(Frame fck, String ckm, Boolean msck, OrderInfo orderinfo, int hang, SqlOrderInfoShow sois) {
		super(fck, ckm, msck.booleanValue());

		//System.out.println(msck);// true ------------------------------------

		this.data = orderinfo;
		this.sois = sois;
		this.hang = hang;
		this.zdnamesql = this.data.getZdnamesql();
		this.zdtype = this.data.getZdtype();

		//System.out.println(Arrays.toString(zdtype));// ---------------------

		this.an1.addActionListener(this);
		this.an1.setActionCommand("tijiao");
		this.an2.addActionListener(this);
		this.an2.setActionCommand("quxiao");
		if (sois.getPower().equals("老总")) {
			this.an1.setEnabled(false);
		}
		Vector orderdata = new If_notNeed().notNeed(this.data, this.zdnamesql, hang);
		this.zdname_sql = (Vector) orderdata.get(0);
		this.zdname_value = (Vector) orderdata.get(1);
		Vector ziduan = (Vector) orderdata.get(2);
		this.lucog = new String[] { "lamination", "uv", "cut", "oil", "glue" };
//		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyy");// --------------------------------
		
		for (int i = 0; i < this.zdname_sql.size(); i++) {
			if (this.zdname_sql.get(i).equals(this.lucog[0]) || this.zdname_sql.get(i).equals(this.lucog[1])
					|| this.zdname_sql.get(i).equals(this.lucog[2]) || this.zdname_sql.get(i).equals(this.lucog[3])
					|| this.zdname_sql.get(i).equals(this.lucog[4])) {
				JCheckBox b = new JCheckBox(this.zdname_value.get(i).toString());
				b.setEnabled(notEnEdit(this.zdname_sql.get(i).toString()));// 根据字段，设置哪些文本框不能编辑
				if (this.zdname_value.get(i).toString().equals("未完成")) {
					b.setSelected(false);
				} else if (this.zdname_value.get(i).toString().equals("已完成")) {
					b.setSelected(true);
				}
				b.addActionListener(this);
				b.setActionCommand(this.zdname_sql.get(i).toString());
				b.setName(this.zdname_sql.get(i).toString());
				b.setBounds(150, 50 + (i * 40), 200, 30);
				this.wbkjcblist.add(b);
			} else {
				JTextField a = new JTextField(15);
				a.setText(this.zdname_value.get(i).toString());
//				a.setEditable(notEnEdit(this.zdname_sql.get(i).toString()));// 根据字段，设置哪些文本框不能编辑
				a.setEnabled(notEnEdit(this.zdname_sql.get(i).toString()));//-------test---设置文本框不可操作-----
				a.setBounds(150, 50 + (i * 40), 200, 30);
				if (this.zdname_sql.get(i).equals("tybname")) {
					if (this.zdname_value.get(i).equals("暂无数据")) {
						a.setText("按 回车键 选择...");
						a.setForeground(Color.lightGray);
					}
					a.addActionListener(this);
					a.setActionCommand("tybname");
				}
				this.wbkjcblist.add(a);
			}
			JLabel dd = new JLabel(String.valueOf(ziduan.get(i).toString()) + "：");
			dd.setBounds(20, 50 + (i * 40), 120, 30);
			this.bq.add(dd);
		}

//		System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");// --------------------------------
//
//		System.out.println("zdname_sql=:" + this.zdname_sql.toString());// --------------------------------
//		System.out.println("zdname_value=:" + this.zdname_value.toString());// --------------------------------
//		System.out.println("wbkjcblist=:" + this.wbkjcblist.size());// 12 --------------------------------

//        for (int i =0; i<wbkjcblist.size();i++) {//------------------------------
//        		System.out.println(wbkjcblist.get(i).getClass());
//        		System.out.println(wbkjcblist.get(i));
//        	}//--------------

		this.if_notedit.judge(this.zdname_sql, this.zdname_value, this.wbkjcblist);// 这行代码有问题
		//System.out.println("eeeeeeeeeeeeeeeeeeeeee1111");// --------------------------------
		String[] remarks = new String[this.zdname_sql.size()];// remarks 的作用是什么？
		//System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");// --------------------------------
		for (int i2 = 0; i2 < remarks.length; i2++) {
			remarks[i2] = this.zdname_sql.get(i2).toString();
			//System.out.println(remarks[i2]);// -----------------------------
		}
		//System.out.println("fffffffffffffffffffffffffffffffffff");// --------------------------------
		this.bq_remarks = new JLabel[remarks.length];
		SPanel smb = new SPanel(this.zdname_value, this.wbkjcblist, this.an1);
		for (int i3 = 0; i3 < this.bq_remarks.length; i3++) {
			this.bq_remarks[i3] = new JLabel(new LiemingAndRemarks().remarksConfirm(remarks)[i3]);
			this.bq_remarks[i3].setForeground(Color.GRAY);// 设置标签的字体颜色
			this.bq_remarks[i3].setBounds(370, 50 + (i3 * 40), 200, 30);
			smb.add(this.bq_remarks[i3]);
		}
		//System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");// --------------------------------
		for (int i4 = 0; i4 < this.bq.size(); i4++) {
			smb.add((Component) this.bq.get(i4));
		}
		for (int i5 = 0; i5 < this.wbkjcblist.size(); i5++) {
			if (this.wbkjcblist.get(i5).getClass().toString().equals("class javax.swing.JTextField")) {
				smb.add((JTextField) this.wbkjcblist.get(i5));
			} else if (this.wbkjcblist.get(i5).getClass().toString().equals("class javax.swing.JCheckBox")) {
				smb.add((JCheckBox) this.wbkjcblist.get(i5));
			}
		}

//		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");// --------------------------------

		JPanel mb1 = new JPanel();
		mb1.add(this.an1);
		mb1.add(this.an2);
		smb.setPreferredSize(new Dimension(670, 50 + (this.bq.size() * 40) + 50));
		JScrollPane jsp = new JScrollPane(smb);
		jsp.getVerticalScrollBar().setUnitIncrement(10);
		jsp.setVerticalScrollBarPolicy(20);
		jsp.setHorizontalScrollBarPolicy(31);
		jsp.setLocation(0, 0);
		//System.out.println("ccccccccccc");// --------------------------------
		add(jsp);
		add(mb1, "South");
		setSize(670, 770);
		setLocation(401, 50);
		setResizable(false);
		//System.out.println("ddddddddddddddd");// --------------------------------
		setVisible(true);
		//System.out.println("sssssssssssssssssssssssssssssssssssss");// 弹窗关闭后，这行代码会打印出来 ------------
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("lamination")) {
			this.if_notedit.lam_judge(this.zdname_sql, this.wbkjcblist);
		} else if (e.getActionCommand().equals("uv")) {
			this.if_notedit.uv_judge(this.zdname_sql, this.wbkjcblist);
		} else if (e.getActionCommand().equals("cut")) {
			this.if_notedit.cut_judge(this.zdname_sql, this.wbkjcblist);
		} else if (e.getActionCommand().equals("oil")) {
			this.if_notedit.oil_judge(this.zdname_sql, this.wbkjcblist);
		} else if (e.getActionCommand().equals("glue")) {
			this.if_notedit.glue_judge(this.zdname_sql, this.wbkjcblist);
		}
		if (e.getActionCommand().equals("tybname")) {
			new SelectTyb(this, true, this.wbkjcblist, this.zdname_sql);
		} else if (e.getActionCommand().equals("tijiao")) {
			Vector<String> wbkv = new Vector<>();
			for (int i = 0; i < this.wbkjcblist.size(); i++) {
				if (this.wbkjcblist.get(i).getClass().toString().equals("class javax.swing.JTextField")) {
					wbkv.add(((JTextField) this.wbkjcblist.get(i)).getText().trim());
				} else if (this.wbkjcblist.get(i).getClass().toString().equals("class javax.swing.JCheckBox")) {
					if (((JCheckBox) this.wbkjcblist.get(i)).isSelected()) {
						wbkv.add("已完成");
					} else {
						wbkv.add("未完成");
					}
				}
			}
			if (aaajudge(this.zdname_sql, wbkv)) {
				Vector up = this.f10gongju.compareData(this.zdname_sql, this.zdname_value, wbkv);
				Vector<String> upzd = (Vector) up.get(0);
				Vector<String> upinfo = (Vector) up.get(1);
				if (upzd.size() == 1) {
					dispose();
					return;
				}
				if (this.f10gongju.proDataFinished(wbkv)) {
					upzd.add(this.sois.getPro_date_sql()[0]);
					upzd.add(this.sois.getPro_date_sql()[1]);
					upinfo.add("已完成");
					upinfo.add("date");
					if (this.sois.getPower().equals("发货")) {
						upzd.add(this.sois.getOrderProDate()[0]);
						upzd.add(this.sois.getOrderProDate()[1]);
						upinfo.add("已完成");
						upinfo.add("date");
					}
				}
				String sql = this.f10gongju.getUpdateSql(upzd);
				if (this.cz.moOrderInfo(sql, upinfo)) {
					this.uptable = this.cz.moOrderInfo(sql, upinfo);
					dispose();
					return;
				}
				JOptionPane.showMessageDialog(this, "\n失败！ 请检查各项数据！\n或者 联系管理员！\n   ", "消息", 2);
			}
		} else if (e.getActionCommand().equals("quxiao")) {
//			System.out.println("kkkkk11");
			dispose();
		}
	}

	public boolean notEnEdit(String ziduan) {// 根据字段，设置哪些文本框不能编辑

		// ------test-----------------------------------------------------------------
//        for (int j = 0; j < this.wbkjcblist.size(); j++) {
//            if (this.wbkjcblist.get(j).getClass().toString().equals("class javax.swing.JTextField")) {
////            	System.out.println("111111111111");
//            	//System.out.println(((JTextField) wbkjcblist.get(j)).toString());
//                ((JTextField) this.wbkjcblist.get(j)).setEnabled(false);//文本框 不可修改，不可选中，灰色
//            } else if (this.wbkjcblist.get(j).getClass().toString().equals("class javax.swing.JCheckBox")) {
////            	System.out.println("222222222222");
//            	//System.out.println(((JCheckBox) wbkjcblist.get(j)).toString());
//                ((JCheckBox) this.wbkjcblist.get(j)).setEnabled(false);
//            }
//        }		
		// ------test----------------------------------------------------------------

		for (int j = 0; j < this.sois.getNotedit().length; j++) {
			if (this.sois.getNotedit()[j].equals(ziduan)) {
				return false;
			}
		}
		return true;
	}

	public boolean aaajudge(Vector zdname_sql, Vector<String> wbkv) {
		boolean b = true;
		for (int i = 0; i < wbkv.size(); i++) {
			for (int j = 0; j < this.lucog.length; j++) {
				if (zdname_sql.get(i).equals(this.lucog[j]) && wbkv.get(i).equals("已完成")) {
					b = bbb(zdname_sql, wbkv, this.lucog[j]);
					if (!b) {
						return b;
					}
				}
			}
		}
		return b;
	}

	public boolean bbb(Vector zdname_sql, Vector<String> wbkv, String name) {
		if (name.equals("lamination")) {
			for (int i = 0; i < wbkv.size(); i++) {
				if ((zdname_sql.get(i).equals("lamfdate") || zdname_sql.get(i).toString().equals("lamoutput"))
						&& wbkv.get(i).equals("暂无数据")) {
					JOptionPane.showMessageDialog(this, "\n覆膜完工日期 和 覆膜正品数量  需填写完整 ！！\n      ", "消息", 2);
					return false;
				}
			}
		} else if (name.equals("uv")) {
			for (int i2 = 0; i2 < wbkv.size(); i2++) {
				if ((zdname_sql.get(i2).equals("uvfdate") || zdname_sql.get(i2).toString().equals("uvoutput"))
						&& wbkv.get(i2).equals("暂无数据")) {
					JOptionPane.showMessageDialog(this, "\nUV完工日期 和 UV正品数量  需填写完整 ！！\n      ", "消息", 2);
					return false;
				}
			}
		} else if (name.equals("cut")) {
			for (int i3 = 0; i3 < wbkv.size(); i3++) {
				if ((zdname_sql.get(i3).equals("cfdate") || zdname_sql.get(i3).toString().equals("cutoutput")
						|| zdname_sql.get(i3).toString().equals("cutmodelno")) && wbkv.get(i3).equals("暂无数据")) {
					JOptionPane.showMessageDialog(this, "\n模切完工日期, 模切正品数量 和 刀版号  需填写完整 ！！\n      ", "消息", 2);
					return false;
				}
			}
		} else if (name.equals("oil")) {
			for (int i4 = 0; i4 < wbkv.size(); i4++) {
				if ((zdname_sql.get(i4).equals("oilfdate") || zdname_sql.get(i4).toString().equals("oiloutput"))
						&& wbkv.get(i4).equals("暂无数据")) {
					JOptionPane.showMessageDialog(this, "\n上光完工日期 和 上光正品数量  需填写完整 ！！\n      ", "消息", 2);
					return false;
				}
			}
		} else if (name.equals("glue")) {
			for (int i5 = 0; i5 < wbkv.size(); i5++) {
				if ((zdname_sql.get(i5).equals("gluefdate") || zdname_sql.get(i5).toString().equals("glueoutput"))
						&& wbkv.get(i5).equals("暂无数据")) {
					JOptionPane.showMessageDialog(this, "\n糊口完工日期 和 糊口正品数量  需填写完整 ！！\n      ", "消息", 2);
					return false;
				}
			}
		}
		return true;
	}
}