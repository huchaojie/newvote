package com.yc.bean;

public class Voteoption {
    
	private int voteid;
	private String voteoption;
	private int vsid;
	private int voteorder;
	public int getVoteid() {
		return voteid;
	}
	public void setVoteid(int voteid) {
		this.voteid = voteid;
	}
	public String getVoteoption() {
		return voteoption;
	}
	public void setVoteoption(String voteoption) {
		this.voteoption = voteoption;
	}
	public int getVsid() {
		return vsid;
	}
	public void setVsid(int vsid) {
		this.vsid = vsid;
	}
	public int getVoteorder() {
		return voteorder;
	}
	public void setVoteorder(int voteorder) {
		this.voteorder = voteorder;
	}
	@Override
	public String toString() {
		return "Voteoption [voteid=" + voteid + ", voteoption=" + voteoption
				+ ", vsid=" + vsid + ", voteorder=" + voteorder + "]";
	}
	
	
}
