package com.giftcard.utilityclasses;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giftcard.dtos.GiftCardOrderDetailsDTO;
import com.giftcard.dtos.ShippingAddressDTO;

/**
 * 
 * @author krishnarjun.pampana
 *
 */
public class MasterData {

	public static GiftCardOrderDetailsDTO getDetails() {

		GiftCardOrderDetailsDTO orderDetails = new GiftCardOrderDetailsDTO();
		orderDetails.setBuyerFirstName("buyerFirstName");
		orderDetails.setBuyerLastName("buyerLastName");
		orderDetails.setEmail("email@gmail.com");
		double amount = 100.50;
		orderDetails.setGiftAmount((long) amount);
		orderDetails.setPhoneNumber("9010893970");
		orderDetails.setRecipienLastName("recepientName");
		orderDetails.setRecipientFirstName("recipientFirstName");

		ShippingAddressDTO shippingDetails = new ShippingAddressDTO();
		shippingDetails.setCityName("cityName");
		shippingDetails.setCountry("country");
		shippingDetails.setPincode("pincode");
		shippingDetails.setState("state");
		shippingDetails.setStreetName("streetName");
		orderDetails.setShippingId(shippingDetails);
		return orderDetails;
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
