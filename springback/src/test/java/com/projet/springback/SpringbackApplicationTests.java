package com.projet.springback;

import com.projet.springback.service.GroupeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbackApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private GroupeServiceImpl groupeService;
    @Test
    void testRand(){
        System.out.println(( ((groupeService.gener(4)!=null)?groupeService.gener(4).size():4) ==4)?"passer":"echec");
    }
}
