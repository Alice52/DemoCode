package cn.edu.ntu.javaee.annotation.jdbc.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringValueResolver;

/**
 * - add AutoProxyRegistrar to register **InfrastructureAdvisorAutoProxyCreator** to ioc container,
 * which is posthandler and do wrap and return advisor proxy object after target object be created
 * and set properties
 *
 * <p>- ProxyTransactionManagementConfiguration will use `step 1` to intercept bean init 1. add
 * AnnotationTransactionAttributeSource to parse annotation metadata 2.
 * TransactionInterceptor(**`MethodInterceptor`**): save database transaction info and transaction
 * manager, which will do rollback or commit transaction 3. due to MethodInterceptor, so target
 * method execute work flow is below - get transaction info, such as propagation, rollbackfor, etcs
 * - get PlatformTransactionManager: get from `@Transactional(transactionManager = ""), else get
 * from beanfactory by type of PlatformTransactionManager - execute target method by proxy - if
 * occurs exception, will use transactionManager to rollback, else use tm commit transaction
 *
 * @author zack <br>
 * @create 2020-05-04 19:50 <br>
 */
@EnableTransactionManagement
@Configuration
@ComponentScan({"cn.edu.ntu.javaee.annotation.jdbc"})
@PropertySource(value = "classpath:data-source.properties")
public class DruidConfig implements EmbeddedValueResolverAware {

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.jdbcUrl}")
    private String jdbcUrl;

    private StringValueResolver valueResolver;
    private String driverClass;

    @Bean("druidDataSource")
    public DruidDataSource configDruid(@Value("${jdbc.password}") String pwd) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(user);
        dataSource.setPassword(pwd);
        dataSource.setUrl(jdbcUrl);
        dataSource.setDriverClassName(driverClass);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;
        driverClass = valueResolver.resolveStringValue("${jdbc.driverClass}");
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource) {
        return new JdbcTemplate(druidDataSource);
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(
            DruidDataSource druidDataSource) {
        return new DataSourceTransactionManager(druidDataSource);
    }
}
