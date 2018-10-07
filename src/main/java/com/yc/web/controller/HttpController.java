package com.yc.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HttpController {
	/**
	 * 进入登录界面 跳转到login界面
	 */
	@RequestMapping("/tologin.action")
	public String gotologin(HttpSession session){
		session.removeAttribute("vote");
		return "index";
	}
	/**
	 * 跳转到manage界面
	 * @return
	 */
	@RequestMapping("/tomanage.action")
	public String gomanage(){
		return "manage";
	}
	/**
	 * 跳转到add界面
	 */
	@RequestMapping("/toadd.action")
	public String goadd(){
		return "add";
	}
	/**
	 * 跳转到注册register界面
	 */
	@RequestMapping("/toregister.action")
	public String goregister(){
		return "register";
	}
}
