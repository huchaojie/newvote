package com.yc.web.contrcoller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.VoteUser;
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
	@ApiOperation(value = "添加数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uname", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pwd", value = "密码", required = true, dataType = "String")
    })
	@RequestMapping("/voteUser_register.action")
	@ResponseBody
	public JsonModel reg(String uname,String pwd) {
		int result;
		if(uname!=null && uname.length()>0||pwd!=null && pwd.length()>0){
			VoteUser v=new VoteUser();
			v.setUname(uname);
			v.setPwd(pwd);
			result= voteuserBiz.insert(v);
			jm.setCode(result);
			return jm;
		}else{
			return jm;
		}
	}

	/**
	 * 登录
	 */
	@RequestMapping(value = "/tologin.action", method = RequestMethod.POST)
	@ResponseBody
	public JsonModel login(VoteUser vu, HttpSession session) {
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
	public @ResponseBody JsonModel loginUser(VoteUser vu, HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			vu = (VoteUser) session.getAttribute("loginUser");
			jm.setCode(1);
			jm.setObj(vu);
		} else {
			jm.setCode(0);
		}
		return jm;
	}
}
