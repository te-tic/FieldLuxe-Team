package com.kg.fieldluxe.inquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kg.fieldluxe.inquiry.model.InquiryVO;
import com.kg.fieldluxe.inquiry.repository.IInquiryRepository;

@Service
public class InquiryService implements IInquiryService{

	@Autowired
	@Qualifier("IInquiryRepository")
	IInquiryRepository inquiryRepository;
	
	@Override
	public List<InquiryVO> getInquiryList(int page, String word) {
		return inquiryRepository.getInquiryList(page, word);
	}

	@Override
	public Integer getInquiryCount(String word) {
		return inquiryRepository.getInquiryCount(word);
	}

	@Override
	public InquiryVO getInquiry(int id) {
		return inquiryRepository.getInquiry(id);
	}

	@Override
	public int insertInquiry(InquiryVO inquiry) {
		return inquiryRepository.insertInquiry(inquiry);
	}

	@Override
	@Transactional("transactionManager")
	public void deleteInquiry(int id) {
		inquiryRepository.deleteReply(id);
		 inquiryRepository.deleteInquiry(id);
	}

	@Override
	public boolean updateInquiry(InquiryVO inquiry) {
		return inquiryRepository.updateInquiry(inquiry);
	}



	
	
}
