package io.hahnsoftware.backend.service.impl;


import io.hahnsoftware.backend.dto.AuthRequest;
import io.hahnsoftware.backend.dto.AuthResponse;
import io.hahnsoftware.backend.dto.UserDTO;
import io.hahnsoftware.backend.entity.Role;
import io.hahnsoftware.backend.entity.User;
import io.hahnsoftware.backend.repository.UserRepository;
import io.hahnsoftware.backend.service.AuthenticationService;
import io.hahnsoftware.backend.service.auth.JwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public AuthResponse register(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(Role.USER);
        User savedUser = userRepository.save(user);
        String token = jwtService.generateToken(savedUser.getUsername());
        return new AuthResponse(token);
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found with email: " + request.getEmail()));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        request.getPassword()
                )
        );

        String token = jwtService.generateToken(user.getUsername());

        return new AuthResponse(token);
    }
}
