package main.main.Service;

import main.main.DTO.InformacaoDTO;
import main.main.DTO.ValorDTO;
import main.main.Repository.ValorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ValorService {

    @Autowired
    private ValorRepository valorRepository;


    public List<ValorDTO> findAll() {
        return valorRepository.findAll();
    }

    public void create(ValorDTO valor) {
        valorRepository.save(valor);
    }

    public InformacaoDTO informacao() {
        InformacaoDTO informacaoDTO = new InformacaoDTO();
        informacaoDTO.setQtdValores(numerosCalculados());
        informacaoDTO.setSoma(somaNumeros());
        informacaoDTO.setMedia(calculaMedia());
        informacaoDTO.setMediana(calculaMediana());
        informacaoDTO.setDesvioPadrao(calculaDesvioPadrao());
        informacaoDTO.setValorMaximo(valorMaximo());
        informacaoDTO.setValorMinimo(valorMinimo());
        return informacaoDTO;

    }

    private int numerosCalculados() {
        List<ValorDTO> listaValores = valorRepository.findAll();
        return listaValores.size();
    }
    private double valorMinimo() {
        List<ValorDTO> listaValores = valorRepository.findAll();

        List<Double> valores = new ArrayList<>();
        for (ValorDTO valor : listaValores) {
            valores.add(valor.getValor());
        }

        double menor = Collections.min(valores);
        return menor;
    }

    private double valorMaximo() {

        List<ValorDTO> listaValores = valorRepository.findAll();

        List<Double> valores = new ArrayList<>();
        for (ValorDTO valor : listaValores) {
            valores.add(valor.getValor());
        }

        double maior = Collections.max(valores);
        return maior;
    }

    private double calculaDesvioPadrao() {
        List<ValorDTO> listaValores = valorRepository.findAll();
        double media = calculaMedia();
        double difQuadrado = 0;
        double desvioPadrao;
        for (int i = 0; i < listaValores.size(); i++){
            double diferenca = listaValores.get(i).getValor() - media;
            difQuadrado += Math.pow(diferenca, 2);
        }
        desvioPadrao = Math.sqrt(difQuadrado / (listaValores.size() - 1));
        return  desvioPadrao;
    }

    private double calculaMediana() {
        List<ValorDTO> listaValores = valorRepository.findAll();

        List<Double> valores = new ArrayList<>();
        for (ValorDTO valor : listaValores) {
            valores.add(valor.getValor());
        }

        Collections.sort(valores);

        int tamanho = valores.size();
        double mediana;

        if (tamanho % 2 == 0) {
            int indice1 = tamanho / 2 - 1;
            int indice2 = tamanho / 2;
            mediana = (valores.get(indice1) + valores.get(indice2)) / 2;
        } else {
            int indice = tamanho / 2;
            mediana = valores.get(indice);
        }

        return mediana;
    }
    private double somaNumeros() {
        List<ValorDTO> listaValores = valorRepository.findAll();
        double valor = 0;
        for(int i = 0; i < listaValores.size(); i++){
            valor += listaValores.get(i).getValor();
        }
        return valor;
    }

    private double calculaMedia(){

        List<ValorDTO> listaValores = valorRepository.findAll();
        if (listaValores.size()< 20){
            throw new RuntimeException("Insira no mínimo 20 valores!");
        }
         double valor = 0;
         for(int i = 0; i < listaValores.size(); i++){
            valor += listaValores.get(i).getValor();
         }
         return valor / listaValores.size();
    }
}
