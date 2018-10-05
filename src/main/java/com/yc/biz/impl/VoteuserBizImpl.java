package com.yc.biz.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.yc.bean.Voteuser;
import com.yc.biz.VoteuserBiz;
import com.yc.dao.BaseDao;

@Service
public class VoteuserBizImpl implements VoteuserBiz{

	private BaseDao baseDao;
	
	@Resource(name="baseDaoImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}


	@Override
	public int insert(Voteuser v) {
		return baseDao.add(v, "insert");
	}

}
