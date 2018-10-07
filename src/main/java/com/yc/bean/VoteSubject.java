package com.yc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//投票主题类
public class VoteSubject implements Serializable {
	private static final long serialVersionUID = 2355607921906535471L;
	public final static int TYPE_SINGLE = 1; // 单选
	public final static int TYPE_MULTIPLE = 2; // 复选

	private Long vsid; // 编号
	private String title; // 标题
	private int stype = 1; // 类型

	private Integer usercount; 	// 给这个主题投票的用户数, 这个用来匹配 select vsid as id,count(
								// distinct(uid)) as usercount from voteitem
								// group by vsid

	/*
	 * select votesubject.vsid, count( * ) as optioncount
		from votesubject
		inner join voteoption
		on voteoption.vsid=votesubject.vsid
		group by votesubject.vsid
	 */
	private Integer optioncount; // 这个主题的选项数 
	
	
	private List<VoteOption> options=new ArrayList<VoteOption>();
	
	
	private List<Long> chooseIds=new ArrayList<Long>();
	
	private List<String> voteoptions=new ArrayList<String>();
	
	
	
	
	

	public List<String> getVoteoptions() {
		return voteoptions;
	}

	public void setVoteoptions(List<String> voteoptions) {
		this.voteoptions = voteoptions;
	}

	public List<Long> getChooseIds() {
		return chooseIds;
	}

	public void setChooseIds(List<Long> chooseIds) {
		this.chooseIds = chooseIds;
	}

	public List<VoteOption> getOptions() {
		return options;
	}

	public void setOptions(List<VoteOption> options) {
		this.options = options;
	}

	public Integer getOptioncount() {
		return optioncount;
	}

	public void setOptioncount(Integer optioncount) {
		this.optioncount = optioncount;
	}

	public Integer getUsercount() {
		return usercount;
	}

	public void setUsercount(Integer usercount) {
		this.usercount = usercount;
	}

	public Long getVsid() {
		return vsid;
	}

	public void setVsid(Long vsid) {
		this.vsid = vsid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStype() {
		return stype;
	}

	public void setStype(int stype) {
		this.stype = stype;
	}

	@Override
	public String toString() {
		return "VoteSubject [vsid=" + vsid + ", title=" + title + ", stype="
				+ stype + ", usercount=" + usercount + ", optioncount="
				+ optioncount + ", options=" + options + "]";
	}

	

	

}
