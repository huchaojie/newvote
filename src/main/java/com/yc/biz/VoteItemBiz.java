package com.yc.biz;

import java.util.List;

import com.yc.bean.VoteItem;

public interface VoteItemBiz {

	List<VoteItem> selectUserVote(VoteItem v);
	
	int insert(VoteItem v);
}
