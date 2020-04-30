package com.giftcard.daos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.giftcard.entitys.GiftCardOrderDetails;

@Repository
public interface GiftCardOrderDetailsDAO extends MongoRepository<GiftCardOrderDetails, String>{
	
}
