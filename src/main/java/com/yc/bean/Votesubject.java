package com.yc.bean;

import java.util.ArrayList;
import java.util.List;

public class Votesubject {

	private Integer vsid;
	private String title;
	private int stype;
	
	private List<Voteoption> voteoption;
	private Integer usercount;
	private Integer optioncount; // 这个主题的选项数
	private List<Voteoption> options = new ArrayList<Voteoption>();
	private List<Long> chooseIds = new ArrayList<Long>();
	private List<String> voteoptions = new ArrayList<String>();

	public Integer getVsid() {
		return vsid;
	}

	public void setVsid(Integer entityId) {
		this.vsid = entityId;
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

	public List<Voteoption> getVoteoption() {
		return voteoption;
	}

	public void setVoteoption(List<Voteoption> voteoption) {
		this.voteoption = voteoption;
	}

	public Integer getUsercount() {
		return usercount;
	}

	public void setUsercount(Integer usercount) {
		this.usercount = usercount;
	}

	public Integer getOptioncount() {
		return optioncount;
	}

	public void setOptioncount(Integer optioncount) {
		this.optioncount = optioncount;
	}

	public List<Voteoption> getOptions() {
		return options;
	}

	public void setOptions(List<Voteoption> options) {
		this.options = options;
	}

	public List<Long> getChooseIds() {
		return chooseIds;
	}

	public void setChooseIds(List<Long> chooseIds) {
		this.chooseIds = chooseIds;
	}

	public List<String> getVoteoptions() {
		return voteoptions;
	}

	public void setVoteoptions(List<String> voteoptions) {
		this.voteoptions = voteoptions;
	}

	@Override
	public String toString() {
		return "Votesubject [vsid=" + vsid + ", title=" + title + ", stype=" + stype + ", voteoption=" + voteoption
				+ ", usercount=" + usercount + ", optioncount=" + optioncount + ", options=" + options + ", chooseIds="
				+ chooseIds + ", voteoptions=" + voteoptions + "]";
	}
}
