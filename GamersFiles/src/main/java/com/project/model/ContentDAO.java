package com.project.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.project.database.SqlSessionManager;

public class ContentDAO {
	// 세션 생성해 줄 Factory 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	// connection, close, ... sql문 실행
	SqlSession sqlSession = sqlSessionFactory.openSession(true);

	public List<ContentDTO> allContent() {
		List<ContentDTO> contents = null;
		try {
			contents = sqlSession.selectList("com.project.database.ContentMapper.allContent");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contents;
	}

	public int insertContent(ContentDTO cdto) {
		int cnt = 0;

		try {
			cnt = sqlSession.insert("com.project.database.ContentMapper.insertContent", cdto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return cnt;

	}

	public int delContent(String c_num) {
		int cnt = 0;
		try {
			cnt = sqlSession.delete("com.project.database.ContentMapper.delContent", c_num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}
	
	public String viewContent(String c_num) {
		String result = "";
		try {
			result = sqlSession.selectOne("com.project.database.ContentMapper.viewContent", c_num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}

}
