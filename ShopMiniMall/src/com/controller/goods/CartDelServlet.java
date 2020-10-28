package com.controller.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.GoodsService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/CartDelServlet")
public class CartDelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

		  //로그인 정보 확인 
		  //번호 파싱, CartSerivce.cardDel(num)
		  //삭제 후 장바구니 리스트 다시 보이기 (CartListServlet) - Mapper id = "cartDel"
		  //로그인 정보가 없을 경우 - 로그인 화면으로 이동 
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String nextPage = null;
		if(dto != null) {
			String num = request.getParameter("num");
			CartService service = new CartService();
			int n = service.cartDel(Integer.parseInt(num));
			nextPage = "CartListServlet";
		}else {
			nextPage = "LoginUIServlet";
			session.setAttribute("mesg", "로그인이 필요합니다.");
		}
		response.sendRedirect(nextPage);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
