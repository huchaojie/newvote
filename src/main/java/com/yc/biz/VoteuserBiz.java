package com.yc.biz;

import com.yc.bean.Voteuser;

public interface VoteuserBiz {

	/**
	 * 用户添加
	 * @param v
	 * @return
	 */
   int insert(Voteuser v);
   
   /**
	 * 登录
	 *
	 */
	Voteuser login(Voteuser vu);
}
