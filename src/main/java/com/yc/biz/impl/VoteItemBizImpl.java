package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.VoteItem;
import com.yc.biz.VoteItemBiz;
import com.yc.dao.BaseDao;

@Service
public class VoteItemBizImpl implements VoteItemBiz{

    private BaseDao baseDao;
	
	@Resource(name="baseDaoImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public List<VoteItem> selectUserVote(VoteItem v) {
		
		return baseDao.findAll(v, "selectUserVote");
	}

	@Override
	public int insert(VoteItem v) {
		
		return baseDao.add(v, "insert");
	}

}
