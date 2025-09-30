package com.example.casagariitaapi.services;


import com.example.casagariitaapi.Security.JwtUtil;
import com.example.casagariitaapi.Security.LoginResponse;
import com.example.casagariitaapi.models.Usuario;
import com.example.casagariitaapi.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    //    REGISTER
    public Usuario register(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setFechaAlta(java.time.LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    //    LOGIN
    public LoginResponse login(String username, String password) {
        Usuario user = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new LoginResponse(token, user);
    }


}
