package com.company.ubuntuserver.ubuntu_server;

import com.company.ubuntuserver.ubuntu_server.daos.IUser;
import com.company.ubuntuserver.ubuntu_server.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootTest
class UbuntuServerApplicationTests {

	@Autowired
	private IUser iUser;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;


	@Test
	public void testUser() {
		User user = new User();
		user.setUserName("James Alan");
		user.setUserLastName("Hetfield");
		user.setEmail("james@metallica.com");
		user.setPassword(passwordEncoder.encode("Metallica rules"));
		user.setUserBirth(new Date("09/11/1969"));
		user.setPhoneNumber("0990893426");
		user.setGender("Male");
		user.setStatus("Active");
		User returnUser = iUser.save(user);

		assert (returnUser.getPassword().equalsIgnoreCase(user.getPassword()));
	}

}
