package com.giftcard.functionaltestcases;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.giftcard.controller.GiftCardController;
import com.giftcard.dtos.GiftCardOrderDetailsDTO;
import com.giftcard.services.GiftCardOrderService;
import com.giftcard.utilityclasses.MasterData;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GiftCardControllerTest {
 
	@InjectMocks
    GiftCardController giftCardController;
     
    @Mock
    GiftCardOrderService giftCardOrderService;
  
    
   
         
        @Test
        public void saveGiftCardDetails() 
        {
            MockHttpServletRequest request = new MockHttpServletRequest();
            RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
             
           when(giftCardOrderService.saveGiftCardOrderDetail(MasterData.getDetails())).thenReturn(Boolean.TRUE);
             
            ResponseEntity<Boolean> responseEntity = giftCardController.addGiftOrder(MasterData.getDetails());
             
            assertThat(responseEntity.getBody().equals(Boolean.TRUE));
        }
        
        
        @Test
        public void failedTosaveGiftCardDetails() 
        {
            MockHttpServletRequest request = new MockHttpServletRequest();
            RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
             
            when(giftCardOrderService.saveGiftCardOrderDetail(MasterData.getDetails())).thenReturn(false);
             
            ResponseEntity<Boolean> responseEntity = giftCardController.addGiftOrder(MasterData.getDetails());
             
            assertThat(responseEntity.getStatusCode().value()).isEqualTo(500);
        }
        
   
         
        @Test
        public void testFindAll() 
        {
            // given
           List<GiftCardOrderDetailsDTO> giftCardDetails = Arrays.asList(MasterData.getDetails(), MasterData.getDetails());
           
     
            when(giftCardOrderService.getAllOrderDetails()).thenReturn(giftCardDetails);
     
            // when
            ResponseEntity<List<GiftCardOrderDetailsDTO>> result = giftCardController.viewAllOrders();
     
            // then
            assertThat(result.getBody().size()).isEqualTo(2);
             
        }
        
        
        @Test
        public void testFindAllEmpty() 
        {
            // given
           List<GiftCardOrderDetailsDTO> giftCardDetails = new ArrayList<>();
           
     
            when(giftCardOrderService.getAllOrderDetails()).thenReturn(giftCardDetails);
     
            // when
            ResponseEntity<List<GiftCardOrderDetailsDTO>> result = giftCardController.viewAllOrders();
     
            // then
            assertThat(result.getBody().size()).isEqualTo(0);
             
        }
        
        
        
 
}