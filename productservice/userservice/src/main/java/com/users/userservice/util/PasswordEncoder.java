package com.users.userservice.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoder {

	public static String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public static Boolean isMatchPassword(String plainPassword, String hashPassword) {
		return BCrypt.checkpw(plainPassword, hashPassword);
	}
}
