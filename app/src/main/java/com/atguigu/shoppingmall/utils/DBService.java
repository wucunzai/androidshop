package com.atguigu.shoppingmall.utils;


import com.atguigu.shoppingmall.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBService {

    private Connection conn=null; //打开数据库对象
    private PreparedStatement ps=null;//操作整合sql语句的对象
    private ResultSet rs=null;//查询结果的集合

    //DBService 对象
    public static DBService dbService=null;





    public DBService(){

    }

    /**
     * 获取MySQL数据库单例类对象
     * */

    public static DBService getDbService(){
        if(dbService==null){
            dbService=new DBService();
        }
        return dbService;
    }


    /**
     * 获取要发送短信的患者信息    查
     * */

    public User getUserDataByUname(String uname){
        //结果存放集合
        //MySQL 语句
        String sql="select * from user where uname='"+uname+"'";
        User u=new User();
        //获取链接数据库对象
        conn= DBOpenHelper.getConn();
        try {
            if(conn!=null&&(!conn.isClosed())){
                ps= (PreparedStatement) conn.prepareStatement(sql);
                if(ps!=null){
                    rs= ps.executeQuery();
                    if(rs!=null){
                        while(rs.next()){
                            u.setUid(rs.getInt("uid"));
                            u.setUname(rs.getString("uname"));
                            u.setUpwd(rs.getString("upwd"));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBOpenHelper.closeAll(conn,ps,rs);//关闭相关操作
        return u;
    }

    /**
     * 修改数据库中某个对象的状态   改
     * */

    /*public int updateUserData(String phone){
        int result=-1;
        if(!StringUtils.isEmpty(phone)){
            //获取链接数据库对象
            conn= DBOpenHelper.getConn();
            //MySQL 语句
            String sql="update user set state=? where phone=?";
            try {
                boolean closed=conn.isClosed();
                if(conn!=null&&(!closed)){
                    ps= (PreparedStatement) conn.prepareStatement(sql);
                    ps.setString(1,"1");//第一个参数state 一定要和上面SQL语句字段顺序一致
                    ps.setString(2,phone);//第二个参数 phone 一定要和上面SQL语句字段顺序一致
                    result=ps.executeUpdate();//返回1 执行成功
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBOpenHelper.closeAll(conn,ps);//关闭相关操作
        return result;
    }*/

    /**
     * 批量向数据库插入数据   增
     * */

    public int insertUserData(User user){
        int result=-1;

            //获取链接数据库对象
            conn= DBOpenHelper.getConn();
            //MySQL 语句
            String sql="INSERT INTO user (uname,upwd,ubalance) VALUES (?,?,?)";
            try {
                boolean closed=conn.isClosed();
                if((conn!=null)&&(!closed)){

                        ps= (PreparedStatement) conn.prepareStatement(sql);
                        String name=user.getUname();
                        String pwd=user.getUpwd();
                        ps.setString(1,name);//第一个参数 name 规则同上
                        ps.setString(2,pwd);//第二个参数 phone 规则同上
                        result=ps.executeUpdate();//返回1 执行成功

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        DBOpenHelper.closeAll(conn,ps);//关闭相关操作
        return result;
    }


    /**
     * 删除数据  删
     * */

    /*public int delUserData(String phone){
        int result=-1;
        if((!StringUtils.isEmpty(phone))&&(PhoneNumberUtils.isMobileNumber(phone))){
            //获取链接数据库对象
            conn= DBOpenHelper.getConn();
            //MySQL 语句
            String sql="delete from user where phone=?";
            try {
                boolean closed=conn.isClosed();
                if((conn!=null)&&(!closed)){
                    ps= (PreparedStatement) conn.prepareStatement(sql);
                    ps.setString(1, phone);
                    result=ps.executeUpdate();//返回1 执行成功
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBOpenHelper.closeAll(conn,ps);//关闭相关操作
        return result;
    }*/

}

