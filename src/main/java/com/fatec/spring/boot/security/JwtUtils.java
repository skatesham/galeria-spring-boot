package com.fatec.spring.boot.security;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fatec.spring.boot.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.util.Date;

public class JwtUtils {

    private static final String KEY = "12345678";

    public static String generateToken(Usuario usuario) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();  // Write Json from an object
        usuario.setSenha(null);     // remove password from object
        String usuarioJson = mapper.writeValueAsString(usuario); // create json from user
        Date agora = new Date(); // set time from now
        long hora = 1000L * 60L * 60L; //configure one hour in milissegundos
        return Jwts.builder().claim("userDetails", usuarioJson)
                .setIssuer("com.fatec.spring.boot")
                .setSubject(usuario.getNome())
                .setExpiration(new Date(agora.getTime() + hora))
                .signWith(SignatureAlgorithm.HS512, KEY)
                .compact();
    }

    public static Usuario parseToken(String token) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String credentialsJson = Jwts.parser()
                .setSigningKey(KEY)
                .parseClaimsJws(token)
                .getBody()
                .get("UserDetails", String.class);
        return mapper.readValue(credentialsJson, Usuario.class);
    }

}
