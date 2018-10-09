package com.yc.web.contrcoller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.VoteItem;
import com.yc.bean.Voteoption;
import com.yc.bean.Votesubject;
import com.yc.bean.VoteUser;
import com.yc.biz.VoteItemBiz;
import com.yc.biz.VoteoptionBiz;
import com.yc.biz.VotesubjectBiz;
import com.yc.util.JsonModel;
/**
 * @author HuChaoJie
 */
@Controller
public class VotesubjectContrlloer {

	@Resource(name = "votesubjectBizImpl")
	private VotesubjectBiz votesubjectBiz;
	
	@Resource(name = "voteoptionBizImpl")
	private VoteoptionBiz voteoptionBiz;
	
	@Resource(name = "voteItemBizImpl")
	private VoteItemBiz voteItemBiz;

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
	public JsonModel voteSubject_findByVsidWithOptionInfo(HttpSession session,Integer entityId){
		VoteItem vim=new VoteItem();
		vim.setVsid(entityId);
		//从session中取出subject
		Votesubject vs = (Votesubject) session.getAttribute("votesubject");
		//根据vsid编号 查询这个主题中所有的投票的信息
		
		List<VoteItem> list = votesubjectBiz.statVoteCountPerOptionOfSubject(vim);
		System.out.println(list);
		System.out.println(vs);
		for(VoteItem vi : list){
			//取出voteitem投票信息,再取出  vs中所有的选项, 
			for(  int i=0;i<vs.getVoteoption().size();i++){
				Voteoption vo=vs.getVoteoption().get(i);
				//如果这个选 项被 用户投了
				if( vo.getVoteid()== vi.getVoteid()){
					vo.setVotecount(   vi.getVotecount()  );
					vs.getVoteoption().set(i, vo);   //这样在  vs中就有投票项，也有这个投票项的用户投票数
				}
			}
		}
		System.out.println(vs);
		jm.setCode(1);
		jm.setObj(vs);
		return jm;
	}
	
	/**
	 * 显示投票内容
	 * @param entityId
	 * @return
	 */
	@ApiOperation("显示投票内容")
	@ApiImplicitParam(name="entityId",value="投票id",required=true,dataType="Integer")
	@RequestMapping("voteSubject_findByVsid.action")
	@ResponseBody
	public JsonModel Vote(Integer entityId,HttpSession session){
		Votesubject vs=new Votesubject();
		vs.setVsid(entityId);
		
		List<Votesubject> list=votesubjectBiz.selectVoteAll(vs);
		List<Voteoption> lists=voteoptionBiz.selectVoteoptionAll(entityId);
		for (Votesubject v : list) {
			v.setVoteoption(lists);
			vs=v;
		}
		session.setAttribute("votesubject", vs);
		jm.setObj(vs);
		jm.setCode(1);
		return jm;
	}
	
	/**
	 * 投票
	 * @param entityId
	 * @return
	 */
	@ApiOperation("投票")
	@ApiImplicitParams({
		@ApiImplicitParam(name="vsid",value="投票id",required=true,dataType="Integer"),
		@ApiImplicitParam(name="chooseIds",value="投票",required=true,dataType="Integer")
	})
	@RequestMapping("voteSubject_vote.action")
	@ResponseBody
	public JsonModel voteSubject_vote(Integer vsid,Integer chooseIds,HttpSession session){
		VoteUser vu=(VoteUser) session.getAttribute("loginUser");
		VoteItem vi=new VoteItem();
		try {
			vi.setUid(vu.getUid());
			vi.setVsid(vsid);
			List<VoteItem> list=voteItemBiz.selectUserVote(vi);
			if(list.get(0).getNums()>0){
				jm.setCode(0);
				jm.setError("you have vote once!");
			}else{
				
				vi.setVoteid(chooseIds);
				int result=voteItemBiz.insert(vi);
				jm.setCode(result);
			}
		} catch (NullPointerException e) {
			jm.setCode(2);
			jm.setError("You haven't logged in yet!");
			return jm;
		}
		return jm;
	}
	
}
