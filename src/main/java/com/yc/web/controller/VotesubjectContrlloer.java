package com.yc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Votesubject;
import com.yc.biz.VotesubjectBiz;
import com.yc.util.JsonModel;
/**
 * @author HuChaoJie
 */
@Controller
public class VotesubjectContrlloer {

	@Resource(name = "votesubjectBizImpl")
	private VotesubjectBiz votesubjectBiz;

	JsonModel jm = new JsonModel();

	/**
	 * 添加投票
	 * @param v
	 * @param voteoptions
	 * @return
	 */
	@RequestMapping("/voteSubject_add.action")
	@ResponseBody
	public JsonModel voteSubject_add(Votesubject v,
			@RequestParam("voteoptions") String[] voteoptions) {

		int result = votesubjectBiz.insert(v, voteoptions);
		jm.setCode(result);
		return jm;
	}

}
