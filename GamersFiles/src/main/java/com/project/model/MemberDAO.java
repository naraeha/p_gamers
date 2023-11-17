package com.project.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.project.database.SqlSessionManager;

public class MemberDAO {
	// 세션 생성해 줄 Factory 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	// connection, close, ... sql문 실행
	SqlSession sqlSession = sqlSessionFactory.openSession(true);

	// 회원가입
	public int joinMember(MemberDTO mdto) {
		int cnt = 0;

		try {
			cnt = sqlSession.insert("com.project.database.MemberMapper.joinMember", mdto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return cnt;
	}

	// 로그인
	public MemberDTO loginMember(MemberDTO mdto) {
		MemberDTO login = null;
		try {
			login = sqlSession.selectOne("com.project.database.MemberMapper.loginMember", mdto);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return login;

	}

	// 중복체크
	public boolean emailCheck(String inputE) {
		boolean isCheck = false;
		try {
			isCheck = sqlSession.selectOne("com.project.database.MemberMapper.emailCheck", inputE);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return isCheck; // true or false

	}

	// 회원정보 수정
	public int updateMember(MemberDTO mdto) {
		int cnt = 0;
		try {
			cnt = sqlSession.update("com.project.database.MemberMapper.updateMember", mdto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}

	public List<MemberDTO> allMember() {
		List<MemberDTO> members = null;
		try {
			members = sqlSession.selectList("com.project.database.MemberMapper.allMember");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return members;
	}

	public int delMember(String m_email) {
		int cnt = 0;
		try {
			cnt = sqlSession.delete("com.project.database.MemberMapper.delMember", m_email);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return cnt;
	}
}
