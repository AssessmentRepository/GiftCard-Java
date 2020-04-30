package com.giftcard.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author krishnarjun.pampana
 *
 */

@Document("giftcarddetails")
/*
 * @Data
 * 
 * @NoArgsConstructor
 * 
 * @AllArgsConstructor
 */
public class GiftCardOrderDetails {

    @Id
	private String orderId;

	private String buyerFirstName;

	private String buyerLastName;

	private String recipientFirstName;

	private String recipienLastName;

	private Long giftAmount;
	
	private String phoneNumber;
	
	private String email;

	private ShippingAddress shippingAddress;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getBuyerFirstName() {
		return buyerFirstName;
	}

	public void setBuyerFirstName(String buyerFirstName) {
		this.buyerFirstName = buyerFirstName;
	}

	public String getBuyerLastName() {
		return buyerLastName;
	}

	public void setBuyerLastName(String buyerLastName) {
		this.buyerLastName = buyerLastName;
	}

	public String getRecipientFirstName() {
		return recipientFirstName;
	}

	public void setRecipientFirstName(String recipientFirstName) {
		this.recipientFirstName = recipientFirstName;
	}

	public String getRecipienLastName() {
		return recipienLastName;
	}

	public void setRecipienLastName(String recipienLastName) {
		this.recipienLastName = recipienLastName;
	}

	public Long getGiftAmount() {
		return giftAmount;
	}

	public void setGiftAmount(Long giftAmount) {
		this.giftAmount = giftAmount;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	

	

	

}
