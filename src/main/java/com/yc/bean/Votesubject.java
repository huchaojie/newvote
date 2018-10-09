package com.yc.bean;

import java.util.List;

public class Votesubject {

	private int vsid;
	private String title;
	private int   stype;
	
	
	
	private Integer usercount;
	private Integer  optioncount;
	private List<Voteoption> voteoption;
	
	
	public int getVsid() {
		return vsid;
	}
	public void setVsid(int vsid) {
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
	@Override
	public String toString() {
		return "Votesubject [vsid=" + vsid + ", title=" + title + ", stype="
				+ stype + ", usercount=" + usercount + ", optioncount="
				+ optioncount + ", voteoption=" + voteoption + "]";
	}
	
}
