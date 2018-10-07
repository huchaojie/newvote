package com.yc.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yc.bean.VoteItem;
import com.yc.bean.VoteOption;
import com.yc.bean.VoteSubject;
import com.yc.bean.VoteUser;

/**
 * Vote接口类
 * @author Administrator
 *
 */
@Repository
public interface VoteService {
	/**
	 * 登录
	 *
	 */
	VoteUser login(VoteUser vu);
}