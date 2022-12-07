package interactivedata;

import java.io.Serializable;
import java.util.Vector;

public class ActiveData implements Serializable {
    private static final long serialVersionUID = 3450064362986273896L;
    private boolean b;
    private String action;
    private String sql;
    private Vector<String> value;
    private Vector info;
    private String result;

    public void setB(boolean b) {
        this.b = b;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public void setValue(Vector<String> value) {
        this.value = value;
    }

    public void setInfo(Vector info) {
        this.info = info;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean getB() {
        return this.b;
    }

    public String getAction() {
        return this.action;
    }

    public String getSql() {
        return this.sql;
    }

    public Vector<String> getValue() {
        return this.value;
    }

    public Vector getInfo() {
        return this.info;
    }

    public String getResult() {
        return this.result;
    }
}