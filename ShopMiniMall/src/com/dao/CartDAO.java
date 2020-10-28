package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.OrderDTO;

public class CartDAO {

	public int cartAdd(SqlSession session, CartDTO dto) {
		int n = session.insert("CartMapper.cartAdd",dto);
		return n;
	}
	
	public List<CartDTO> cartList(SqlSession session, String userid) {
		List<CartDTO> list = session.selectList("CartMapper.cartList",userid);
		return list;
	}
	
	public int cartDel(SqlSession session, int num) {
		int n = session.delete("CartMapper.cartDel", num);
		return n;
	}
	
	public int cartUpdate(SqlSession session, HashMap<String, Integer> map) {
		int n = session.update("CartMapper.cartUpdate", map);
		return n;
	}
	
	
	public int cartAlldel(SqlSession session, List<String> list) {
		int n = session.delete("CartMapper.cartAlldel", list);
		return n;
	}
	
	public CartDTO cartByNum(SqlSession session, int num){
		CartDTO dto = null;
		dto = session.selectOne("CartMapper.cartByNum",num);
		return dto;
	}
	
	public int orderDone(SqlSession session, OrderDTO dto) {
		int n = 0;
		n = session.insert("CartMapper.orderDone", dto);
		return n;
	}
	
	
}
