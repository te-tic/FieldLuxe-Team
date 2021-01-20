package com.kg.fieldluxe.inquiry.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kg.fieldluxe.inquiry.model.InquiryVO;

public interface IInquiryRepository {

	List<InquiryVO> getInquiryList(@Param("page")int page, @Param("word")String word);
	Integer getInquiryCount(@Param("word")String word);
	public InquiryVO getInquiry(@Param("inquiryId")int id);
	public int insertInquiry(InquiryVO inquiry);
	public void deleteInquiry(@Param("inquiryId")int id);
	public void deleteReply(@Param("inquiryId")int id);
	public boolean updateInquiry(InquiryVO inquiry); 
}
