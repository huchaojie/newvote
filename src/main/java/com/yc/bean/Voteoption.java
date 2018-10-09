package com.yc.bean;

public class Voteoption {
    
	private int voteid;
	private String voteoption;
	private Long vsid;
	private int voteorder;
	public Integer votecount;
	
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
	public Long getVsid() {
		return vsid;
	}
	public void setVsid(Long vsid) {
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
	public Integer getVotecount() {
		return votecount;
	}
	public void setVotecount(Integer votecount) {
		this.votecount = votecount;
	}
	
	
}
