package com.atguigu.shoppingmall.bean;

public class User {
    private int uid;
    private String uname;
    private String upwd;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }

    public void getMessByUname(String uname){

    }

    public boolean isUser(String uname,String upwd){


            if(uname.equals("111111") && upwd.equals("123456")){
                return true;
            }
            else if(uname.equals("112233") && upwd.equals("123456")){
                return true;
            }
            else
                return false;


    }

    public boolean registerUser(String uname,String upwd){
        this.uname = uname;
        this.upwd = upwd;
        return true;
    }
}
