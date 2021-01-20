package com.kg.fieldluxe.reply.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kg.fieldluxe.reply.model.ReplyVO;

public interface IReplyRepository {

	public List<ReplyVO> list(int inquiryId);
	public int count(int inquiryId);
	public void create(ReplyVO reply);
	public void update(ReplyVO reply);
	public void delete(@Param("replyId")int replyId);
	public Integer updateInquiry(int inquiryComplete, int inquiryId);
}
