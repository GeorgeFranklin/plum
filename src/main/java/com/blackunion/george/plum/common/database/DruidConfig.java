package com.blackunion.george.plum.common.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * druid数据源配置类。
 * @author george
 * @date 2017年8月17日
 *
 */
@Configuration
public class DruidConfig {
	
	/** druid登陆账户名 */
	@Value("${druid.loginname}")
	private String druidLoginName;
	
	/** druid登陆账户密码 */
	@Value("${druid.loginpws}")
	private String druidLoginPassword;
	
	/**
	 * druid监控servlet实例配置。
	 * @return ServletRegistrationBean druid监控注册实例
	 * @since V1.0.0
	 */
	@Bean
	@ConfigurationProperties(prefix = "druid.login")
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //registrationBean.addInitParameter("allow", "127.0.0.1");// IP白名单 (没有配置或者为空，则允许所有访问)
        registrationBean.addInitParameter("deny", "");// IP黑名单 (存在共同时，deny优先于allow)
        registrationBean.addInitParameter("loginUsername", druidLoginName);
        registrationBean.addInitParameter("loginPassword", druidLoginPassword);
        registrationBean.addInitParameter("resetEnable", "false");
        return registrationBean;
    }

	/**
	 * druid监控拦截过滤器。
	 * @return FilterRegistrationBean 拦截器注册实例
	 * @since V1.0.0
	 */
    @Bean
    public FilterRegistrationBean druidWebStatViewFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
        registrationBean.addInitParameter("urlPatterns", "/*");
        registrationBean.addInitParameter("exclusions", "/assets/*,*.css,*.js,*.gif,*.jpg,*.png,*.ico,*.eot,*.svg,*.ttf,*.woff,*.jsp,*.tpl,/druid/*");
        return registrationBean;
    }
    
    /**
     * 初始化数据源实例，并进行连接池信息配置
     * @return DruidDataSource 初始化的连接池，没有url等主要连接信息
     * @since V1.0.0
     */
    public DruidDataSource initDruidDataSource(DruidDataSourceProperties druidDataSourceProperties) {
    	DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.configFromPropety(druidDataSourceProperties.toProperties());
        druidDataSource.setInitialSize(druidDataSourceProperties.getInitialSize());
        druidDataSource.setMinIdle(druidDataSourceProperties.getMinIdle());
        druidDataSource.setMaxActive(druidDataSourceProperties.getMaxActive());
        druidDataSource.setMaxWait(druidDataSourceProperties.getMaxWait());
        druidDataSource.setConnectProperties(druidDataSourceProperties.getConnectionProperties());
    	return druidDataSource;
    }
}
