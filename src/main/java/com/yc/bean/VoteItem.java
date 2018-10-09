package com.yc.bean;

import java.io.Serializable;

//用户选择的选项
public class VoteItem implements Serializable{
	private static final long serialVersionUID = 700330404252253236L;
	private Integer viid; // 编号
	private Integer vsid; // 主题
	private Integer voteid; // 用户确定选择的选项
	private Integer uid; // 用户
	
	private Integer nums;

	
	public void setNums(Integer nums) {
		this.nums = nums;
	}

	public Integer getNums() {
		return nums;
	}

	public Integer getViid() {
		return viid;
	}

	public void setViid(Integer viid) {
		this.viid = viid;
	}

	public Integer getVsid() {
		return vsid;
	}

	public void setVsid(Integer vsid) {
		this.vsid = vsid;
	}

	public Integer getVoteid() {
		return voteid;
	}

	public void setVoteid(Integer voteid) {
		this.voteid = voteid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "VoteItem [viid=" + viid + ", vsid=" + vsid + ", voteid="
				+ voteid + ", uid=" + uid + ", nums=" + nums + "]";
	}

}
