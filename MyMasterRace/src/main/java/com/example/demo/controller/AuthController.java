package com.example.demo.controller;


import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.ExisteUsuarioNotFoundExeption;
import com.example.demo.model.LoginCredentials;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.security.JWTUtil;

@RestController
public class AuthController {

    @Autowired private UserRepo userRepo;
    @Autowired private JWTUtil jwtUtil;
    @Autowired private AuthenticationManager authManager;
    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping("/auth/register")
    public Map<String, Object> registerHandler(@RequestBody User user){
    	if (userRepo.findByEmail(user.getEmail()).orElse(null)==null) {
            String encodedPass = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPass);
            user = userRepo.save(user);
            String token = jwtUtil.generateToken(user.getEmail());
            return Collections.singletonMap("access_token", token);
		}else {
			throw new ExisteUsuarioNotFoundExeption();
		}
        /*String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        user = userRepo.save(user);
        String token = jwtUtil.generateToken(user.getEmail());
        return Collections.singletonMap("access_token", token);*/
    }

    @PostMapping("/auth/login")
    public ResponseEntity<Map<String, Object>> loginHandler(@RequestBody LoginCredentials body){
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());

            authManager.authenticate(authInputToken);
 
            String token = jwtUtil.generateToken(body.getEmail());

            return ResponseEntity.ok(Collections.singletonMap("access_token", token));
        }catch (AuthenticationException authExc){
        	if(this.userRepo.getEmail(body.getEmail()) != null){
        		throw new RuntimeException("La contraseña no es correcta.");
        	}else {
        		throw new RuntimeException("Email y contraseña incorrectos.");
        	}
        }
    }

}
