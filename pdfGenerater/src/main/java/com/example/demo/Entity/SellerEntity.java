package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class SellerEntity {

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getSellerGstIn() {
		return sellerGstIn;
	}

	public void setSellerGstIn(String sellerGstIn) {
		this.sellerGstIn = sellerGstIn;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getBuyerGstIn() {
		return buyerGstIn;
	}

	public void setBuyerGstIn(String buyerGstIn) {
		this.buyerGstIn = buyerGstIn;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public ItemsEntity getItemsEntity() {
		return itemsEntity;
	}

	public void setItemsEntity(ItemsEntity itemsEntity) {
		this.itemsEntity = itemsEntity;
	}

	@Id
    @Column(name = "Id")
    private int id;

    @Column(name = "Seller")
    private String seller;

    @Column(name = "sellerGstIn")
    private String sellerGstIn;

    @Column(name = "sellerAddress")
    private String sellerAddress;

    @Column(name = "buyer")
    private String buyer;

    @Column(name = "buyerGstIn")
    private String buyerGstIn;

    @Column(name = "buyerAddress")
    private String buyerAddress;

    @OneToOne
    @JoinColumn(name = "item_id")
    private ItemsEntity itemsEntity;
}
