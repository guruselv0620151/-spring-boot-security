package com.suyo.springauth.service;

import com.suyo.springauth.models.AuthResponse;
import com.suyo.springauth.models.LoginRequest;
import com.suyo.springauth.models.RegisterRequest;
import com.suyo.springauth.repository.UserRepository;
import com.suyo.springauth.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        User build = User
            .builder()
            .firstName(request.getFirstname())
            .lastName(request.getLastname())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .build();
        userRepository.save(build);
        return AuthResponse.builder().token(jwtService.generateToken(build)).build();
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        return AuthResponse.builder().token(jwtService.generateToken(user)).build();
    }
}
