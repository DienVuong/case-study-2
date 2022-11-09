package Acount;

import java.io.Serializable;

public class User implements Serializable {
    private String acount;
    private String password;
    private String role1;
    private Role role2;
    public User(String acount, String password){
        this.acount = acount;
        this.password = password;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole1() {
        return role1;
    }

    public void setRole1(String role1) {
        this.role1 = role1;
    }

    public Role getRole2() {
        return role2;
    }

    public void setRole2(Role role2) {
        this.role2 = role2;
    }
}
