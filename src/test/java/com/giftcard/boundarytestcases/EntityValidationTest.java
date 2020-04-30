package com.giftcard.boundarytestcases;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.giftcard.dtos.GiftCardOrderDetailsDTO;
import com.giftcard.dtos.ShippingAddressDTO;
import com.giftcard.utilityclasses.MasterData;
@RunWith(JUnitPlatform.class)
public class EntityValidationTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testGiftOrdersSuccess() {
    	GiftCardOrderDetailsDTO details = MasterData.getDetails();
        Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
        assertTrue(violations.isEmpty());
    }
    @Test
    public void testBuyerNameLength() {
    	GiftCardOrderDetailsDTO details = MasterData.getDetails();
    	details.setBuyerFirstName("as");
        Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void testBuyerNameNull() {
    	GiftCardOrderDetailsDTO details = MasterData.getDetails();
    	details.setBuyerFirstName(null);
        Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
        assertFalse(violations.isEmpty());
    }
    
    
    @Test
    public void testBuyerLastNull() {
    	GiftCardOrderDetailsDTO details = MasterData.getDetails();
    	details.setBuyerLastName(null);
        Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
        assertFalse(violations.isEmpty());
    }
    
    @Test
    public void testPhoneNumberLegthExceed() {
    	GiftCardOrderDetailsDTO details = MasterData.getDetails();
    	details.setPhoneNumber("901256899789");
        Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
        assertFalse(violations.isEmpty());
    }
    
    @Test
    public void testPhoneNumberLegthCorrect() {
    	GiftCardOrderDetailsDTO details = MasterData.getDetails();
    	details.setPhoneNumber("9999999999");
        Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
        assertTrue(violations.isEmpty());
    }
    @Test
    public void testPhoneNumberNull() {
    	GiftCardOrderDetailsDTO details = MasterData.getDetails();
    	details.setPhoneNumber(null);
        Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
        assertFalse(violations.isEmpty());
    }
    
    @Test
    public void testGiftAmountNegative() {
    	GiftCardOrderDetailsDTO details = MasterData.getDetails();
    	details.setGiftAmount(-100L);
        Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
        assertFalse(violations.isEmpty());
    }
    
    @Test
    public void testGiftAmountExceed() {
    	GiftCardOrderDetailsDTO details = MasterData.getDetails();
    	details.setGiftAmount(500L);
        Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
        assertTrue(violations.isEmpty());
    }
    @Test
    public void testEmail() {
    	GiftCardOrderDetailsDTO details = MasterData.getDetails();
    	details.setEmail("krishna");
        Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void testEmailvalidation1() {
    	GiftCardOrderDetailsDTO details = MasterData.getDetails();
    	details.setEmail("krishna.com.com");
        Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void testEmailvalidation2() {
    	GiftCardOrderDetailsDTO details = MasterData.getDetails();
    	details.setEmail("krishna@gmail.com");
        Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
        assertTrue(violations.isEmpty());
    }
    @Test
    public void testGiftAmount() {
    	GiftCardOrderDetailsDTO details = MasterData.getDetails();
    	details.setGiftAmount(100L);
        Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
        assertTrue(violations.isEmpty());
    }
    
    @Test
    public void testShippingPincode() {
    	GiftCardOrderDetailsDTO details = MasterData.getDetails();
    	details.getShippingId().setPincode("588888");
        Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
        assertTrue(violations.isEmpty());
    }
}