package com.fanda.shirotest.service.impl;

import com.fanda.shirotest.dao.CtAdmMenuNodeDao;
import com.fanda.shirotest.entity.AdmMenuInf;
import com.fanda.shirotest.entity.CtAdmMenuNode;
import com.fanda.shirotest.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MenuServiceImpl
 * @Description TODO
 * @Date 2019/1/8 14:11
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private CtAdmMenuNodeDao ctAdmMenuNodeDao;

    @Override
    public List<AdmMenuInf> queryAll() {
        List<CtAdmMenuNode> ctAdmMenuNodes = ctAdmMenuNodeDao.selectAll();
        AdmMenuInf admMenuInf = new AdmMenuInf();
        admMenuInf.setAmnId(0L);
        admMenuInf.setMenuName("根接点");
        List<AdmMenuInf> menus = getMenus(ctAdmMenuNodes, admMenuInf);
        return menus.get(0).getSubMenus();
    }

    public List<AdmMenuInf> getMenus(List<CtAdmMenuNode> ctAdmMenuNodes, AdmMenuInf menuInf) {
        ArrayList<AdmMenuInf> menuList = new ArrayList<>();
        for (CtAdmMenuNode ctAdmMenuNode : ctAdmMenuNodes) {
            Long parentId = ctAdmMenuNode.getParentId();
            Long amnId = menuInf.getAmnId();
            if (parentId.compareTo(amnId) == 0) {
                AdmMenuInf admMenuInf = new AdmMenuInf();
                admMenuInf.setAmnId(ctAdmMenuNode.getAmnId());
                admMenuInf.setParentId(ctAdmMenuNode.getParentId());
                admMenuInf.setIconInf(ctAdmMenuNode.getIconInf());
                admMenuInf.setMenuName(ctAdmMenuNode.getMenuName());
                admMenuInf.setMenuUrl(ctAdmMenuNode.getMenuUrl());
                List<AdmMenuInf> menus = getMenus(ctAdmMenuNodes, admMenuInf);
                admMenuInf.setSubMenus(menus);
                menuList.add(admMenuInf);
            }
        }
        return menuList;
    }
}
