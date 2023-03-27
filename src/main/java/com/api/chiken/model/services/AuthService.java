package com.api.chiken.model.services;

import com.api.chiken.model.entities.Role;
import com.api.chiken.model.entities.User;
import com.api.chiken.model.repositories.UserRepository;
import com.api.chiken.model.requests.LoginRequest;
import com.api.chiken.model.requests.RegisterRequest;
import com.api.chiken.model.responses.AuthResponse;
import com.api.chiken.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService{
        private final UserRepository repository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final UserRepository userRepository;

        private final AuthenticationManager authenticationManager;
        public AuthResponse register(RegisterRequest request) {
            var user = User.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();
            repository.save(user);
            var jwtToken = jwtService.generateToken(user);
            return AuthResponse
                    .builder()
                    .token(jwtToken)
                    .build();
        }

        public AuthResponse authenticate(LoginRequest request) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
            var user = repository.findByEmailOrUsername(request.getUsername()).orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            return AuthResponse
                    .builder()
                    .token(jwtToken)
                    .build();
        }

        public User user(){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = null;
            if (authentication != null && authentication.getPrincipal() instanceof User) {
                user = (User) authentication.getPrincipal();
            }
            return userRepository.findById(user.getId()).orElseThrow();
        }
}
