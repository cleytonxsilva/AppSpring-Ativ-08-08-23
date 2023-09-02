package main.main;

import main.main.DTO.InformacaoDTO;
import main.main.InMemoryRepository.InMemoryValoresRepository;
import main.main.Service.ValorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class CalculosTest {


    @Test
    @DisplayName("Caso de Uso Criação de Valor")
    public void createValorTest(){

        ValorService valorService = new ValorService();
        Double valor = valorService.create(1.0);

        Assertions.assertEquals(1.0, valor);

    }

    @Test
    @DisplayName("Caso de Uso Listagem de Valores")
    public void listarValoresTest(){

        ValorService valorService = new ValorService();
        valorService.create(1.0);
        List<Double> valores = valorService.listar();

        Assertions.assertEquals(1.0, valores.get(0));
    }

    @Test
    @DisplayName("Caso de Uso Tamanho da Lista")
    public void tamanhoListaTest(){

        ValorService valorService = new ValorService();
        valorService.create(1.0);
        int tamanhoLista = valorService.tamanhoLista();

        Assertions.assertEquals(1, tamanhoLista);
    }

    @Test
    @DisplayName("Caso de Uso Somar Valores")
    public void somarValoresTest(){

        ValorService valorService = new ValorService();
        valorService.create(1.0);
        valorService.create(2.0);
        valorService.create(3.0);
        valorService.create(4.0);
        valorService.create(5.0);

        Double soma = valorService.somar();

        Assertions.assertEquals(15.0, soma);
    }

    @Test
    @DisplayName("Caso de Uso Valor Minimo")
    public void valorMinimoTest(){

        ValorService valorService = new ValorService();
        valorService.create(1.0);
        valorService.create(2.0);

        Double valorMinimo = valorService.valorMinimo();

        Assertions.assertEquals(1.0, valorMinimo);
    }

    @Test
    @DisplayName("Caso de Uso Valor Máximo")
    public void valorMaximoTest(){

        ValorService valorService = new ValorService();
        valorService.create(1.0);
        valorService.create(2.0);

        Double valorMaximo = valorService.valorMaximo();

        Assertions.assertEquals(2.0, valorMaximo);
    }

    @Test
    @DisplayName("Caso de Uso Media dos Valores")
    public void MediaValoresTest(){

        ValorService valorService = new ValorService();
        valorService.create(1.0);
        valorService.create(2.0);
        valorService.create(3.0);

        Double media = valorService.calcularMedia();

        Assertions.assertEquals(2.0, media);
    }

    @Test
    @DisplayName("Caso de Uso Mediana com Lista de Tamanho Impar")
    public void MedianaTamanhoImparTest(){

        ValorService valorService = new ValorService();
        valorService.create(1.0);
        valorService.create(2.0);
        valorService.create(3.0);

        Double mediana = valorService.calcularMediana();

        Assertions.assertEquals(2.0, mediana);
    }

    @Test
    @DisplayName("Caso de Uso Mediana com Lista de Tamanho Par")
    public void MedianaTamanhoParTest(){

        ValorService valorService = new ValorService();
        valorService.create(1.0);
        valorService.create(2.0);
        valorService.create(3.0);
        valorService.create(4.0);

        Double mediana = valorService.calcularMediana();

        Assertions.assertEquals(2.5, mediana);
    }

    @Test
    @DisplayName("Caso de Uso Desvio Padrao")
    public void DesvioPadraoTest(){

        ValorService valorService = new ValorService();
        valorService.create(1.0);
        valorService.create(2.0);
        valorService.create(3.0);
        valorService.create(4.0);
        valorService.create(5.0);

        Double desvioPadrao = valorService.calcularDesvioPadrao();

        Assertions.assertEquals("1,5811", String.format("%.4f", desvioPadrao));
    }

    @Test
    @DisplayName("Caso de Uso Informações")
    public void InformacoesTest(){

        ValorService valorService = new ValorService();
        valorService.create(1.0);
        valorService.create(2.0);
        valorService.create(3.0);
        valorService.create(4.0);
        valorService.create(5.0);

        InformacaoDTO informacaoDTO = valorService.informacao();

        InformacaoDTO informacaoTeste = new InformacaoDTO();

        informacaoTeste.setSoma(valorService.somar());
        informacaoTeste.setMediana(valorService.calcularMediana());
        informacaoTeste.setMedia(valorService.calcularMedia());
        informacaoTeste.setDesvioPadrao(valorService.calcularDesvioPadrao());
        informacaoTeste.setValorMinimo(valorService.valorMinimo());
        informacaoTeste.setValorMaximo(valorService.valorMaximo());
        informacaoTeste.setQtdValores(valorService.tamanhoLista());

//        Assertions.assertEquals(informacaoTeste.toString(), informacaoDTO.toString());
//        Assertions.assertTrue(informacaoTeste.equals(informacaoDTO));
        Assertions.assertSame(informacaoTeste, informacaoDTO);

    }
}
