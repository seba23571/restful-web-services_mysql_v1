package com.in28minutes.rest.basic.auth;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for(int i=1;i<=10;i++) {
				String encoderstr =	encoder.encode("123");
					System.out.println(encoderstr);
					
	//$2a$10$RP3bjqD6tt7KxwNitlN/L.tkU11No7JHriFJed.SdgSW7CHO3iEO6				

		}

	}	}