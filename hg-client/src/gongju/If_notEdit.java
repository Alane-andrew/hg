package gongju;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class If_notEdit {
    public void lam_judge(Vector zdname_sql, ArrayList wbkjcblist) {
        for (int i = 0; i < wbkjcblist.size(); i++) {
            if (wbkjcblist.get(i).getClass().toString().equals("class javax.swing.JCheckBox") && ((JCheckBox) wbkjcblist.get(i)).getName().equals("lamination")) {
                if (((JCheckBox) wbkjcblist.get(i)).isSelected()) {
                    for (int j = 0; j < zdname_sql.size(); j++) {
                        if (zdname_sql.get(j).equals("lamfdate") || zdname_sql.get(j).equals("lamoutput")) {
                            ((JTextField) wbkjcblist.get(j)).setEditable(true);
                        }
                    }
                } else {
                    for (int j2 = 0; j2 < zdname_sql.size(); j2++) {
                        if (zdname_sql.get(j2).equals("lamfdate") || zdname_sql.get(j2).equals("lamoutput")) {
                            ((JTextField) wbkjcblist.get(j2)).setEditable(false);
                        }
                    }
                }
            }
        }
    }

    public void uv_judge(Vector zdname_sql, ArrayList wbkjcblist) {
        for (int i = 0; i < wbkjcblist.size(); i++) {
            if (wbkjcblist.get(i).getClass().toString().equals("class javax.swing.JCheckBox") && ((JCheckBox) wbkjcblist.get(i)).getName().equals("uv")) {
                if (((JCheckBox) wbkjcblist.get(i)).isSelected()) {
                    for (int j = 0; j < zdname_sql.size(); j++) {
                        if (zdname_sql.get(j).equals("uvfdate") || zdname_sql.get(j).equals("uvoutput")) {
                            ((JTextField) wbkjcblist.get(j)).setEditable(true);
                        }
                    }
                } else {
                    for (int j2 = 0; j2 < zdname_sql.size(); j2++) {
                        if (zdname_sql.get(j2).equals("uvfdate") || zdname_sql.get(j2).equals("uvoutput")) {
                            ((JTextField) wbkjcblist.get(j2)).setEditable(false);
                        }
                    }
                }
            }
        }
    }

    public void cut_judge(Vector zdname_sql, ArrayList wbkjcblist) {
        for (int i = 0; i < wbkjcblist.size(); i++) {
            if (wbkjcblist.get(i).getClass().toString().equals("class javax.swing.JCheckBox") && ((JCheckBox) wbkjcblist.get(i)).getName().equals("cut")) {
                if (((JCheckBox) wbkjcblist.get(i)).isSelected()) {
                    for (int j = 0; j < zdname_sql.size(); j++) {
                        if (zdname_sql.get(j).equals("cfdate") || zdname_sql.get(j).equals("cutoutput") || zdname_sql.get(j).equals("cutmodelno")) {
                            ((JTextField) wbkjcblist.get(j)).setEditable(true);
                        }
                    }
                } else {
                    for (int j2 = 0; j2 < zdname_sql.size(); j2++) {
                        if (zdname_sql.get(j2).equals("cfdate") || zdname_sql.get(j2).equals("cutoutput") || zdname_sql.get(j2).equals("cutmodelno")) {
                            ((JTextField) wbkjcblist.get(j2)).setEditable(false);
                        }
                    }
                }
            }
        }
    }

    public void oil_judge(Vector zdname_sql, ArrayList wbkjcblist) {
        for (int i = 0; i < wbkjcblist.size(); i++) {
            if (wbkjcblist.get(i).getClass().toString().equals("class javax.swing.JCheckBox") && ((JCheckBox) wbkjcblist.get(i)).getName().equals("oil")) {
                if (((JCheckBox) wbkjcblist.get(i)).isSelected()) {
                    for (int j = 0; j < zdname_sql.size(); j++) {
                        if (zdname_sql.get(j).equals("oilfdate") || zdname_sql.get(j).equals("oiloutput")) {
                            ((JTextField) wbkjcblist.get(j)).setEditable(true);
                        }
                    }
                } else {
                    for (int j2 = 0; j2 < zdname_sql.size(); j2++) {
                        if (zdname_sql.get(j2).equals("oilfdate") || zdname_sql.get(j2).equals("oiloutput")) {
                            ((JTextField) wbkjcblist.get(j2)).setEditable(false);
                        }
                    }
                }
            }
        }
    }

    public void glue_judge(Vector zdname_sql, ArrayList wbkjcblist) {
        for (int i = 0; i < wbkjcblist.size(); i++) {
            if (wbkjcblist.get(i).getClass().toString().equals("class javax.swing.JCheckBox") && ((JCheckBox) wbkjcblist.get(i)).getName().equals("glue")) {
                if (((JCheckBox) wbkjcblist.get(i)).isSelected()) {
                    for (int j = 0; j < zdname_sql.size(); j++) {
                        if (zdname_sql.get(j).equals("gluefdate") || zdname_sql.get(j).equals("glueoutput")) {
                            ((JTextField) wbkjcblist.get(j)).setEditable(true);
                        }
                    }
                } else {
                    for (int j2 = 0; j2 < zdname_sql.size(); j2++) {
                        if (zdname_sql.get(j2).equals("gluefdate") || zdname_sql.get(j2).equals("glueoutput")) {
                            ((JTextField) wbkjcblist.get(j2)).setEditable(false);
                        }
                    }
                }
            }
        }
    }

    public void judge(Vector zdname_sql, Vector zdname_value, ArrayList wbkjcblist) {//原来的编译
        //System.out.println("---------aaaaaa----------");
        String[] aa = {"lamedate", "uvedate", "cedate", "oiledate", "glueedate"};
        for (int i = 0; i < zdname_sql.size(); i++) {
            int j = 0;
            while (true) {
                if (j < aa.length) {
                    if (zdname_sql.get(i).toString().equals(aa[j])) {
                        String bb = zdname_value.get(i).toString();
                        String cc = aa[j];
                        if (bb.equals("暂无数据")) {
                        	j++;//新增
                            sonJudge(zdname_sql, wbkjcblist, cc, false);
                        } else {
                        	j++;//新增
                            sonJudge(zdname_sql, wbkjcblist, cc, true);
                        }
                    } else {
                        j++;
                    }
                } else {
                	break;//跳出while循环 ----新增
                }
            }
        }
    }

    public void sonJudge(Vector zdname_sql, ArrayList wbkjcblist, String cc, boolean b) {
    	//System.out.println("111111111111111111111111-----------222222222");//没打印出来 ---------------------
        if (cc.equals("lamedate")) {
            for (int i = 0; i < zdname_sql.size(); i++) {
                if (zdname_sql.get(i).equals("lamination")) {
                    ((JCheckBox) wbkjcblist.get(i)).setEnabled(b);
                } else if (zdname_sql.get(i).equals("lamfdate") || zdname_sql.get(i).equals("lamoutput")) {
                    ((JTextField) wbkjcblist.get(i)).setEditable(false);
                }
            }
        } else if (cc.equals("uvedate")) {
            for (int i2 = 0; i2 < zdname_sql.size(); i2++) {
                if (zdname_sql.get(i2).equals("uv")) {
                    ((JCheckBox) wbkjcblist.get(i2)).setEnabled(b);
                } else if (zdname_sql.get(i2).equals("uvfdate") || zdname_sql.get(i2).equals("uvoutput")) {
                    ((JTextField) wbkjcblist.get(i2)).setEditable(false);
                }
            }
        } else if (cc.equals("cedate")) {
            for (int i3 = 0; i3 < zdname_sql.size(); i3++) {
                if (zdname_sql.get(i3).equals("cut")) {
                    ((JCheckBox) wbkjcblist.get(i3)).setEnabled(b);
                } else if (zdname_sql.get(i3).equals("cfdate") || zdname_sql.get(i3).equals("cutoutput") || zdname_sql.get(i3).equals("cutmodelno")) {
                    ((JTextField) wbkjcblist.get(i3)).setEditable(false);
                }
            }
        } else if (cc.equals("oiledate")) {
            for (int i4 = 0; i4 < zdname_sql.size(); i4++) {
                if (zdname_sql.get(i4).equals("oil")) {
                    ((JCheckBox) wbkjcblist.get(i4)).setEnabled(b);
                } else if (zdname_sql.get(i4).equals("oilfdate") || zdname_sql.get(i4).equals("oiloutput")) {
                    ((JTextField) wbkjcblist.get(i4)).setEditable(false);
                }
            }
        } else if (cc.equals("glueedate")) {
            for (int i5 = 0; i5 < zdname_sql.size(); i5++) {
                if (zdname_sql.get(i5).equals("glue")) {
                    ((JCheckBox) wbkjcblist.get(i5)).setEnabled(b);
                } else if (zdname_sql.get(i5).equals("gluefdate") || zdname_sql.get(i5).equals("glueoutput")) {
                    ((JTextField) wbkjcblist.get(i5)).setEditable(false);
                }
            }
        }
    }

    public void kaiDanNotEdit(JTextField[] wbk, String[] ename) {
        for (int i = 0; i < ename.length; i++) {
            if (ename[i].equals("customeradd") || ename[i].equals("contactno")) {
            	//System.out.println("dddddddddddddddddd123");//-------------------------
                wbk[i].setEditable(false);
            }
        }
    }
}