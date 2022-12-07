package interactivedata;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String passwd;

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}