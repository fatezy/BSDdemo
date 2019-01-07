package com.demo.db;

import org.junit.Test;

/**
 * Created by 张亚飞 on 2019/1/7.
 */
public class DbUtilsDemoTest {

    @Test
    public void testInsertVisitor() throws Exception {
        Visitor visitor1 = new Visitor();
        visitor1.setName("匿名用户");
        visitor1.setEmail("110@qq.com");
        DbUtilsDemo.insertVisitor(visitor1);
    }

    /**
     *
     * Method: deleteVisitor(int id)
     *
     */
    @Test
    public void testDeleteVisitor() throws Exception {
        DbUtilsDemo.deleteVisitor(1);

    }

    /**
     *
     * Method: retrieveVisitor(int id)
     * 查询单个用户
     *
     */
    @Test
    public void testRetrieveVisitor() throws Exception {
        System.out.println(DbUtilsDemo.retrieveVisitor(2));

    }

    /**
     *
     * Method: updateVisitor(int id)
     *
     */
    @Test
    public void testUpdateVisitor() throws Exception {
        DbUtilsDemo.updateVisitor(2);
    }

    /**
     *
     * Method: getVisitorList()
     *
     */
    @Test
    public void testGetVisitorList() throws Exception {
        DbUtilsDemo.getVisitorList();
    }

    /**
     *
     * Method: getVisitWithMap(int id)
     *
     */
    @Test
    public void testGetVisitWithMap() throws Exception {
        DbUtilsDemo.getVisitWithMap(2);
    }

    /**
     *
     * Method: getVisitWithMapLs()
     *
     */
    @Test
    public void testGetVisitWithMapLs() throws Exception {
        DbUtilsDemo.getVisitWithMapLs();
    }



}

 