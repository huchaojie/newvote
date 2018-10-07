package com.yc.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.bean.VoteUser;
import com.yc.service.VoteService;
import com.yc.util.JsonModel;

@Controller
@SessionAttributes("vote")
public class VoteUserController {
	
	@Resource(name="voteServiceImpl")
	private VoteService voteService;
	/**
	 * 登录
	 */
	@RequestMapping(value = "login.action",method=RequestMethod.POST)
	public @ResponseBody JsonModel login(VoteUser vu,HttpSession session,HttpServletRequest req){
		JsonModel js= new JsonModel();
		vu = voteService.login(vu);
		if(vu!=null && !"".equals(vu)){
			session.setAttribute("vu", vu);
			js.setCode(1);
			return js;
		}
		js.setCode(0);
		return js;
	}
}
