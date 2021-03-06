package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDao;

@Controller
public class GoodsController {
	
	@Autowired
	private GoodsDao dao;

	public GoodsDao getDao() {
		return dao;
	}
	
	@RequestMapping("/detailGoods.do")
	public ModelAndView detail(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("g", dao.select(no));
		return mav;
	}
	
	@RequestMapping("/listGoods.do")
	public ModelAndView listGoods() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll());
		return mav;
	}
}
