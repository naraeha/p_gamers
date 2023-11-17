package com.project.database;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionManager {

	// 4. SqlSessionManager 생성
	// -> SqlSessionFactory 관리하는 Class
	// -> SqlSession == Connection
	// -> SqlSessionFactory == Connection 객체 보관
	// 데이터베이스를 *미리* 연결하는 동작(Connection Pool : CP)
	// Why? db 연결 작업이 성능이 가장 떨어지는 부분 - 성능 향상
	// mybatis - 성능 향상을 위해 Connection 객체 보유 중
	// 사용 시마다 제공, 반환

	// static block : 객체 호출 시 실행되는 부분
	public static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			// mabatis 환경설정 파일 경로
			String resource = "com/project/database/mybatis-config.xml";

			// xml 파일 읽기위한 InputStream 사용
			InputStream inputStream = Resources.getResourceAsStream(resource);

			// SqlSessionFactory : Connection 객체가
			// 여러 개인 Connection Pool
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
	}

}
