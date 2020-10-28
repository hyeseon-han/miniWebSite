package com.controller.goods;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.member.LoginUIServlet;
import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.GoodsService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/CartUpdateServlet")
public class CartUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //로그인정보확인
		 //num, aAmount파싱 
		 //map에 저장하고 service.cartUpdate(map) ==> Mapper id= cartUpdate 
		 //로그인 정보가 없을 경우 로그인 폼으로 이동
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		if(dto != null) {
			String num = request.getParameter("num");
			String gAmount = request.getParameter("gAmount");
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("num", Integer.parseInt(num));
			map.put("gAmount", Integer.parseInt(gAmount));
			
			CartService service = new CartService();
			int n = service.cartUpdate(map);
			
		}else {
			response.sendRedirect("LoginUIServlet");
		}
	    

	}//end doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
