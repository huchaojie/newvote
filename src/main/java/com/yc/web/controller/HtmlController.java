package com.yc.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {
	/**
	 * 进入登录页面 跳转到index.jsp
	 */
	@RequestMapping("/toindex.action")
	public String gotoindex(HttpSession session){
		session.removeAttribute("student");
        return "login";
	}
	@RequestMapping("/toreg.action")
	public String gotoreg(HttpSession session){
		session.removeAttribute("student");
        return "reg";
	}
}
