package com.demo.dao;

import com.demo.bean.User;
import com.demo.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ForMe
 * com.demo.dao
 * 2019/2/10
 * 10:40
 */
public class UserDAo {
    public boolean login(User user){  //登录
        boolean flag = false;
        Connection connection = JDBCUtils.getConn();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user where username=? and password=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                System.out.println("登录成功:" + "username= " + user.getUsername() + " password= " + user.getPassword());
                flag = true;
            }
            else {
                System.out.println("用户名或者密码错误！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtils.close(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public boolean register(User user){ //注册
        boolean flag = false;
        Connection connection = JDBCUtils.getConn();
        PreparedStatement preparedStatement = null;
        String sql = "insert into user (username,password,phonenumber,idnumber) values (?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getPhonenumber());
            preparedStatement.setString(4,user.getIdnumber());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtils.close(connection,preparedStatement,null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public boolean isRegister(String username){
        boolean flag = true;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user where username=?";
        try {
            connection = JDBCUtils.getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                flag = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                JDBCUtils.close(connection,preparedStatement,resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
