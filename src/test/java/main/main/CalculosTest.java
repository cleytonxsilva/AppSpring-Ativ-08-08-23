package main.main;

import junit.framework.Assert;
import main.main.Service.ValorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculosTest {

    @Test
    public void qtdNumerosTest(){
        ValorService valorService = new ValorService();

        valorService.informacao().setQtdValores(20);

        Assert.assertEquals(20, 0);
    }


}
