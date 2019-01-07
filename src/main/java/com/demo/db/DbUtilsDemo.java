package com.demo.db;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 张亚飞 on 2019/1/7.
 */
public class DbUtilsDemo {
    private static final String CONNECTION_DRIVER_STR= "com.mysql.jdbc.Driver";
    private static final String CONNECTION_STR= "jdbc:mysql://localhost:3306/test";

    private static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(CONNECTION_DRIVER_STR);
            conn = DriverManager.getConnection(CONNECTION_STR, "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 插入数据库一个新的visitor
     * ScalarHandler的demo
     * @param visitor
     */
    public static void insertVisitor(Visitor visitor) {
        Connection conn = getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "insert into visitor (Name, Email, Status, CreateTime) values (?, ?, ?, ?)";
        try {
            int count = qr.update(conn, sql, visitor.getName(), visitor.getEmail(), 1, new Date());
            BigInteger newId = (BigInteger) qr.query(conn, "select last_insert_id()", new ScalarHandler<BigInteger>(1));
            visitor.setId(Integer.valueOf(String.valueOf(newId)));
            System.out.println("新增" + count + "条数据=>Id：" + newId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteVisitor(int id) {
        Connection conn = getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "delete from visitor where status>0 and id=?";
        try {
            int count = qr.update(conn, sql, id);
            System.out.println("删除" + count + "条数据。");
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static Visitor retrieveVisitor(int id) {
        Connection conn = getConnection();
        Visitor visitor = null;
        QueryRunner qr = new QueryRunner();
        String sql = "select * from visitor where status>0 and id=?";
        try {
            visitor = (Visitor) qr.query(conn, sql, new BeanHandler<Visitor>(Visitor.class), id);
            System.out.println(visitor);
            return visitor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return visitor;
    }

    public static void updateVisitor(int id) {
        Visitor visitor = retrieveVisitor(id);
        System.out.println("更新前：" + visitor);
        Connection conn = getConnection();
        String updateFieldStr = visitor.getName();
        QueryRunner qr = new QueryRunner();
        String sql = "update visitor set Name = ?, Email = ?, Status = ?, CreateTime = ? where status>0 and Id = ?";
        if (updateFieldStr.contains("updated")) {
            updateFieldStr = updateFieldStr.substring(0, updateFieldStr.indexOf("updated"));
        } else {
            updateFieldStr = updateFieldStr + "updated";
        }
        visitor.setName(updateFieldStr);
        try {
            int count = qr.update(conn, sql, new Object[] { visitor.getName(), visitor.getName(), visitor.getStatus(),
                    visitor.getCreateTime(), visitor.getId() });
            System.out.println("更新了" + count + "条数据");
            System.out.println("更新后：" + visitor);
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void getVisitorList() {
        Connection conn = getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "select * from visitor where status>0";
        try {
            List<Visitor> ls = qr.query(conn, sql, new BeanListHandler<Visitor>(Visitor.class));
            for (Visitor visitor : ls) {
                System.out.println(visitor);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void getVisitWithMap(int id) {
        Connection conn = getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "select * from visitor where status>0 and id=?";
        try {
            Map<String, Object> map = qr.query(conn, sql, new MapHandler(), id);
            Integer visitorId = Integer.valueOf(map.get("Id").toString());
            String visitorName = map.get("Name").toString();
            String visitorEmail = map.get("Email").toString();
            Integer visitorStatus = Integer.valueOf(map.get("Status").toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date visitorCreateTime = sdf.parse(map.get("CreateTime").toString());
            Visitor visitor = new Visitor(visitorName, visitorEmail);
            visitor.setId(visitorId);
            visitor.setStatus(visitorStatus);
            visitor.setCreateTime(visitorCreateTime);
            System.out.println(visitor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getVisitWithMapLs() {
        Connection conn = getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "select * from visitor where status>0";
        try {
            List<Map<String, Object>> mapLs = qr.query(conn, sql, new MapListHandler());
            for (Map<String, Object> map : mapLs) {
                Integer visitorId = Integer.valueOf(map.get("Id").toString());
                String visitorName = map.get("Name").toString();
                String visitorEmail = map.get("Email").toString();
                Integer visitorStatus = Integer.valueOf(map.get("Status").toString());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date visitorCreateTime = sdf.parse(map.get("CreateTime").toString());
                Visitor visitor = new Visitor(visitorName, visitorEmail);
                visitor.setId(visitorId);
                visitor.setStatus(visitorStatus);
                visitor.setCreateTime(visitorCreateTime);
                System.out.println(visitor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        /**
//         * 插入方法测试
//         */
//        Visitor visitor1 = new Visitor();
//        visitor1.setName("匿名用户");
//        visitor1.setEmail("110@qq.com");
//        insertVisitor(visitor1);
//
//
//    }

}

 