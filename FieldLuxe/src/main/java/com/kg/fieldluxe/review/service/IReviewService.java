package com.kg.fieldluxe.review.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kg.fieldluxe.review.model.ReviewVO;

public interface IReviewService {

	List<ReviewVO> getReviewList(@Param("page")int page, @Param("word")String word, String reviewTarget);
	Integer getReviewCount(@Param("word")String word);
	public int insertReview(ReviewVO review);
	public boolean updateReview(ReviewVO review);
	public boolean deleteReview(@Param("reviewId")int reviewId);
}
