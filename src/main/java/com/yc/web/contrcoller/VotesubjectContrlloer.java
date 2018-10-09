package com.yc.web.contrcoller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.VoteItem;
import com.yc.bean.Voteoption;
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
	 * @param vpoifd76427 
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

	@RequestMapping("/voteSubject_findAll.action")
	@ResponseBody
	public JsonModel voteSubject_findAll(HttpSession session){
		try {
			List<Votesubject> list = votesubjectBiz.getAllSubjects();
			session.setAttribute("subjectlist", list);
			jm.setCode(1);
			jm.setObj(list);
		} catch (Exception e) {
			e.printStackTrace();
			jm.setCode(0);
		}
		return jm;
	}
	
	@RequestMapping("/voteSubject_findByVsidWithOptionInfo.action")
	@ResponseBody
	public JsonModel voteSubject_findByVsidWithOptionInfo(HttpSession session){
		//从session中取出subject
		Votesubject vs = (Votesubject) session.getAttribute("votesubject");
		//根据vsid编号 查询这个主题中所有的投票的信息
		List<VoteItem> list = votesubjectBiz.statVoteCountPerOptionOfSubject(vs.getVsid());
		for(VoteItem vi : list){
			//取出voteitem投票信息,再取出  vs中所有的选项, 
			for(  int i=0;i<vs.getOptions().size();i++){
				Voteoption vo=vs.getOptions().get(i);
				//如果这个选 项被 用户投了
				if( vo.getVoteid()== vi.getVoteid()){
					vo.setVotecount(   vi.getVotecount()  );
					vs.getOptions().set(i, vo);   //这样在  vs中就有投票项，也有这个投票项的用户投票数
				}
			}
		}
		return jm;
	}
}
