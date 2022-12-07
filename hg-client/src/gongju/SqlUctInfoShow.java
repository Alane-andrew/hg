package gongju;

public class SqlUctInfoShow {
    private String uctsql;

    public SqlUctInfoShow(String type) {
        if (type.equals("user")) {
            this.uctsql = "select * from userinfo";
        } else if (type.equals("customer")) {
            this.uctsql = "select * from kehuinfo";
        } else if (type.equals("tyb")) {
            this.uctsql = "select * from tybinfo";
        }
    }

    public String getUctSql() {
        return this.uctsql;
    }
}