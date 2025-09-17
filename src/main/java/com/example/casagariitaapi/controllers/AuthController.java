package com.example.casagariitaapi.controllers;


import com.example.casagariitaapi.Security.LoginResponse;
import com.example.casagariitaapi.models.Usuario;
import com.example.casagariitaapi.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(authService.register(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody Usuario usuario) {
        LoginResponse response = authService.login(usuario.getUsername(), usuario.getPassword());
        return ResponseEntity.ok(response);
    }

}
