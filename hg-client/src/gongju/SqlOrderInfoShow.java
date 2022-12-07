package gongju;

public class SqlOrderInfoShow {
    private String title;
    private String orderinfosql;
    private String finishedorderinfosql;
    private String orderprocess_sql;
    private String searchorderinfosql;
    private String[] notedit;
    private String power;
    private String[] pro_date_sql;
    private String[] orderpro_date = {"orderpro", "orderprodate"};

    public SqlOrderInfoShow(String power) {
        if (power.equals("老总")) {
            this.title = "宏冠印业-老总管理系统";
            this.orderinfosql = "select orderno,orderdate,customername,customeradd,contactno,orderquantity,unitprice,printsizewidth,printsizehigh,printcolors,paperquantity,fhpro from orderxx where fhpro='未完成' order by orderdate desc";
            this.finishedorderinfosql = "select orderno,orderdate,customername,customeradd,contactno,orderquantity,unitprice,printsizewidth,printsizehigh,printcolors,paperquantity,fhpro,delivery,deliveryquantity,tcartons from orderxx where fhpro='已完成' order by orderdate desc";
            this.orderprocess_sql = "select orderno,orderdate,yspro,ysprodate,lamedate,lamfdate,lamination,uvedate,uvfdate,uv,cedate,cfdate,cut,oiledate,oilfdate,oil,glueedate,gluefdate,glue,hdpro,hdprodate,fhpro,fhprodate from orderxx where orderpro='未完成' order by orderdate desc";
            this.searchorderinfosql = "select orderno,orderdate,customername,customeradd,contactno,orderquantity,unitprice,printsizewidth,printsizehigh,printcolors,paperquantity,lamination,uv,cut,oil,glue,laminationinfo,yspro,hdpro,fhpro from orderxx";
            this.notedit = new String[]{"orderno", "orderdate", "customername", "customeradd", "contactno", "orderquantity", "unitprice", "printsizewidth", "printsizehigh", "printcolors", "paperquantity", "lamination", "uv", "cut", "oil", "glue", "laminationinfo", "yspro", "hdpro", "fhpro", "orderpro", "orderprodate"};
            this.power = power;
        } else if (power.equals("印刷")) {
            this.title = "宏冠印业-印刷管理系统";
            this.orderinfosql = "select orderno,orderdate,orderquantity,paperquantity,paperrealease,printoutput,printsizewidth,printsizehigh,printcolors,pedate,pfdate from orderxx where yspro='未完成' order by orderdate desc";
            this.finishedorderinfosql = "select orderno,orderdate,orderquantity,paperquantity,paperrealease,printoutput,printsizewidth,printsizehigh,printcolors,pedate,pfdate from orderxx where yspro='已完成' order by orderdate desc";
            this.searchorderinfosql = "select orderno,orderdate,orderquantity,paperquantity,paperrealease,printoutput,printsizewidth,printsizehigh,printcolors,pedate,pfdate from orderxx";
            //根据权限，确定哪些字段不能编辑
            this.notedit = new String[]{"orderno", "orderdate", "orderquantity", "paperquantity", "printsizewidth", "printsizehigh", "printcolors"};
            this.power = power;
            this.pro_date_sql = new String[]{"yspro", "ysprodate"};
        } else if (power.equals("后道")) {
            this.title = "宏冠印业-后道管理系统";
            this.orderinfosql = "select orderno,orderdate,printoutput,ysprodate,laminationinfo,lamedate,lamination,lamfdate,lamoutput,uvedate,uv,uvfdate,uvoutput,cedate,cut,cfdate,cutoutput,cutmodelno,oiledate,oil,oilfdate,oiloutput,glueedate,glue,gluefdate,glueoutput from orderxx where yspro='已完成' and hdpro='未完成' order by orderdate desc";
            this.finishedorderinfosql = "select orderno,orderdate,printoutput,ysprodate,laminationinfo,lamedate,lamination,lamfdate,lamoutput,uvedate,uv,uvfdate,uvoutput,cedate,cut,cfdate,cutoutput,cutmodelno,oiledate,oil,oilfdate,oiloutput,glueedate,glue,gluefdate,glueoutput from orderxx where hdpro='已完成' order by orderdate desc";
            this.orderprocess_sql = "select orderno,orderdate,lamedate,lamfdate,lamination,uvedate,uvfdate,uv,cedate,cfdate,cut,oiledate,oilfdate,oil,glueedate,gluefdate,glue from orderxx where hdpro='未完成' and yspro='已完成' order by orderdate desc";
            this.searchorderinfosql = "select orderno,orderdate,printoutput,ysprodate,laminationinfo,lamedate,lamination,lamfdate,lamoutput,uvedate,uv,uvfdate,uvoutput,cedate,cut,cfdate,cutoutput,cutmodelno,oiledate,oil,oilfdate,oiloutput,glueedate,glue,gluefdate,glueoutput from orderxx";
            this.notedit = new String[]{"orderno", "orderdate", "printoutput", "ysprodate", "laminationinfo"};
            this.power = power;
            this.pro_date_sql = new String[]{"hdpro", "hdprodate"};
        } else if (power.equals("发货")) {
            this.title = "宏冠印业-发货管理系统";
            this.orderinfosql = "select orderno,orderdate,customername,orderquantity,unitprice,customeradd,contactno,edelivery,delivery,deliveryquantity,tcartons,tybname,tybadd,tybcontactno from orderxx where fhpro='未完成' order by orderdate desc";
            this.finishedorderinfosql = "select orderno,orderdate,customername,orderquantity,unitprice,customeradd,contactno,edelivery,delivery,deliveryquantity,tcartons,tybname,tybadd,tybcontactno from orderxx where fhpro='已完成' order by orderdate desc";
            this.searchorderinfosql = "select orderno,orderdate,customername,orderquantity,unitprice,customeradd,contactno,edelivery,delivery,deliveryquantity,tcartons,tybname,tybadd,tybcontactno from orderxx";
            this.notedit = new String[]{"orderno", "orderdate", "customername", "orderquantity", "unitprice", "customeradd", "contactno", "tybadd", "tybcontactno"};
            this.power = power;
            this.pro_date_sql = new String[]{"fhpro", "fhprodate"};
        } else if (power.equals("仓管")) {
            this.title = "宏冠印业-仓库管理系统";
            this.orderinfosql = "";
            this.notedit = new String[0];
            this.power = power;
            this.pro_date_sql = new String[]{"cgpro", "cgprodate"};
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String getOrderinfosql() {
        return this.orderinfosql;
    }

    public String getFinishedorderinfosql() {
        return this.finishedorderinfosql;
    }

    public String[] getNotedit() {
        return this.notedit;
    }

    public String getPower() {
        return this.power;
    }

    public String[] getPro_date_sql() {
        return this.pro_date_sql;
    }

    public String getSearchOrderinfosql() {
        return this.searchorderinfosql;
    }

    public String[] getOrderProDate() {
        return this.orderpro_date;
    }

    public String getOrderProcess_Sql() {
        return this.orderprocess_sql;
    }
}