package com.kg.fieldluxe.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kg.fieldluxe.reply.model.ReplyVO;
import com.kg.fieldluxe.reply.repository.IReplyRepository;

@Service
public class ReplyService implements IReplyService{

	@Autowired
	IReplyRepository ReplyRepository;
	
	@Override
	public List<ReplyVO> list(int inquiryId) {
		return ReplyRepository.list(inquiryId);
	}

	@Override
	public int count(int inquiryId) {
		return 0;
	}

	@Override
	public void create(ReplyVO reply) {
		ReplyRepository.create(reply);
	}

	@Override
	public void delete(int replyId) {
		ReplyRepository.delete(replyId);
	}

	@Override
	public void update(ReplyVO reply) {
		ReplyRepository.update(reply);
	}

	@Override
	public Integer updateInquiry(int inquiryComplete, int inquiryId) {
		return ReplyRepository.updateInquiry(inquiryComplete, inquiryId);
	}	

}
