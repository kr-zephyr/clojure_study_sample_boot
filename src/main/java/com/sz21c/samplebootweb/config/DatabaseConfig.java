package com.sz21c.samplebootweb.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

/**
 * 
 * <pre>
 * 데이터 베이스 연동을 위한 설정 Class.
 * 
 * H2 메모리 DB를 사용하며, datasource가 생성되는 시점(즉, Application이 기동하는 시점)에 createTable.sql이 실행되어,
 * DB를 초기화 한다. 이 예제에서는 간단한 locations 테이블을 생성한다.
 * </pre>
 *
 * @author 이승철 <scin21c@gmail.com>
 * @since 2015. 5. 12.
 *
 */
@Configuration
@MapperScan(basePackages = "com.sz21c.samplebootweb.persistence")
public class DatabaseConfig {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(H2).addScript("createTable.sql").build();
	}
	
	/**
	 * 
	 * <pre>
	 * by 이승철 <scin21c@gmail.com>
	 *
	 * MyBatis 연동을 위한 sqlSessinObject를 생성한다.
	 * </pre>
	 *
	 * @since 2015. 5. 12.
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		
		return sessionFactory.getObject();
	}
}
