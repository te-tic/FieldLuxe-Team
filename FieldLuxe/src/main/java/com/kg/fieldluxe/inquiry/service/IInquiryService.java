package com.kg.fieldluxe.inquiry.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kg.fieldluxe.inquiry.model.InquiryVO;

public interface IInquiryService {

	List<InquiryVO> getInquiryList(int page, String word);
	Integer getInquiryCount(String word);
	InquiryVO getInquiry(int id);
	int insertInquiry(InquiryVO inquiry);
	public void deleteInquiry(int id);
	public boolean updateInquiry(InquiryVO inquiry);
}
