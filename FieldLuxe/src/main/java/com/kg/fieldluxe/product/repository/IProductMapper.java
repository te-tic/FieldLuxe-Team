package com.kg.fieldluxe.product.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kg.fieldluxe.product.model.DealData;
import com.kg.fieldluxe.product.model.DetailData;
import com.kg.fieldluxe.product.model.ListData;

public interface IProductMapper {
	
	// 전체 목록, 검수목록
	List<ListData> selectAll(@Param("check") boolean check, @Param("condition") String condition);
	
	// 상품 상세
	ListData selectOneList(int id);
	DealData selectOneDeal(int id);
	DetailData selectOneDetail(int id);
	
	// 검수 등록
	void insert(ListData listData);
	void insert(DealData dealData);
	void insert(DetailData detailData);
	
	// 상품 수정
	void update(ListData listData);
	void update(DealData dealData);
	void update(DetailData detailData);
	
	// 검수 완료 전 삭제
	void deleteList(int id);
	void deleteDeal(int id);
	void deleteDetail(int id);
}
