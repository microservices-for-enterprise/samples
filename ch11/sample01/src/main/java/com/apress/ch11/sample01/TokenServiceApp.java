package com.apress.ch11.sample01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer
@RestController
@EnableResourceServer
public class TokenServiceApp {

	@RequestMapping(value = "/user", produces = "application/json")
	public Map<String, Object> user(OAuth2Authentication user) {

		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("active", "true");
		userInfo.put("username", user.getUserAuthentication().getName());
		userInfo.put("sub", user.getUserAuthentication().getName());
		userInfo.put("client_id", user.getOAuth2Request().getClientId());

		Set<String> scopes = user.getOAuth2Request().getScope();
		StringBuilder str = new StringBuilder();
		for (Iterator<String> iterator = scopes.iterator(); iterator.hasNext();) {
			if (iterator.hasNext()) {
				str.append(iterator.next() + ",");
			} else {
				str.append(iterator.next());
			}
		}
		userInfo.put("scope", str.toString());

		return userInfo;
	}

	public static void main(String[] args) {
		SpringApplication.run(TokenServiceApp.class, args);
	}
}
