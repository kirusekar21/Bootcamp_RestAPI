package pojo;

public class User {
	   private static  User instance;
	   private String user_first_name;
	   private String user_last_name;
	   private String user_contact_number;
	   private String user_email_id;
	   private User_address userAddress;
	   private String user_id;
	   
	   
	   public static User getInstance() {
	        if (instance == null) {
	            instance = new User();
	        }
	        return instance;
	    }
	   public String getuser_id() {
		     return user_id;
		}  
	   public void setuser_id(String user_id) {
	         this.user_id=user_id;
	}  
	
	   public String getUser_first_name() {
		return user_first_name;
	}
	   public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	   public String getUser_last_name() {
		return user_last_name;
	}
	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	public String getUser_contact_number() {
		return user_contact_number;
	}
	public void setUser_contact_number(String user_contact_number) {
		this.user_contact_number = user_contact_number;
	}
	public String getUser_email_id() {
		return user_email_id;
	}
	public void setUser_email_id(String user_email_id) {
		this.user_email_id = user_email_id;
	}
	public User_address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(User_address userAddress) {
		this.userAddress = userAddress;
	}
	
 }
//{
//    "userAddress": {
//        "addressId": 2707,
//        "plotNumber": "A-2021",
//        "street": "lincon",
//        "state": "Wa",
//        "country": "USA",
//        "zipCode": 98007
//    },
//    "user_id": 2740,
//    "user_first_name": "KhushbooS",
//    "user_last_name": "SharmaM",
//    "user_contact_number": 2312398701,
//    "user_email_id": "khushboo1N_Team09.Sharma@gmail.com",
//    "creation_time": "2024-09-22T20:12:31.075+00:00",
//    "last_mod_time": "2024-09-22T20:12:31.075+00:00"
//},