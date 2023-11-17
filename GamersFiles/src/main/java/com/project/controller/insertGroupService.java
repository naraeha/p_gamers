package com.project.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.frontcontroller.Service;
import com.project.model.GroupDAO;
import com.project.model.GroupDTO;
import com.project.model.MemberDAO;
import com.project.model.MemberDTO;

public class insertGroupService implements Service {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("[파티 생성 서비스]");

		// 요청 데이터 받기
		String g_name = request.getParameter("g_name");
		String g_date = request.getParameter("g_date");
		int findIndex = g_date.indexOf('T');
		g_date = g_date.substring(0, findIndex) + ' ' + g_date.substring(findIndex + 1) + ":00" ;
		System.out.println(g_date);
		System.out.println(g_name);
		
		int c_num = Integer.parseInt(request.getParameter("c_num"));

		GroupDTO gdto = new GroupDTO(g_name, g_date, c_num);

		int cnt = new GroupDAO().insertGroup(gdto);

		System.out.println("cnt : " + cnt);

		if (cnt > 0) {
			System.out.println("파티 생성 성공");
			return "Main.jsp";
		} else {
			System.out.println("파티 생성 실패");
			return "Main.jsp";
		}
	}

}
