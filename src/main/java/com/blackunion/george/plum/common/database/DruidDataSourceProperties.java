package com.blackunion.george.plum.common.database;

import java.util.Properties;

/**
 * druid数据连接池配置
 * @author george
 * @date 2017年8月17日
 *
 */
public class DruidDataSourceProperties {

	/** 连接信息 */
	private String url;
	private String username;
	private String password;
	private String driverClassName;

	/** 连接池初始、最小空闲、最大连接数 */
	private Integer initialSize = 5;
	private Integer minIdle = 5;
	private Integer maxActive = 20;
	/** 获取连接等待超时的时间 */
	private Long maxWait = 60000L;
	/** 间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 */
	private Long timeBetweenEvictionRunsMillis = 60000L;
	/** 连接在池中最小生存的时间，单位是毫秒 */
	private Long minEvictableIdleTimeMillis = 300000L;
	/** 连接在池验证sql */
	private String validationQuery = "SELECT 1";
	private Boolean testWhileIdle = true;
    private Boolean testOnBorrow;
    private Boolean testOnReturn;
    /** 打开PSCache，并且指定每个连接上PSCache的大小  */
    private Boolean poolPreparedStatements = true;
    private Integer maxPoolPreparedStatementPerConnectionSize = 20;
    /** 配置监控统计拦截的filters */
    private String filters;
    private Properties connectionProperties = new Properties() {
		private static final long serialVersionUID = -529399401808820107L;
		{put("druid.stat.mergeSql", "true");put("druid.stat.slowSqlMillis", "5000");}
	};
    /** 是否合并多个DruidDataSource的监控数据 */
    private Boolean useGlobalDataSourceStat;
    private Long timeBetweenLogStatsMillis;
    private Integer maxSize;
    private Boolean clearFiltersEnable;
    private Boolean resetStatEnable;
    private Integer notFullTimeoutRetryCount;
    private Integer maxWaitThreadCount;
    private Boolean failFast;
    private Boolean phyTimeoutMillis;
    private Long maxEvictableIdleTimeMillis;
    
    /**
     * 将配置信息转化为一个Properties对象
     * @return Properties 返回的对象
     * @since V1.0.0
     */
    public Properties toProperties() {
        Properties properties = new Properties();
		addProperties(properties, "url", this.url);
		addProperties(properties, "username", this.username);
		addProperties(properties, "password", this.password);
		addProperties(properties, "driverClassName", this.driverClassName);

        addProperties(properties, "testWhileIdle", this.testWhileIdle);
        addProperties(properties, "testOnBorrow", this.testOnBorrow);
        addProperties(properties, "validationQuery", this.validationQuery);
        addProperties(properties, "useGlobalDataSourceStat", this.useGlobalDataSourceStat);
        addProperties(properties, "filters", this.filters);
        addProperties(properties, "timeBetweenLogStatsMillis", this.timeBetweenLogStatsMillis);
        addProperties(properties, "stat.sql.MaxSize", this.maxSize);
        addProperties(properties, "clearFiltersEnable", this.clearFiltersEnable);
        addProperties(properties, "resetStatEnable", this.resetStatEnable);
        addProperties(properties, "notFullTimeoutRetryCount", this.notFullTimeoutRetryCount);
        addProperties(properties, "maxWaitThreadCount", this.maxWaitThreadCount);
        addProperties(properties, "failFast", this.failFast);
        addProperties(properties, "phyTimeoutMillis", this.phyTimeoutMillis);
        addProperties(properties, "minEvictableIdleTimeMillis", this.minEvictableIdleTimeMillis);
        addProperties(properties, "maxEvictableIdleTimeMillis", this.maxEvictableIdleTimeMillis);
        addProperties(properties, "initialSize", this.initialSize);
        addProperties(properties, "minIdle", this.minIdle);
        addProperties(properties, "maxActive", this.maxActive);
        addProperties(properties, "maxWait", this.maxWait);
        addProperties(properties, "timeBetweenEvictionRunsMillis", this.timeBetweenEvictionRunsMillis);
        addProperties(properties, "poolPreparedStatements", this.poolPreparedStatements);
        addProperties(properties, "maxPoolPreparedStatementPerConnectionSize", this.maxPoolPreparedStatementPerConnectionSize);
        return properties;
    }
    
