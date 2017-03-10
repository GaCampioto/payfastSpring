package br.com.gacampioto.payfastSpring.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfiguration {
	private static String URL = "jdbc:mysql://localhost:3306/payfast";
	private static String USERNAME = "root";
	private static String PASSWORD = "";
	private static String MYSQL_DRIVER = "com.mysql.jdbc.Driver";

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		//Criando objeto que conterá configurações da JPA
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		//Criando objeto que define qual implementação vamos utilizar
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		//Incluindo implementação no objeto de configuração
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		
		//Criando objeto com configurações do banco de dados que será utilizado
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername(JPAConfiguration.USERNAME);
		dataSource.setPassword(JPAConfiguration.PASSWORD);
		dataSource.setUrl(JPAConfiguration.URL);
		dataSource.setDriverClassName(JPAConfiguration.MYSQL_DRIVER);
		
		factoryBean.setDataSource(dataSource);
		
		//Criando objeto com propriedades do banco de dados
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "update");
        
        factoryBean.setJpaProperties(props);
        
        factoryBean.setPackagesToScan("br.com.gacampioto.payfastSpring.models");
        
        return factoryBean;
	}
	
	@Bean
	public JpaTransactionManager getTransactionManager(EntityManagerFactory factory){
		return new JpaTransactionManager(factory);
	}
}
