package com.blackunion.george.plum.common.database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 数据源-数据连接池配置类。
 * Created by George on 2017-08-17.
 */
@Configuration
public class DataSourceConfig {

    /**
     * 初始化Druid数据连接池配置信息。
     * @return DruidDataSourceProperties Druid数据连接池配置
     */
    @Bean(name = "dataSourceProperties")
    @Qualifier("dataSourceProperties")
    @Primary
    @ConfigurationProperties(prefix = "druid.datasource")
    public DruidDataSourceProperties initDruidProperties(){
        return new DruidDataSourceProperties();
    }

    @Bean(name = "druidConfig")
    @Qualifier("druidConfig")
    @Primary
    public DruidConfig initDruidConfig(){
        return new DruidConfig();
    }

    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(@Qualifier("druidConfig") DruidConfig druidConfig,
                                 @Qualifier("dataSourceProperties") DruidDataSourceProperties druidSourceProperties){
        return druidConfig.initDruidDataSource(druidSourceProperties);
    }

    @Bean(name = "jdbcTemplate")
    @Primary
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
