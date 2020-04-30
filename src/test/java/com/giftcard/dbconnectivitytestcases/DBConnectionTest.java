package com.giftcard.dbconnectivitytestcases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@RunWith(JUnitPlatform.class)
public class DBConnectionTest {
	
	@Autowired MongoTemplate mongoTemplate;
	
    @DisplayName("given object to save"
        + " when save object using MongoDB template"
        + " then object is saved")
    @Test
    public void test() {
		
		  // given
    	DBObject objectToSave = BasicDBObjectBuilder.start() .add("key",
		  "value") .get();
		  
		  // when 
    	mongoTemplate.save(objectToSave, "collection");
		  
		  // then 
    	assertThat(mongoTemplate.findAll(DBObject.class,
		  "collection")).extracting("key") .containsOnly("value");
		 
    	//assertNotNull(mongoTemplate);
    	
    }
    
   
}
