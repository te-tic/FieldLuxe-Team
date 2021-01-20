package com.kg.fieldluxe.review.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kg.fieldluxe.member.model.MemberVO;
import com.kg.fieldluxe.review.model.ReviewVO;
import com.kg.fieldluxe.review.service.IReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	IReviewService reviewService;
	
	// GET 문의글 작성
		@GetMapping("/insertReview")
		public String insertReview(Model model) {
			model.addAttribute("product", new MemberVO());
			return "review/insert";
		}
				
		// POST 문의글 작성
		@PostMapping("/insertReview")
		public String insertInquiry(ReviewVO review) {
			reviewService.insertReview(review);
			
			return "redirect:/home";
		}
		
	@GetMapping("/list")
	public void reviewList(@RequestParam(required=false, defaultValue="1")int page, 
			@RequestParam(required=false)String word,  Model model) {
		Map<Integer, String> starRating = new HashMap<Integer, String>();
		starRating.put(0, "☆☆☆☆☆");
		starRating.put(1, "★☆☆☆☆");
		starRating.put(2, "★★☆☆☆");
		starRating.put(3, "★★★☆☆");
		starRating.put(4, "★★★★☆");
		starRating.put(5, "★★★★★");
		model.addAttribute("list", reviewService.getReviewList(page, word, "admin"));
		model.addAttribute("starRating", starRating);
		model.addAttribute("pageManager", new com.kg.fieldluxe.util.PagingManager(reviewService.getReviewCount(word), page));
		
	}
}
