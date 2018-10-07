package com.yc.web.contrcoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HtmlController {
	/**
	 * 进入登录页面 跳转到index.jsp
	 */
	@RequestMapping("login.action")
	public String gotoindex() {
		return "index";
	}

	// 进入注册界面
	@RequestMapping("register.action")
	public String gotoreg() {
		return "register";
	}

	@RequestMapping("manage.action")
	public String manage() {
		return "manage";
	}

	@RequestMapping("add.action")
	public String add() {
		return "add";
	}

}
