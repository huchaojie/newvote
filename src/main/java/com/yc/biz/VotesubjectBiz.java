package com.yc.biz;

import java.util.List;

import com.yc.bean.Voteoption;
import com.yc.bean.Votesubject;

public interface VotesubjectBiz {

	int insert(Votesubject v,String[] arr);
	
	List<Votesubject> selectVoteAll(Votesubject v);
	
	
}
