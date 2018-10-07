package com.yc.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Voteuser;
import com.yc.biz.VoteuserBiz;
import com.yc.util.JsonModel;

@Controller
public class VoteuserController {

	@Resource(name="voteuserBizImpl")
	private VoteuserBiz voteuserBiz;
	
	JsonModel jm =new JsonModel();
	
	
	/**
	 * 用户注册
	 * @param v
	 * @return
	 */
	@RequestMapping("/voteUser_register.action")
	@ResponseBody
	public JsonModel  reg(Voteuser v){
	
			int result=voteuserBiz.insert(v);
			jm.setCode(result);
			return jm;
	}

}
