/*
 es la que genera el Tokken
 */
package com.portfolio.proyecto.Security.jwt;

import com.portfolio.proyecto.Security.Entity.MainUser;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.beans.factory.annotation.Value; //IMPORTANTE: NO ES LA DE LOOMBOK
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Value("${jwt.secret}") //Esto es para traer las variables desde "application.properties"
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;
    
    public String generateToken(Authentication authentication ){
        MainUser mainUser = (MainUser) authentication.getPrincipal();
    
        return Jwts.builder()
                .setSubject(mainUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expiration*1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();               
                //todo esto para generar el Tokken
    }
    public String getUserNameFronToken(String token){
        
        return Jwts.parser()
               .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    
    public boolean validateToken (String token){
    try{
        Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        return true;
    }catch(MalformedJwtException e){
        logger.error("Token mal formado");
    }catch(UnsupportedJwtException e){
        logger.error("Token no válido");
    }catch(ExpiredJwtException e){
        logger.error("Token expirado");
    }catch(SignatureException e){
        logger.error("Firma de token no válida");
    }catch(IllegalArgumentException e){
        logger.error("Token vacio");
    }
    return false;
    }
}
