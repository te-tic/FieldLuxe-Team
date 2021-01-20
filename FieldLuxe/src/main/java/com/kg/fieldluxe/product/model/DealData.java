package com.kg.fieldluxe.product.model;

import java.time.LocalDateTime;

/*
	product_id NUMBER PRIMARY KEY, -- 상품 아이디(pk)
	deal_method NUMBER NOT NULL, -- 거래방식 (1, 2, 3)
	min_auction_price NUMBER DEFAULT 0, -- 최저입찰가
	now_auction_price NUMBER, -- 현재입찰가(경매 진행중일 경우)
	auction_deposit NUMBER DEFAULT 0, -- 입찰보증금
	auction_start_date TIMESTAMP -- 경매시작일
*/

public class DealData {
	
	private int productId;
	private int dealMethod;
	private int minAuctionPrice;
	private int nowAuctionPrice;
	private int auctionDeposit;
	private LocalDateTime auctionStartDate;
	private int auctionStatus;
	
	private String table = "deal";
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getDealMethod() {
		return dealMethod;
	}
	public void setDealMethod(int dealMethod) {
		this.dealMethod = dealMethod;
	}
	public int getMinAuctionPrice() {
		return minAuctionPrice;
	}
	public void setMinAuctionPrice(int minAuctionPrice) {
		this.minAuctionPrice = minAuctionPrice;
	}
	public int getNowAuctionPrice() {
		return nowAuctionPrice;
	}
	public void setNowAuctionPrice(int nowAuctionPrice) {
		this.nowAuctionPrice = nowAuctionPrice;
	}
	public int getAuctionDeposit() {
		return auctionDeposit;
	}
	public void setAuctionDeposit(int auctionDeposit) {
		this.auctionDeposit = auctionDeposit;
	}
	public LocalDateTime getAuctionStartDate() {
		return auctionStartDate;
	}
	public void setAuctionStartDate(LocalDateTime auctionStartDate) {
		this.auctionStartDate = auctionStartDate;
	}
	public String getTable() {
		return table;
	}
	public int getAuctionStatus() {
		return auctionStatus;
	}
	public void setAuctionStatus(int auctionStatus) {
		this.auctionStatus = auctionStatus;
	}
}
