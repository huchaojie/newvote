package com.yc.bean;

import java.io.Serializable;

public class VoteOption implements Serializable{
	private static final long serialVersionUID = -1989195577120893816L;
	private Integer voteid; 
	private String voteoption; 
	private Integer voteorder;
	private Integer vsid; 
	
	public Integer votecount;
	
	public Integer getVotecount() {
		return votecount;
	}

	public void setVotecount(Integer votecount) {
		this.votecount = votecount;
	}

	public Integer getVoteid() {
		return voteid;
	}

	public void setVoteid(Integer voteid) {
		this.voteid = voteid;
	}

	public String getVoteoption() {
		return voteoption;
	}

	public void setVoteoption(String voteoption) {
		this.voteoption = voteoption;
	}

	public Integer getVoteorder() {
		return voteorder;
	}

	public void setVoteorder(Integer voteorder) {
		this.voteorder = voteorder;
	}

	public Integer getVsid() {
		return vsid;
	}

	public void setVsid(Integer vsid) {
		this.vsid = vsid;
	}

	@Override
	public String toString() {
		return "VoteOption [voteid=" + voteid + ", voteoption=" + voteoption
				+ ", voteorder=" + voteorder + ", vsid=" + vsid + "]";
	}

}
