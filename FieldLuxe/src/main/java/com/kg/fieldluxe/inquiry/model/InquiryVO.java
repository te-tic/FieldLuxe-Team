package com.kg.fieldluxe.inquiry.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class InquiryVO {
	
	private int inquiryId;			// 문의글 번호 or 답변글 번호
	private String inquiryTitle;	// 문의글 제목 or 답변글 제목
	private String inquiryContent;
	private String inquiryEmail; 	// 작성자 email
	private Date inquiryDate;		// 작성일
	private int answer_num; 		// 관리자의 답변일 경우 답변한 문의글의 번호
	private int answer_complete;	// 답변 완료 여부
	private String auth;
	private int cnt;
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getInquiryId() {
		return inquiryId;
	}
	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}
	public String getInquiryTitle() {
		return inquiryTitle;
	}
	public void setInquiryTitle(String inquiryTitle) {
		this.inquiryTitle = inquiryTitle;
	}
	public String getInquiryContent() {
		return inquiryContent;
	}
	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}
	public String getInquiryEmail() {
		return inquiryEmail;
	}
	public void setInquiryEmail(String inquiryEmail) {
		this.inquiryEmail = inquiryEmail;
	}
	public Date getInquiryDate() {
		return inquiryDate;
	}
	public void setInquiryDate(Date inquiryDate) {
		this.inquiryDate = inquiryDate;
	}
	public int getAnswer_num() {
		return answer_num;
	}
	public void setAnswer_num(int answer_num) {
		this.answer_num = answer_num;
	}
	public boolean isAnswerComplete() {
		return this.answer_complete == 0 ? false : true;
	}
	public void setAnswer_complete(int answer_complete) {
		this.answer_complete = answer_complete;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(this.auth));
		return authorities;
	}
}
