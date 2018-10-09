package com.yc.biz.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.VoteItem;
import com.yc.bean.Voteoption;
import com.yc.bean.Votesubject;
import com.yc.biz.VoteoptionBiz;
import com.yc.biz.VotesubjectBiz;
import com.yc.dao.BaseDao;

@Service
public class VotesubjectBizImpl implements VotesubjectBiz {

	private BaseDao baseDao;

	private VoteoptionBiz voteoptionBiz;

	@Resource(name = "voteoptionBizImpl")
	public void setVoteoptionBiz(VoteoptionBiz voteoptionBiz) {
		this.voteoptionBiz = voteoptionBiz;
	}

	@Resource(name = "baseDaoImpl")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public int insert(Votesubject v, String[] arr) {
		int result = baseDao.add(v, "insert");
		if (result > 0) {
			List<Voteoption> list = new ArrayList<Voteoption>();
			for (int i = 0; i < arr.length; i++) {
				Voteoption vp = new Voteoption();
				vp.setVoteoption(arr[i]);
				vp.setVsid(v.getVsid());
				vp.setVoteorder(i + 1);
				list.add(vp);
			}
			v.setVoteoption(list);
			for (Voteoption vp : v.getVoteoption()) {
				voteoptionBiz.insert(vp);
			}
			return 1;
		}
		return 0;
	}

	@Override
	public List getAllSubjects() {
		Votesubject vs = new Votesubject();
		List<Object> list = new ArrayList<Object>();
		list =baseDao.findAll(vs, "getAll");
		return list;
	}

	@Override
	public List statVoteCountPerOptionOfSubject(Long entityId){
		VoteItem vi = new VoteItem();
		List<Object> list = new ArrayList<Object>();
		list = baseDao.findAll(vi, "find");
		return list;
	}

}
