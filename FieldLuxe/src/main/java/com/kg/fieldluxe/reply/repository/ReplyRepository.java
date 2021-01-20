package com.kg.fieldluxe.reply.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kg.fieldluxe.reply.model.ReplyVO;

@Repository
public class ReplyRepository implements IReplyRepository{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<ReplyVO> list(int inquiryId) {
		return sqlSession.selectList("reply.listReply", inquiryId);
	}

	@Override
	public int count(int inquiryId) {
		return 0;
	}

	@Override
	public void create(ReplyVO reply) {
		sqlSession.insert("reply.insertReply", reply);
	}

	@Override
	public void update(ReplyVO reply) {
		sqlSession.update("reply.updateReply", reply);
	}

	@Override
	public void delete(int replyId) {
		sqlSession.delete("reply.deleteReply", replyId);
	}

	@Override
	public Integer updateInquiry(int inquiryComplete, int inquiryId) {
		return sqlSession.update("reply.updateInquiry", inquiryId);
	}

}
