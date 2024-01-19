package com.backofli;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    public void testUuid(){
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    @Test
    public void testGenJwt(){
        Map<String ,Object>claims=new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
           String jwt=Jwts.builder().signWith(SignatureAlgorithm.HS256,"ithema").setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                .compact();//签名算法

        //有效期
        System.out.println(jwt);


    }



}
