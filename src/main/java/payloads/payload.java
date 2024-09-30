package payloads;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.User;
import pojo.User_address;
import pojo.User_address_mandatory;

public class payload {
	User user;
	User_address userAddress;
	User_address_mandatory userAddressMan;
	ObjectMapper objectMapper = new ObjectMapper();

	public User postBody() {
		
		user=new User();
		userAddress=new User_address();
		user.setUser_first_name("kikiki");
		user.setUser_last_name("seksek");
		user.setUser_contact_number("9942345678");
		user.setUser_email_id("abgn@gmail.com");
		user.setUserAddress(userAddress);
		userAddress.setPlotNumber("PL-168");
		userAddress.setStreet("Main Street");
		userAddress.setState("AL");
		userAddress.setCountry("USA");
		userAddress.setZipCode(30066);
	    return user;

	}
	public User postOnlyMandatoryField() throws JsonProcessingException {
		user=new User();
		user.setUser_first_name("kikiki");
		user.setUser_last_name("seksek");
		user.setUser_contact_number("9942545678");
		user.setUser_email_id("abfr@gmail.com");
		user.setUserAddress(new User_address());
		return user;
	}
	public User putBody() {
		user=new User();
		userAddress=new User_address();
		user.setUser_first_name("kikiki");
		user.setUser_last_name("seksek");
		user.setUser_contact_number("9932445678");
		user.setUser_email_id("abfg@gmail.com");
		user.setUserAddress(userAddress);
		userAddress.setPlotNumber("PL-168");
		userAddress.setStreet("Main Street");
		userAddress.setState("AL");
		userAddress.setCountry("USA");
		userAddress.setZipCode(30066);
	    return user;
		
		
	}
	public String deleteBody() {
		return "";
		
	}
}
