package com.yc.biz;

import com.yc.bean.VoteUser;

public interface VoteuserBiz {

	/**
	 * 用户添加
	 * @param v
	 * @return
	 */
   int insert(VoteUser v);
   
   /**
	 * 登录
	 *
	 */
	VoteUser login(VoteUser vu);
}