    /**
     * 若对应值不为空，则添加到目标Properties实例中
     * @param properties 目标Properties实例中
     * @param key 对应的key键
     * @param value 对应值
     * @since V1.0.0
     */
    private void addProperties(Properties properties, String key, Object value) {
        if (value != null) {
            properties.setProperty("druid." + key, value.toString());
        }
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public Integer getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(Integer initialSize) {
		this.initialSize = initialSize;
	}

	public Integer getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(Integer minIdle) {
		this.minIdle = minIdle;
	}

	public Integer getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(Integer maxActive) {
		this.maxActive = maxActive;
	}

	public Long getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(Long maxWait) {
		this.maxWait = maxWait;
	}

	public Long getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(Long timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public Long getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(Long minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

	public Boolean getTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(Boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public Boolean getTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(Boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public Boolean getTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(Boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public Boolean getPoolPreparedStatements() {
		return poolPreparedStatements;
	}

	public void setPoolPreparedStatements(Boolean poolPreparedStatements) {
		this.poolPreparedStatements = poolPreparedStatements;
	}

	public Integer getMaxPoolPreparedStatementPerConnectionSize() {
		return maxPoolPreparedStatementPerConnectionSize;
	}

	public void setMaxPoolPreparedStatementPerConnectionSize(Integer maxPoolPreparedStatementPerConnectionSize) {
		this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public Properties getConnectionProperties() {
		return connectionProperties;
	}

	public void setConnectionProperties(Properties connectionProperties) {
		this.connectionProperties = connectionProperties;
	}

	public Boolean getUseGlobalDataSourceStat() {
		return useGlobalDataSourceStat;
	}

	public void setUseGlobalDataSourceStat(Boolean useGlobalDataSourceStat) {
		this.useGlobalDataSourceStat = useGlobalDataSourceStat;
	}

	public Long getTimeBetweenLogStatsMillis() {
		return timeBetweenLogStatsMillis;
	}

	public void setTimeBetweenLogStatsMillis(Long timeBetweenLogStatsMillis) {
		this.timeBetweenLogStatsMillis = timeBetweenLogStatsMillis;
	}

	public Integer getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(Integer maxSize) {
		this.maxSize = maxSize;
	}

	public Boolean getClearFiltersEnable() {
		return clearFiltersEnable;
	}

	public void setClearFiltersEnable(Boolean clearFiltersEnable) {
		this.clearFiltersEnable = clearFiltersEnable;
	}

	public Boolean getResetStatEnable() {
		return resetStatEnable;
	}

	public void setResetStatEnable(Boolean resetStatEnable) {
		this.resetStatEnable = resetStatEnable;
	}

	public Integer getNotFullTimeoutRetryCount() {
		return notFullTimeoutRetryCount;
	}

	public void setNotFullTimeoutRetryCount(Integer notFullTimeoutRetryCount) {
		this.notFullTimeoutRetryCount = notFullTimeoutRetryCount;
	}

	public Integer getMaxWaitThreadCount() {
		return maxWaitThreadCount;
	}

	public void setMaxWaitThreadCount(Integer maxWaitThreadCount) {
		this.maxWaitThreadCount = maxWaitThreadCount;
	}

	public Boolean getFailFast() {
		return failFast;
	}

	public void setFailFast(Boolean failFast) {
		this.failFast = failFast;
	}

	public Boolean getPhyTimeoutMillis() {
		return phyTimeoutMillis;
	}

	public void setPhyTimeoutMillis(Boolean phyTimeoutMillis) {
		this.phyTimeoutMillis = phyTimeoutMillis;
	}

	public Long getMaxEvictableIdleTimeMillis() {
		return maxEvictableIdleTimeMillis;
	}

	public void setMaxEvictableIdleTimeMillis(Long maxEvictableIdleTimeMillis) {
		this.maxEvictableIdleTimeMillis = maxEvictableIdleTimeMillis;
	}
}
