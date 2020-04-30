package com.giftcard.exceptiontestcases;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.giftcard.controller.GiftCardController;
import com.giftcard.services.GiftCardOrderService;
import com.giftcard.utilityclasses.MasterData;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ExceptionTestClass {
	
	
	@InjectMocks
    GiftCardController giftCardController;
     
    @Mock
    GiftCardOrderService giftCardOrderService;
  
    
   
         
        @Test(expected = NullPointerException.class)
        public void saveGiftCardDetails() 
        {
            MockHttpServletRequest request = new MockHttpServletRequest();
            RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
             
           when(giftCardOrderService.saveGiftCardOrderDetail(MasterData.getDetails())).thenThrow(NullPointerException.class);
              giftCardController.addGiftOrder(MasterData.getDetails());
        }
       
        
   
         
       
}
