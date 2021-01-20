package com.kg.fieldluxe.reply.model;

import java.util.Date;

public class ReplyVO {

	private int replyId;
	private int inquiryId;
	private String replyContent;
	private String replyWriter;
	private Date replyDate;
	
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getInquiryId() {
		return inquiryId;
	}
	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [replyId=" + replyId + ", inquiryId=" + inquiryId + ", replyContent=" + replyContent
				+ ", replyWriter=" + replyWriter + ", replyDate=" + replyDate + "]";
	}
}
