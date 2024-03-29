package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().goToMainPage();
		
		//save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts(); 
	    	
	    //actions
	    
		app.getNavigationHelper().initContact();
		ContactData contact = new ContactData();
		contact.name = "new name 1";
		app.getContactHelper().fillContactData(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToMainPage();
		
		//save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    oldList.remove(0);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	  
	}
}
