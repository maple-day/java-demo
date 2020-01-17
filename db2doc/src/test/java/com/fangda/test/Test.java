package com.fangda.test;
 
import com.fangda.config.DB2DocUtil;
import com.fangda.config.SpringConfig;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.runner.RunWith;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.*;

/**
 * @description 打包的时候去除测试的 -Dmaven.test.skip=true
 * @Author ccq
 * @date 2020/1/14 8:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfig.class })
public class Test {

	@Autowired
	DB2DocUtil db2DocUtil;
 
	@org.junit.Test
	public void test() {
		db2DocUtil.db2Doc();
	}

}
