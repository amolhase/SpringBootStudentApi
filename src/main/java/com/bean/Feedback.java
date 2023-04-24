package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "feedback")
public class Feedback 
{
	@Id
	private int fid;
	private String feed;
	private int sid;
	
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(int fid, String feed, int sid) {
		super();
		this.fid = fid;
		this.feed = feed;
		this.sid = sid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFeed() {
		return feed;
	}

	public void setFeed(String feed) {
		this.feed = feed;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Feedback [fid=" + fid + ", feed=" + feed + ", sid=" + sid + "]";
	}
	
}
