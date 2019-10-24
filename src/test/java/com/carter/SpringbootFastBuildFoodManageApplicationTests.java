package com.carter;

import com.carter.utils.JWTUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootFastBuildFoodManageApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test(){
        boolean verify = JWTUtil.verify("");
        System.out.println(verify);
    }

}
