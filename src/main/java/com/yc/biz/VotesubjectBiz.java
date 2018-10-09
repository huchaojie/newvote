package com.yc.biz;

import java.util.List;

import com.yc.bean.Voteoption;
import com.yc.bean.Votesubject;

public interface VotesubjectBiz {

	int insert(Votesubject v,String[] arr);
	
	/**
	 * 获取所有的投票主题
	 * @throws Exception 
	 */
	public List getAllSubjects();
	
	/**
	 * 某个主题的每个投票项的投票数
	 * @param integer
	 * @return
	 * @throws Exception 
	 */
	public List statVoteCountPerOptionOfSubject(Integer integer);
	
	List<Votesubject> selectVoteAll(Votesubject v);
	
	
}
