package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		app.getNavigationHelper().openMainPage();
		
		//save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts(); 
	    
	    	
	    //actions
	    
		app.getNavigationHelper().initContact();
		app.getNavigationHelper().deleteContact();
		app.getContactHelper().returnToMainPage();
		
		//save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    oldList.remove(0);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	  
	}

}
