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

	@RequestMapping("/voteSubject_findAll.action")
	@ResponseBody
	public JsonModel findAll(Voteuser v) {
		int result = voteuserBiz.insert(v);
		jm.setCode(result);
		return jm;
	}
	
	/**
	 * 登录
	 */
	@RequestMapping(value = "login.action",method=RequestMethod.POST)
	public @ResponseBody JsonModel login(Voteuser vu,HttpSession session,HttpServletRequest req){
		JsonModel js= new JsonModel();
		vu = voteuserBiz.login(vu);
		if(vu!=null && !"".equals(vu)){
			session.setAttribute("vu", vu);
			js.setCode(1);
			return js;
		}
		js.setCode(0);
		return js;
	}

}
