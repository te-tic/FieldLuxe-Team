package com.kg.fieldluxe.product.model;

public class ProductVO {
	
	private ListData listData;
	private DealData dealData;
	private DetailData detailData;
	
	public ProductVO() {}

	public ProductVO(ListData listData, DealData dealData, DetailData detailData) {
		super();
		this.listData = listData;
		this.dealData = dealData;
		this.detailData = detailData;
	}

	public ListData getListData() {
		return listData;
	}
	public void setListData(ListData listData) {
		this.listData = listData;
	}
	public DealData getDealData() {
		return dealData;
	}
	public void setDealData(DealData dealData) {
		this.dealData = dealData;
	}
	public DetailData getDetailData() {
		return detailData;
	}
	public void setDetailData(DetailData detailData) {
		this.detailData = detailData;
	}
}
