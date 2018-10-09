package com.yc.biz;

import java.util.List;

import com.yc.bean.Voteoption;

public interface VoteoptionBiz {

	int insert(Voteoption v);
	
	List<Voteoption> selectVoteoptionAll(Integer v);
}
