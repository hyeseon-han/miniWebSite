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

import com.dto.GoodsDTO;
import com.service.GoodsService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/GoodsRetrieveServlet")
public class GoodsRetrieveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//gCode 이용 service.gooodsRetrieve(gCode)데이터 얻기 
		//GoodsDTO정보를 GoodsRetrieve.jsp로 전송
		//Mapper : goodsRetrieve 로 사용
		
		
		String gCode = request.getParameter("gCode");
		
		GoodsService service = new GoodsService();
		GoodsDTO dto = service.goodsRetrieve(gCode);
		request.setAttribute("goodsRetrieve", dto);
		RequestDispatcher dis = request.getRequestDispatcher("goodsRetrieve.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
