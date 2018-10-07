package com.yc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.VoteUser;
import com.yc.dao.BaseDao;
import com.yc.service.VoteService;

@Service
@Transactional
public class VoteServiceImpl implements VoteService{

	@Resource(name= "baseDaoImpl")
	private BaseDao<VoteUser> baseDao;
	/**
	 * 登录
	 */
	@Override
	public VoteUser login(VoteUser vu) {
		List<VoteUser> list = this.baseDao.findAll(vu, "login");
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
}
