package com.kg.fieldluxe.reply.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kg.fieldluxe.reply.model.ReplyVO;
import com.kg.fieldluxe.reply.service.IReplyService;

// JSON 이나 데이터를 보낼때 사용
@RestController
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	IReplyService replyService;
	
	// 답글 목록 확인
	@RequestMapping(value="/list", produces="application/json; charset=utf8")
	// ResponseEntity 의 헤더를 통해 상태코드, 응답 메시지를 보내줌
	public ResponseEntity<String> list(int inquiryId, @ModelAttribute("replyVO") ReplyVO reply, HttpServletRequest request) 
		throws Exception {
			HttpHeaders responseHeaders = new HttpHeaders();
			ArrayList<HashMap<String, Object>> htmllist = new ArrayList<HashMap<String, Object>>();
			List<ReplyVO> replyVO = replyService.list(inquiryId);
			
			if(replyVO.size() > 0) {
				for(int i = 0; i < replyVO.size(); i++) {
					HashMap<String, Object> hm = new HashMap<String, Object>();
					hm.put("rno", replyVO.get(i).getReplyId());
					hm.put("content", replyVO.get(i).getReplyContent());
					hm.put("writer", replyVO.get(i).getReplyWriter());
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String regDate = dateFormat.format(replyVO.get(i).getReplyDate());
					hm.put("date", regDate);
					
					htmllist.add(hm);
				}
			}
			JSONArray json = new JSONArray(htmllist);
			return new ResponseEntity<String>(json.toString(), responseHeaders, HttpStatus.CREATED);
	}
	
	// 답글 추가
	@ResponseBody
	@RequestMapping(value="/insertReply", produces="application/json; charset=utf8")
	public Map<String, Object> insertReply(String replyWriter, @ModelAttribute("replyVO")ReplyVO reply, @RequestBody Map<String, Object> allData) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			reply.setInquiryId(Integer.parseInt(String.valueOf(allData.get("inquiryId"))));
			reply.setReplyContent(String.valueOf(allData.get("replyContent")));
			reply.setReplyWriter(String.valueOf(allData.get("replyWriter")));
			replyService.create(reply);
			replyService.updateInquiry(1, reply.getInquiryId());
			map.put("success", "success");
			
		} catch (Exception e) {
			System.out.println("insertReply Exception!");
			e.printStackTrace();
		}
		return map;
	}
	
	// 답글 수정
	@ResponseBody
	@RequestMapping("/updateReply")
	public Map<String, Object> updateReply( @ModelAttribute("replyVO")ReplyVO reply, @RequestBody Map<String, Object> allData) {
		Map<String, Object> map = new HashMap<String, Object>();
		
			System.out.println(Integer.parseInt(String.valueOf(allData.get("inquiryId"))));
			System.out.println(Integer.parseInt(String.valueOf(allData.get("replyId"))));
			System.out.println(String.valueOf(allData.get("replyContent")));
			System.out.println(String.valueOf(allData.get("replyWriter")));
			
			reply.setInquiryId(Integer.parseInt(String.valueOf(allData.get("inquiryId"))));
			reply.setReplyId(Integer.parseInt(String.valueOf(allData.get("replyId"))));
			reply.setReplyContent(String.valueOf(allData.get("replyContent")));
			reply.setReplyWriter(String.valueOf(allData.get("replyWriter")));
		
		replyService.update(reply);
		map.put("success", "success");
		return map;
	}
	
	// 답글 삭제
	@ResponseBody
	@RequestMapping(value="/deleteReply", produces="application/json; charset=utf8")
	public Map<String, Object> deleteReply(String writer, @RequestBody Map<String, Object> allData, @ModelAttribute("replyVO")ReplyVO reply) {
		Map<String, Object> map = new HashMap<String, Object>();
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();

		replyService.delete(Integer.parseInt(String.valueOf(allData.get("replyId"))));
		map.put("success", "success");
		return map;
	}
}
