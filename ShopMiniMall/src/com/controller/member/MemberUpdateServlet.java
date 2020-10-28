package com.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//세션에서 로그인 여부 검사 
	// 회원인 경우만 데이터파싱, service.memberUpdate(MemberDTO)전송 업데이트 후 메인으로 이동
	//회원이 아닌 경우 "mesg"에 로그인 필요한 작업입니다. 메세지 띄우고 로그인화면으로 이동 
		
	
	HttpSession session = request.getSession();
	MemberDTO dto = (MemberDTO) session.getAttribute("login");
	if(dto != null) {
		MemberDTO resultDTO = new MemberDTO();
		//String userid = request.getParameter("userid");
		String userid = dto.getUserid();
		String post = request.getParameter("post");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		resultDTO.setUserid(userid);
		resultDTO.setPost(post);
		resultDTO.setAddr1(addr1);
		resultDTO.setAddr2(addr2);
		resultDTO.setPhone1(phone1);
		resultDTO.setPhone2(phone2);
		resultDTO.setPhone3(phone3);
		resultDTO.setEmail1(email1);
		resultDTO.setEmail2(email2);
		MemberService service = new MemberService();
		int n = service.memberUpdate(resultDTO);
		
		if(n == 1) {
			System.out.println("resultDTO" + resultDTO.toString());
			response.sendRedirect("main");
			System.out.println("resultDTO update userid = " + userid);
		}
		
		
	}else {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String mesg = "로그인 필요한 작업 입니다.";
		out.print(mesg);
		response.sendRedirect("LoginUIServlet");
	}
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
