package com.fanda.shirotest.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Classname MybatisConfi
 * @Description TODO
 * @Date 2019/1/8 11:25
 */
@Configuration
@EnableTransactionManagement
public class MybatisConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.driver-class-name}")
    private String classname;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(classname);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        // 配置mapper的扫描，找到所有的mapper.xml映射文件
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
        sqlSessionFactory.setMapperLocations(resources);

        return sqlSessionFactory;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

//    //配置mybatis的分页插件pageHelper
//    @Bean
//    public PageHelper pageHelper(){
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("offsetAsPageNum","true");
//        properties.setProperty("rowBoundsWithCount","true");
//        properties.setProperty("reasonable","true");
//        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
//        pageHelper.setProperties(properties);
//        return pageHelper;
//    }

}
