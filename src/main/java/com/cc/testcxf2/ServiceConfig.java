package com.cc.testcxf2;

import com.cc.testcxf2.entity.Persons;
import com.cc.testcxf2.repo.PersonsRepo;
import com.cc.testcxf2.service.PersonsServiceImp;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Configuration
public class ServiceConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Bean()//destroyMethod = "close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.
    DataSource dataSource() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(jdbcDriver);
        dataSourceConfig.setJdbcUrl(dbUrl);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);
        dataSourceConfig.setMaximumPoolSize(30);
        return new HikariDataSource(dataSourceConfig);
    }
    //@Bean

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.cc.testcxf2.entity");
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.jdbc.lob.non_contextual_creation","true");
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        return entityManagerFactoryBean;
    }
    @Bean
//    @Autowired
    public Server server(PersonsServiceImp ps) {
//        PersonsServiceImp ps = new PersonsServiceImp();
//        ps.setPersonsRepo(personsRepo);
        JAXRSServerFactoryBean jaxRSServerFactoryBean = new JAXRSServerFactoryBean();
        jaxRSServerFactoryBean.setServiceBean(ps);
        //jaxRSServerFactoryBean.setResourceClasses(PersonsServiceImp.class);
        jaxRSServerFactoryBean.setProvider(new JacksonJsonProvider());
        jaxRSServerFactoryBean.setAddress("http://localhost:9095/persons");
        return jaxRSServerFactoryBean.create();
    }
}
