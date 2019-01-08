package com.fanda.shirotest.web.controller;

import com.fanda.shirotest.dao.CtAdmMenuNodeDao;
import com.fanda.shirotest.entity.AdmMenuInf;
import com.fanda.shirotest.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname MeunController
 * @Description TODO
 * @Date 2019/1/7 14:18
 */
@RestController
public class MeunController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment environment;
    @Autowired
    private CtAdmMenuNodeDao ctAdmMenuNodeDao;
    @Autowired
    private MenuService menuService;

    @RequestMapping("test")
    public String test() {
        return environment.getProperty("os.name");
    }

    @RequestMapping("menuAll")
    public List<AdmMenuInf> queryAll() {
        logger.debug(this.getClass().getSimpleName() + ":debug");
        logger.info(this.getClass().getSimpleName() + ":info");
        logger.error(this.getClass().getSimpleName() + ":error");
        return menuService.queryAll();
    }
}
