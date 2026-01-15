package com.mbc.pro.dto;

import java.io.Serializable;

public class BbsComment implements Serializable{
	
	private int seq;
	private int bbsseq;
	private String id;
	private String content;
	private String wdate;
	
	public BbsComment() {
	}

	public BbsComment(int seq, int bbsseq, String id, String content, String wdate) {
		super();
		this.seq = seq;
		this.bbsseq = bbsseq;
		this.id = id;
		this.content = content;
		this.wdate = wdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getBbsseq() {
		return bbsseq;
	}

	public void setBbsseq(int bbsseq) {
		this.bbsseq = bbsseq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "BbsComment [seq=" + seq + ", bbsseq=" + bbsseq + ", id=" + id + ", content=" + content + ", wdate="
				+ wdate + "]";
	}

}
