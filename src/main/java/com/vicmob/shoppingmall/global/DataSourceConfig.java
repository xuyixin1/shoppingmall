package com.vicmob.shoppingmall.global;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;

@Configuration
@MapperScan(basePackages = "com.vicmob.shoppingmall.*.*.dao")
public class DataSourceConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(initMethod = "init",destroyMethod = "close")
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = (DruidDataSource) DataSourceBuilder.create().type(DruidDataSource.class).build();
        dataSource.setInitialSize(10);
        dataSource.setMaxActive(25);
        dataSource.setMinIdle(10);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("select 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(2520000);
        dataSource.setRemoveAbandoned(true);
        dataSource.setRemoveAbandonedTimeout(1800);
        dataSource.setLogAbandoned(true);
        dataSource.setFilters("stat,wall,slf4j");
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager testTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //配置web监控
    /*

     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams = new HashMap<>(16);
        initParams.put("testOnReturn","false");
        initParams.put("loginUsername", "vicmob");
        initParams.put("loginPassword", "wxk123456");
        bean.setInitParameters(initParams);
        return bean;
    }

    //配置web监控的filter
    /*

     */
   @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>(16);
        initParams.put("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
