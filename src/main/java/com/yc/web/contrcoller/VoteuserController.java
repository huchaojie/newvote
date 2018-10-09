package com.yc.web.contrcoller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Voteuser;
import com.yc.biz.VoteuserBiz;
import com.yc.util.JsonModel;

@Controller
public class VoteuserController {

	@Resource(name = "voteuserBizImpl")
	private VoteuserBiz voteuserBiz;

	JsonModel jm = new JsonModel();

	/**
	 * 用户注册
	 * 
	 * @param v
	 * @return
	 */
	@RequestMapping("/voteUser_register.action")
	@ResponseBody
	public JsonModel reg(Voteuser v) {
		if (v != null && "".equals(v)) {
			int result = voteuserBiz.insert(v);
			jm.setCode(result);
			return jm;
		}
		jm.setCode(0);
		return jm;
	}

	/**
	 * 登录
	 */
	@RequestMapping(value = "/voteUser_login.action", method = RequestMethod.POST)
	public @ResponseBody JsonModel login(Voteuser vu, HttpSession session, HttpServletRequest req) {
		vu = voteuserBiz.login(vu);
		if (vu != null && !"".equals(vu)) {
			session.setAttribute("loginUser", vu);
			jm.setCode(1);
			return jm;
		} else {
			jm.setCode(0);
			jm.setError("user does not exist.");
			return jm;
		}
	}

	@RequestMapping(value = "/voteSubject_getLoginUser.action", method = RequestMethod.POST)
	public @ResponseBody JsonModel loginUser(Voteuser vu, HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			vu = (Voteuser) session.getAttribute("loginUser");
			jm.setCode(1);
			jm.setObj(vu);
		} else {
			jm.setCode(0);
		}
		return jm;
	}
}
