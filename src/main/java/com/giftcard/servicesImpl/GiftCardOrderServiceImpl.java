package com.giftcard.servicesImpl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.giftcard.daos.GiftCardOrderDetailsDAO;
import com.giftcard.dtos.GiftCardOrderDetailsDTO;
import com.giftcard.entitys.GiftCardOrderDetails;
import com.giftcard.exceptionutility.RecordNotFoundException;
import com.giftcard.services.GiftCardOrderService;

/**
 * 
 * @author krishnarjun.pampana
 *
 */

@Service
public class GiftCardOrderServiceImpl implements GiftCardOrderService {

	@Autowired
	private GiftCardOrderDetailsDAO giftCardOrderDetailsDAO;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<GiftCardOrderDetailsDTO> getAllOrderDetails() {
		List<GiftCardOrderDetails> giftOrdersList = giftCardOrderDetailsDAO.findAll();
		if(!CollectionUtils.isEmpty(giftOrdersList)) {
			Type listType = new TypeToken<List<GiftCardOrderDetails>>() {}.getType();
			return modelMapper.map(giftOrdersList, listType);
		}
		throw new RecordNotFoundException("No Reccords Found");
	}

	@Override
	public Boolean saveGiftCardOrderDetail(GiftCardOrderDetailsDTO giftCardOrderDetails) {
		giftCardOrderDetailsDAO.save(modelMapper.map(giftCardOrderDetails, GiftCardOrderDetails.class));
		return Boolean.TRUE;
	}
}
