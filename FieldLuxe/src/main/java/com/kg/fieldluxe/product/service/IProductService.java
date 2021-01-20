package com.kg.fieldluxe.product.service;

import java.util.List;

import com.kg.fieldluxe.product.model.ListData;
import com.kg.fieldluxe.product.model.ProductVO;

public interface IProductService {
	
	// 목록
	List<ListData> list(boolean check, String condition);
	
	// 상세 보기
	ProductVO detail(int id);
	
	// 물품 등록
	void insert(ProductVO product);
	
	// 물품 수정
	void update(ProductVO product, char status, String rejectReason);
	
	// 물품 삭제
	void delete(int id);
}
