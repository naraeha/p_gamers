package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.frontcontroller.Service;
import com.project.model.ContentDAO;
import com.project.model.MemberDAO;

public class DelConService implements Service {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[DelConService.do]");
		String c_name = request.getParameter("c_email");
		int cnt = new ContentDAO().delContent(c_name);
		if (cnt > 0) {
			System.out.println("컨텐츠 삭제 성공");
			return "adminContent.jsp";
		} else {
			System.out.println("컨텐츠 삭제 실패");
			return "adminContent.jsp";
		}
	}

}
