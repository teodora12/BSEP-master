package com.ftn.bsep.service;

import com.ftn.bsep.exception.UserNotAuthorizedException;
import io.jsonwebtoken.*;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Value;

@UtilityClass
public class UtilityService {

    public static final String SECRET = "somesecret";

    private static final String PREFIX = "Bearer ";


    public String getEmailFromToken(String wholeToken) {
        if (wholeToken != null && wholeToken.startsWith(PREFIX)) {
            String token = wholeToken.substring(PREFIX.length(), wholeToken.length());

            try {
                Claims body = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token)
                        .getBody();

                return body.getSubject();

            } catch (JwtException | ClassCastException e) {
                throw new UserNotAuthorizedException();
            }
        }
        throw new UserNotAuthorizedException();

    }


}
