package com.fanda.shirotest.dao;

import com.fanda.shirotest.entity.CtAdmMenuNode;

import java.util.List;

/**
 * <p>
 * 系统管理-菜单树结点信息 Mapper 接口
 * </p>
 *
 * @author skh
 * @since 2019-01-08
 */
public interface CtAdmMenuNodeDao {

    List<CtAdmMenuNode> selectAll();

}
