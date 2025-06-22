package io.hahnsoftware.backend.service;


import io.hahnsoftware.backend.dto.AuthRequest;
import io.hahnsoftware.backend.dto.AuthResponse;
import io.hahnsoftware.backend.dto.UserDTO;

public interface AuthenticationService{
    AuthResponse register(UserDTO request);
    AuthResponse authenticate(AuthRequest request);
}