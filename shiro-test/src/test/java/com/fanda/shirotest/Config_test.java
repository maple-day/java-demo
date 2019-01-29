package com.fanda.shirotest;

import com.fanda.shirotest.dao.CtAdmMenuNodeDao;
import com.fanda.shirotest.entity.AdmMenuInf;
import com.fanda.shirotest.entity.CtAdmMenuNode;
import com.fanda.shirotest.service.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Classname Config_test
 * @Description TODO
 * @Date 2019/1/8 11:49
 */
public class Config_test extends ShiroTestApplicationTests {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private CtAdmMenuNodeDao ctAdmMenuNodeDao;
    @Autowired
    private MenuService menuService;

    @Test
    public void contextLoads() {
        System.out.println("dataSource = " + dataSource.getClass().getSimpleName());
    }

    @Test
    public void fun2() {
        List<CtAdmMenuNode> ctAdmMenuNodes = ctAdmMenuNodeDao.selectAll();
        System.out.println("ctAdmMenuNodes = " + ctAdmMenuNodes);
    }

    @Test
    public void fun3() {
        List<AdmMenuInf> admMenuInfs = menuService.queryAll();
        System.out.println("admMenuInfs = " + admMenuInfs);
    }

}
