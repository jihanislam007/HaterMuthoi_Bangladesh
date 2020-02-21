package mmj.com.jihanislam007.hatermuthoibangladesh.DB.Model;

import io.realm.RealmObject;

public class LoginModel extends RealmObject {

    String user_name;
    String pass;

    public LoginModel() {
    }

    public LoginModel(String user_name, String pass) {
        this.user_name = user_name;
        this.pass = pass;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
