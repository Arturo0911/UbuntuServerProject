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
	}

}
