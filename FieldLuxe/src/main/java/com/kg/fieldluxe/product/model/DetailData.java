package com.kg.fieldluxe.product.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

/*
	product_id NUMBER PRIMARY KEY, -- 상품 아이디(pk)
	product_color VARCHAR2(20) NOT NULL, -- 상품 색깔
	product_size VARCHAR2(20) NOT NULL, -- 상품 사이즈
	release_date DATE NOT NULL, -- 상품 출시일
	release_price NUMBER NOT NULL, -- 상품 출시가
	images LONG NOT NULL, -- 판매자 입력 이미지들
	seller_word CLOB, -- 판매자 한마디
	product_reg_date TIMESTAMP DEFAULT SYSDATE NOT NULL, -- 작성 등록일
	reject_reason VARCHAR2(1000) -- 검수 불합격 이유
*/

public class DetailData {

	private int productId;
	private String productColor;
	private String productSize;
	private String productModelNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate releaseDate;
	private int releasePrice;
	private String images;
	private String sellerWord;
	private String rejectReason = "";
	
	private String table = "detail";

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getProductModelNumber() {
		return productModelNumber;
	}
	public void setProductModelNumber(String productModelNumber) {
		this.productModelNumber = productModelNumber;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getReleasePrice() {
		return releasePrice;
	}
	public void setReleasePrice(int releasePrice) {
		this.releasePrice = releasePrice;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getSellerWord() {
		return sellerWord;
	}
	public void setSellerWord(String sellerWord) {
		this.sellerWord = sellerWord;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	public String getTable() {
		return table;
	}
}
