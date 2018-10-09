package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.yc.bean.VoteUser;
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
	public int insert(VoteUser v) {
		return baseDao.add(v, "insert");
	}
	
	/**
	 * 登录
	 */
	@Override
	public VoteUser login(VoteUser vu) {
		List<VoteUser> list = baseDao.findAll(vu, "login");
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
