package com.kg.fieldluxe.inquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.kg.fieldluxe.inquiry.model.InquiryVO;
import com.kg.fieldluxe.inquiry.service.IInquiryService;
import com.kg.fieldluxe.member.model.MemberVO;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	@Autowired
	IInquiryService inquiryService;
	
	// GET 문의글 작성
	@GetMapping("/insertInquiry")
	public String insertInquiry(Model model) {
		model.addAttribute("mem", new MemberVO());
		return "inquiry/insert";
	}
			
	// POST 문의글 작성
	@PostMapping("/insertInquiry")
	public String insertInquiry(InquiryVO inquiry) {
		inquiryService.insertInquiry(inquiry);
		
		return "redirect:/inquiry/view?id="+inquiry.getInquiryId();
	}
	
	// 게시글 상세 정보 확인
	@RequestMapping("/{id}")
	public String view(int id, Model model) {
		InquiryVO inquiry = inquiryService.getInquiry(id);
		model.addAttribute("inquiry", inquiry);
		return "inquiry/view";
	}	
	
	// GET 게시글 수정
	@GetMapping("/update")
	public String update(@RequestParam("inquiryId")int inquiryId, Model model) {
		model.addAttribute("inquiry", inquiryService.getInquiry(inquiryId));
		return "inquiry/update";
	}
	
	// POST 게시글 수정
	@PostMapping("/update")
	public String update(@RequestParam("inquiryId")String inquiryId, InquiryVO inquiry) {
		inquiry.setInquiryId(Integer.parseInt(inquiryId));
		inquiryService.updateInquiry(inquiry);
		return "redirect:/inquiry/view?id="+inquiry.getInquiryId();
	}
	
	// 게시글 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam("id")int id) {
		inquiryService.deleteInquiry(id);
		return "redirect:/inquiry/list";
	}
		
	// 문의글 목록 확인
	@GetMapping("/list")
	public void list(@RequestParam(required=false, defaultValue="1")int page,
			@RequestParam(required=false)String word, Model model) {
		model.addAttribute("list", inquiryService.getInquiryList(page, word));
		model.addAttribute("pageManager", new com.kg.fieldluxe.util.PagingManager(inquiryService.getInquiryCount(word), page));
	}
}
