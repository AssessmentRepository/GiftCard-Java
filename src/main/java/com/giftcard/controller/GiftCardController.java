package com.giftcard.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giftcard.dtos.GiftCardOrderDetailsDTO;
import com.giftcard.services.GiftCardOrderService;

/**
 * 
 * @author krishnarjun.pampana
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class GiftCardController {

	@Autowired(required=true)
	private GiftCardOrderService giftCardOrderService;

	@PostMapping(value = "/addGiftCardOrder")
	public ResponseEntity<Boolean> addGiftOrder(@RequestBody @Valid GiftCardOrderDetailsDTO giftCardOrderDetails) {

		Boolean value = giftCardOrderService.saveGiftCardOrderDetail(giftCardOrderDetails);
		if (value) {
			return new ResponseEntity<Boolean>(value, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(value, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping(value = "/viewAllOrders")
	public ResponseEntity<List<GiftCardOrderDetailsDTO>> viewAllOrders() {
		return new ResponseEntity<List<GiftCardOrderDetailsDTO>>(giftCardOrderService.getAllOrderDetails(),
				HttpStatus.OK);
	}
}