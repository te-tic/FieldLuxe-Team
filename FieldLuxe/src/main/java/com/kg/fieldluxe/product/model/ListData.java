package com.kg.fieldluxe.product.model;

import java.time.LocalDateTime;

/*
	product_id NUMBER PRIMARY KEY, -- 상품 아이디(pk)
	product_category NUMBER NOT NULL, -- 상품 카테고리
	product_name VARCHAR2(100) NOT NULL, -- 상품 이름
	product_brand VARCHAR2(50) NOT NULL, -- 상품 브랜드명
	product_reg_date TIMESTAMP DEFAULT SYSDATE NOT NULL, -- 작성 등록일
	product_post_date TIMESTAMP, -- 검수 완료 후 판매 시작 등록일
	seller_email VARCHAR2(50) NOT NULL, -- 이메일아이디(fk)
	imme_price NUMBER DEFAULT 0, -- 즉시거래가
	auction_end_date TIMESTAMP, -- 경매종료일
	product_post_status CHAR(1) DEFAULT 0, -- 검수 통과 여부 (1 -> 통과)
	product_thumbnail LONG -- 상품 대표 이미지(썸네일)
*/

public class ListData {
	
	private int productId;
	private int productCategory;
	private String productName;
	private String productBrand;
	private LocalDateTime productRegDate;
	private LocalDateTime productPostDate;
	private String sellerEmail;
	private int immePrice;
	private LocalDateTime auctionEndDate;
	private char productPostStatus;
	private String productThumbnail;
	private int deliveryStatus;
	
	private String table = "list";
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public LocalDateTime getProductRegDate() {
		return productRegDate;
	}
	public void setProductRegDate(LocalDateTime productRegDate) {
		this.productRegDate = productRegDate;
	}
	public LocalDateTime getProductPostDate() {
		return productPostDate;
	}
	public void setProductPostDate(LocalDateTime productPostDate) {
		this.productPostDate = productPostDate;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public int getImmePrice() {
		return immePrice;
	}
	public void setImmePrice(int immePrice) {
		this.immePrice = immePrice;
	}
	public LocalDateTime getAuctionEndDate() {
		return auctionEndDate;
	}
	public void setAuctionEndDate(LocalDateTime auctionEndDate) {
		this.auctionEndDate = auctionEndDate;
	}
	public char getProductPostStatus() {
		return productPostStatus;
	}
	public void setProductPostStatus(char productPostStatus) {
		this.productPostStatus = productPostStatus;
	}
	public String getTable() {
		return table;
	}
	public int getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(int deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getProductThumbnail() {
		return productThumbnail;
	}
	public void setProductThumbnail(String productThumbnail) {
		this.productThumbnail = productThumbnail;
	}
}