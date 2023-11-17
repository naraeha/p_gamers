package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.frontcontroller.Service;
import com.project.model.MemberDAO;
import com.project.model.MemberDTO;

public class UpdateService implements Service {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String u_email = request.getParameter("update_email");
		String u_pw = request.getParameter("update_pw");
		String u_nick = request.getParameter("update_nick");
		String u_class = request.getParameter("update_class");

		MemberDTO udto = new MemberDTO(u_email, u_pw, u_nick, u_class);

		int cnt = new MemberDAO().updateMember(udto);

		if (cnt > 0) {
			System.out.println("정보 수정 완료");
			HttpSession session = request.getSession();
			session.setAttribute("login", udto);
		} else {
			System.out.println("정보 수정 실패");
		}
		return "Main.jsp";
	}

}
