package com.example.demo.controller;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.demo.error.ApiError;
import com.example.demo.error.ContrasenaNotFoundExeption;
import com.example.demo.error.ExisteUsuarioNotFoundExeption;
import com.example.demo.error.TokenNoValidoExeption;
import com.example.demo.model.LoginCredentials;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.security.JWTUtil;

@RestController
@CrossOrigin("http://localhost:4200")
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
    }

    @PostMapping("/auth/login")
    public Map<String, Object> loginHandler(@RequestBody LoginCredentials body){
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());

            authManager.authenticate(authInputToken);
 
            String token = jwtUtil.generateToken(body.getEmail());

            return Collections.singletonMap("access_token", token);
        }catch (AuthenticationException authExc){
        		throw new ContrasenaNotFoundExeption();
        }
    }
    
    @GetMapping("/validarToken")
    public ResponseEntity<String> validarToken() {
    	try {
    		return ResponseEntity.ok("funciona");
    	}catch (Exception e) {
			throw new TokenNoValidoExeption();
		}
    	
    }
    
    @ExceptionHandler(ContrasenaNotFoundExeption.class)
    public ResponseEntity<ApiError> contrasenaError(ContrasenaNotFoundExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.NOT_FOUND);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	} 
    
    @ExceptionHandler(TokenNoValidoExeption.class)
    public ResponseEntity<ApiError> tokenNoValido(TokenNoValidoExeption ex) throws Exception {
    	ApiError e = new ApiError();
    	e.setEstado(HttpStatus.BAD_REQUEST);
    	e.setMensaje(ex.getMessage());
    	e.setFecha(LocalDateTime.now());
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
	} 
    


}
