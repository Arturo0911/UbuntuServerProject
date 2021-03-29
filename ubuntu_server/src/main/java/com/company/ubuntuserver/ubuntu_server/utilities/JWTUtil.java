package com.company.ubuntuserver.ubuntu_server.utilities;


import io.jsonwebtoken.*;
import lombok.extern.java.Log;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log
@Component
public class JWTUtil {

    private static final String KEY = "Never";

    public String generateToken(String email){
        return Jwts.builder().setSubject(email).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*60*60*10))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }


    public boolean validateToken(String jwtToken, UserDetails userDetails ){

        String userEmail = extractUsername(jwtToken);
        return userEmail.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken);
        //return userDetails.getUsername().equals(extractUsername(jwtToken)) && !isTokenExpired(jwtToken);
    }


    public String extractUsername(String token){
        try{
            //log.info(token);
            return getClaims(token).getSubject();
        }catch (Exception e ){
            e.printStackTrace();
            return null;
        }
    }

    public boolean isTokenExpired(String token){
        return getClaims(token).getExpiration().before(new Date());
    }


    /**
     *
     * @param token token generated with the method.
     * @return get token body
     */
    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }


    /*public String getJWTFromHttpRequest(HttpServletRequest request){
        String jwt = null;
        if(request.getHeader("jwt") != null){
            // THen the jwt it's on the header of the request
            jwt = request.getHeader("jwt");
        } else if (request.getCookies() != null) {
            // token it's on the cookies
            Cookie [] cookies = request.getCookies();
            for(Cookie cookie: cookies){
                if (cookie.getName().equals("jwt")) {
                    jwt = cookie.getValue();
                }
            }
        }
        return jwt;
    }

    public String generateJWT(String email, String userName, Date date) throws UnsupportedEncodingException {
        String jwt = Jwts.builder()
                .setSubject(email)
                .setExpiration(date)
                .claim("name", userName)
                .signWith(
                        SignatureAlgorithm.HS256,
                        "myPersonalSecretKey12345".getBytes("UTF-8")
                )
                .compact();

        return jwt;
    }

    public Map<String, Object> jwt2Map(String jwt) throws java.io.UnsupportedEncodingException, ExpiredJwtException {

        Jws<Claims> claim = Jwts.parser()
                .setSigningKey("myPersonalSecretKey12345".getBytes("UTF-8"))
                .parseClaimsJws(jwt);

        String name = claim.getBody().get("name", String.class);

        Date expDate = claim.getBody().getExpiration();
        String email = claim.getBody().getSubject();

        Map<String, Object> userData = new HashMap<>();
        userData.put("email", email);
        userData.put("name", name);
        userData.put("exp_date", expDate);

        Date now = new Date();
        if (now.after(expDate)) {
            throw new ExpiredJwtException(null, null, "Session expired!");
        }

        return userData;
    }

    public String getJWTFromHttpRequest(HttpServletRequest request){
        String jwt = null;
        if(request.getHeader("jwt") != null){
            // THen the jwt it's on the header of the request
            jwt = request.getHeader("jwt");
        } else if (request.getCookies() != null) {
            // token it's on the cookies
            Cookie [] cookies = request.getCookies();
            for(Cookie cookie: cookies){
                if (cookie.getName().equals("jwt")) {
                    jwt = cookie.getValue();
                }
            }
        }
        return jwt;
    }*/
}
