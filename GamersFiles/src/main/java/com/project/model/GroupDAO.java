package com.project.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.project.database.SqlSessionManager;

public class GroupDAO {

	// 세션 생성해 줄 Factory 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	// connection, close, ... sql문 실행
	SqlSession sqlSession = sqlSessionFactory.openSession(true);

	// 회원가입
	public int insertGroup(GroupDTO gdto) {
		int cnt = 0;

		try {
			cnt = sqlSession.insert("com.project.database.GroupMapper.insertGroup", gdto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return cnt;
	}

	// 로그인
	public GroupDTO loginGroup(GroupDTO gdto) {
		GroupDTO login = null;
		try {
			login = sqlSession.selectOne("com.project.database.GroupMapper.loginGroup", gdto);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return login;

	}

	// 중복체크
	public boolean GroupCheck(String inputG) {
		boolean isCheck = false;
		try {
			isCheck = sqlSession.selectOne("com.project.database.GroupMapper.groupCheck", inputG);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return isCheck; // true or false

	}

	// 회원정보 수정
	public int updateGroup(GroupDTO gdto) {
		int cnt = 0;
		try {
			cnt = sqlSession.update("com.project.database.GroupMapper.updateGroup", gdto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}

	public List<GroupDTO> allGroup() {
		List<GroupDTO> members = null;
		try {
			members = sqlSession.selectList("com.project.database.GroupMapper.allGroup");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return members;
	}

	public int delMember(String g_name) {
		int cnt = 0;
		try {
			cnt = sqlSession.delete("com.project.database.GroupMapper.delMember", g_name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}

}
