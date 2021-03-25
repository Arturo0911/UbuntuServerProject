package com.company.ubuntuserver.ubuntu_server.utilities;


import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtils {

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

    /**
     * @implNote this method extract jwt from the header or the cookie in the httpRequest
     * @param request body request with the jwt inside
     * @return return the string extracted from the header of the request
     */

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
    }
}
