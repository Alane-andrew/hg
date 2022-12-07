package gongju;

import java.util.Vector;

public class LiemingAndRemarks {
    String[] ename = {"orderno", "customername", "orderdate", "orderquantity", "unitprice", "printsizewidth", "printsizehigh", "printcolors", "lamination", "uv", "cut", "oil", "glue", "laminationinfo", "paperquantity", "paperrealease", "printoutput", "pedate", "pfdate", "edelivery", "delivery", "deliveryquantity", "tcartons", "cutmodelno", "cfdate", "cutoutput", "cedate", "lamfdate", "lamedate", "lamoutput", "uvfdate", "uvedate", "uvoutput", "oilfdate", "oiledate", "oiloutput", "gluefdate", "glueedate", "glueoutput", "yspro", "ysprodate", "hdpro", "hdprodate", "fhpro", "fhprodate", "cgpro", "cgprodate", "orderpro", "orderprodate", "customeradd", "contactno", "tybname", "tybadd", "tybcontactno"};
    String[] cname = {"订单编号", "客户名称", "下单日期", "定单数量", "产品单价", "纸张印刷宽度", "纸张印刷高度", "几色印刷", "覆膜", "UV", "模切", "上光", "糊口", "覆膜要求", "纸张数量", "印刷放数", "印刷正品数量", "预计印刷日期", "印刷完工日期", "预计发货日期", "发货日期", "发货数量", "发货总件数", "刀版号", "模切完工日期", "模切正品数量", "预计模切日期", "覆膜完工日期", "预计覆膜日期", "覆膜正品数量", "UV完工日期", "预计UV日期", "UV正品数量", "上光完工日期", "预计上光日期", "上光正品数量", "糊口完工日期", "预计糊口日期", "糊口正品数量", "印刷流程", "印刷流程完工日期", "后道流程", "后道流程完工日期", "发货流程", "发货流程完工日期", "仓管流程", "仓管流程完工日期", "全单流程", "全单流程完工日期", "客户发货地址", "发货联系电话", "托运部名称", "托运部地址", "托运部联系电话"};
    String[] remarks = {"英文字母 和 数字，如： abc113456", "", "时间格式 如：2016-12-12", "单位： 个", "人民币，小数点后两位，如：1.25", "单位： cm", "单位： cm", "范围： 1--8 个位数", "如已完成，打钩！", "如已完成，打钩！", "如已完成，打钩！", "如已完成，打钩！", "如已完成，打钩！", "", "单位： 张", "单位： 张   数字1--999", "单位： 张", "时间格式 如：2016-12-12", "时间格式 如：2016-12-12", "时间格式 如：2016-12-12", "时间格式 如：2016-12-12", "单位： 个", "单位： 件", "英文、数字、横杆", "时间格式 如：2016-12-12", "单位： 张", "时间格式 如：2016-12-12", "时间格式 如：2016-12-12", "时间格式 如：2016-12-12", "单位： 张", "时间格式 如：2016-12-12", "时间格式 如：2016-12-12", "单位： 张", "时间格式 如：2016-12-12", "时间格式 如：2016-12-12", "单位： 张", "时间格式 如：2016-12-12", "时间格式 如：2016-12-12", "单位： 张", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    String[] kehuename = {"customername", "customeradd", "contactno"};
    String[] kehucname = {"客户名称", "客户发货地址", "发货联系电话"};
    String[] tybename = {"tybname", "tybadd", "tybcontactno"};
    String[] tybcname = {"托运部名称", "托运部地址", "托运部联系电话"};
    String[] userename = {"username", "pw", "authority"};
    String[] usercname = {"用户名", "密码", "权限"};

    public String[] liemingConfirm(String[] ziduansql) {
        String[] n_confirmed = new String[ziduansql.length];
        for (int i = 0; i < ziduansql.length; i++) {
            int j = 0;
            while (true) {
                if (j < this.cname.length) {
                    if (ziduansql[i].equals(this.ename[j])) {
                        n_confirmed[i] = this.cname[j];
                        break;
                    }
                    j++;
                }
            }
        }
        return n_confirmed;
    }

    public String[] remarksConfirm(String[] zdnamesql) {
        String[] inputremarks = new String[zdnamesql.length];
        for (int i = 0; i < zdnamesql.length; i++) {
            int j = 0;
            while (true) {
                if (j < this.remarks.length) {
                    if (zdnamesql[i].equals(this.ename[j])) {
                        inputremarks[i] = this.remarks[j];
                        break;
                    }
                    j++;
                }
            }
        }
        return inputremarks;
    }

    public Vector<String[]> getKaidanZiduan() {
        String[] kd_ename = {"orderno", "customername", "customeradd", "contactno", "orderquantity", "unitprice", "printsizewidth", "printsizehigh", "printcolors", "paperquantity", "uv", "cut", "oil", "glue", "lamination", "laminationinfo"};
        Vector<String[]> kdziduan = new Vector<>();
        kdziduan.add(kd_ename);
        kdziduan.add(liemingConfirm(kd_ename));
        kdziduan.add(remarksConfirm(kd_ename));
        return kdziduan;
    }

    public String[] uct_liemingConfirm(String[] ziduansql, String type) {
        String[] uctename = new String[0];
        String[] uctcname = new String[0];
        if (type.equals("user")) {
            uctename = this.userename;
            uctcname = this.usercname;
        } else if (type.equals("customer")) {
            uctename = this.kehuename;
            uctcname = this.kehucname;
        } else if (type.equals("tyb")) {
            uctename = this.tybename;
            uctcname = this.tybcname;
        }
        String[] n_confirmed = new String[ziduansql.length];
        for (int i = 0; i < ziduansql.length; i++) {
            int j = 0;
            while (true) {
                if (j < uctcname.length) {
                    if (ziduansql[i].equals(uctename[j])) {
                        n_confirmed[i] = uctcname[j];
                        break;
                    }
                    j++;
                }
            }
        }
        return n_confirmed;
    }

    public Vector<String[]> getUctZiduan(String type) {
        String[] uctename = new String[0];
        if (type.equals("user")) {
            uctename = this.userename;
        } else if (type.equals("customer")) {
            uctename = this.kehuename;
        } else if (type.equals("tyb")) {
            uctename = this.tybename;
        }
        Vector<String[]> kehuziduan = new Vector<>();
        kehuziduan.add(uctename);
        kehuziduan.add(uct_liemingConfirm(uctename, type));
        return kehuziduan;
    }
}