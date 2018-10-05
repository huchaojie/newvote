package com.yc.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.Voteoption;
import com.yc.biz.VoteoptionBiz;
import com.yc.dao.BaseDao;

@Service
public class VoteoptionBizImpl implements VoteoptionBiz {
	
	
	private BaseDao baseDao;
	
	@Resource(name="baseDaoImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public int insert(Voteoption v) {
		return baseDao.add(v, "insert");
	}

}
