package gongju;

import java.util.Vector;

public class If_notNeed {
    public Vector notNeed(OrderInfo data, String[] zdnamesql, int hang) {
        Vector<String> zdname_sql = new Vector<>();
        for (String str : zdnamesql) {
            zdname_sql.add(str);
        }
        Vector<String> zdname_value = new Vector<>();
        for (int i = 0; i < zdnamesql.length; i++) {
            zdname_value.add(data.getValueAt(hang, i).toString());
        }
        Vector ziduan = data.getZiduan();
        int i2 = 0;
        do {
            if (zdname_sql.get(i2).toString().equals("lamination")) {
                if (zdname_value.get(i2).toString().equals("--无--")) {
                    zdname_sql.remove(i2);
                    zdname_value.remove(i2);
                    ziduan.remove(i2);
                    i2 = 0;
                    int j = 0;
                    do {
                        if (zdname_sql.get(j).toString().equals("lamedate") || zdname_sql.get(j).toString().equals("laminationinfo") || zdname_sql.get(j).toString().equals("lamfdate") || zdname_sql.get(j).toString().equals("lamoutput")) {
                            zdname_sql.remove(j);
                            zdname_value.remove(j);
                            ziduan.remove(j);
                            j = 0;
                        } else {
                            j++;
                        }
                    } while (j < zdname_sql.size());
                }
                i2++;
            } else if (zdname_sql.get(i2).toString().equals("uv")) {
                if (zdname_value.get(i2).toString().equals("--无--")) {
                    zdname_sql.remove(i2);
                    zdname_value.remove(i2);
                    ziduan.remove(i2);
                    i2 = 0;
                    int j2 = 0;
                    do {
                        if (zdname_sql.get(j2).toString().equals("uvedate") || zdname_sql.get(j2).toString().equals("uvfdate") || zdname_sql.get(j2).toString().equals("uvoutput")) {
                            zdname_sql.remove(j2);
                            zdname_value.remove(j2);
                            ziduan.remove(j2);
                            j2 = 0;
                        } else {
                            j2++;
                        }
                    } while (j2 < zdname_sql.size());
                }
                i2++;
            } else if (zdname_sql.get(i2).toString().equals("cut")) {
                if (zdname_value.get(i2).toString().equals("--无--")) {
                    zdname_sql.remove(i2);
                    zdname_value.remove(i2);
                    ziduan.remove(i2);
                    i2 = 0;
                    int j3 = 0;
                    do {
                        if (zdname_sql.get(j3).toString().equals("cedate") || zdname_sql.get(j3).toString().equals("cfdate") || zdname_sql.get(j3).toString().equals("cutoutput") || zdname_sql.get(j3).toString().equals("cutmodelno")) {
                            zdname_sql.remove(j3);
                            zdname_value.remove(j3);
                            ziduan.remove(j3);
                            j3 = 0;
                        } else {
                            j3++;
                        }
                    } while (j3 < zdname_sql.size());
                }
                i2++;
            } else if (zdname_sql.get(i2).toString().equals("oil")) {
                if (zdname_value.get(i2).toString().equals("--无--")) {
                    zdname_sql.remove(i2);
                    zdname_value.remove(i2);
                    ziduan.remove(i2);
                    i2 = 0;
                    int j4 = 0;
                    do {
                        if (zdname_sql.get(j4).toString().equals("oiledate") || zdname_sql.get(j4).toString().equals("oilfdate") || zdname_sql.get(j4).toString().equals("oiloutput")) {
                            zdname_sql.remove(j4);
                            zdname_value.remove(j4);
                            ziduan.remove(j4);
                            j4 = 0;
                        } else {
                            j4++;
                        }
                    } while (j4 < zdname_sql.size());
                }
                i2++;
            } else {
                if (zdname_sql.get(i2).toString().equals("glue") && zdname_value.get(i2).toString().equals("--无--")) {
                    zdname_sql.remove(i2);
                    zdname_value.remove(i2);
                    ziduan.remove(i2);
                    i2 = 0;
                    int j5 = 0;
                    do {
                        if (zdname_sql.get(j5).toString().equals("glueedate") || zdname_sql.get(j5).toString().equals("gluefdate") || zdname_sql.get(j5).toString().equals("glueoutput")) {
                            zdname_sql.remove(j5);
                            zdname_value.remove(j5);
                            ziduan.remove(j5);
                            j5 = 0;
                        } else {
                            j5++;
                        }
                    } while (j5 < zdname_sql.size());
                }
                i2++;
            }
        } while (i2 < zdname_sql.size());
        Vector orderdata = new Vector();
        orderdata.add(zdname_sql);
        orderdata.add(zdname_value);
        orderdata.add(ziduan);
        return orderdata;
    }
}