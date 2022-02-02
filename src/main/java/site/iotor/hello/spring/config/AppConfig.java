/**
 * @Author Rancho Lee
 * @Email iotcoder@gmail.com
 * @Date May 21, 2018 8:56:26 PM
 * @Description
 */
package site.iotor.hello.spring.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import site.iotor.hello.spring.model.Authorities;
import site.iotor.hello.spring.model.PersistentLogins;
import site.iotor.hello.spring.model.User;

import static org.hibernate.cfg.AvailableSettings.*;

/**
 * @author Rancho
 */

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("site.iotor.hello.spring.dao"),
        @ComponentScan("site.iotor.hello.spring.service") })
public class AppConfig {
    
    private final Environment env;

    public AppConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        Properties props = new Properties();

        // Setting JDBC properties
        props.put(DRIVER, env.getProperty("mysql.driver"));
        props.put(URL, env.getProperty("mysql.jdbcUrl"));
        props.put(USER, env.getProperty("mysql.username"));
        props.put(PASS, env.getProperty("mysql.password"));

        // Setting Hibernate properties
        props.put(SHOW_SQL, env.getProperty(SHOW_SQL));
        props.put(HBM2DDL_AUTO, env.getProperty(HBM2DDL_AUTO));
        props.put(DIALECT, env.getProperty(DIALECT));

        // Setting C3P0 properties
        props.put(C3P0_MIN_SIZE, env.getProperty(C3P0_MIN_SIZE));
        props.put(C3P0_MAX_SIZE, env.getProperty(C3P0_MAX_SIZE));
        props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty(C3P0_ACQUIRE_INCREMENT));
        props.put(C3P0_TIMEOUT, env.getProperty(C3P0_TIMEOUT));
        props.put(C3P0_MAX_STATEMENTS, env.getProperty(C3P0_MAX_STATEMENTS));

        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(User.class, Authorities.class, PersistentLogins.class);

        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
