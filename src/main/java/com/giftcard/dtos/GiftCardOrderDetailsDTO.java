package com.giftcard.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * 
 * @author krishnarjun.pampana
 *
 */

public class GiftCardOrderDetailsDTO {


    private String orderId;

	@Length(min = 5, max = 30)
	@NotNull
	private String buyerFirstName;

	@Length(min = 3, max = 25)
	@NotNull
	private String buyerLastName;

	@Length(min = 3, max = 25)
	private String recipientFirstName;

	@Length(min = 3, max = 25)
	private String recipienLastName;

	@NotNull
	@Min(0L)
	private Long giftAmount;
	
	@NotNull
	@Length(min = 10, max = 10)
	private String phoneNumber;
	
	@SuppressWarnings("deprecation")
	@NotNull
	@Email
	private String email;


	private ShippingAddressDTO shippingId;

	

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

	public ShippingAddressDTO getShippingId() {
		return shippingId;
	}

	public void setShippingId(ShippingAddressDTO shippingId) {
		this.shippingId = shippingId;
	}

	

}
