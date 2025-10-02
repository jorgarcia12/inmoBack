package com.example.casagariitaapi.Security;


import com.example.casagariitaapi.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private Usuario user;
}
