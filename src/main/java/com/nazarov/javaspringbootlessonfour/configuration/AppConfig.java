package com.nazarov.javaspringbootlessonfour.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan("com.nazarov.javaspringbootlessonfour")
public class AppConfig {
//
//    //Настройка базы данных
//    @Bean
//    public DataSource dataSource() {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        try {
//            dataSource.setDriverClass("org.postgresql.Driver");
////            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres_main");
//            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres_main?useSSL=false&serverTimezone=UTC");
//            dataSource.setUser("postgres");
//            dataSource.setPassword("postgres");
//            dataSource.setInitialPoolSize(1);
//
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        }
//        return dataSource;
//    }
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory =
//                new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan
//                ("com.nazarov.javaspringbootlessonfour.entities");
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty
//                ("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
//        hibernateProperties.setProperty
//                ("hibernate.show_sql", "true");
////        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
////        hibernateProperties.setProperty("hibernate.current_session_context_class", "thread");
//        sessionFactory.setHibernateProperties(hibernateProperties);
//        return sessionFactory;
//    }
//
//    @Bean
//    public HibernateTransactionManager transactionManager() {
//        HibernateTransactionManager hibernateTransactionManager =
//                new HibernateTransactionManager();
//        hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
//        return hibernateTransactionManager;
//    }
}
