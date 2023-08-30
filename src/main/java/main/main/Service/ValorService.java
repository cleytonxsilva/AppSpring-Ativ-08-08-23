package main.main.Service;

import main.main.DTO.InformacaoDTO;
import main.main.DTO.ValorDTO;
import main.main.Repository.ValorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        informacaoDTO.media = calculaMedia();
        informacaoDTO.qtdValores = numerosCalculados();
        informacaoDTO.mediana = calculaMediana();
        informacaoDTO.desvioPadrao = calculaDesvioPadrao();
        return informacaoDTO;

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
//        Collections.sort(listaValores);
        double mediana;
           if (listaValores.size() % 2 == 0){

               int aux = listaValores.size() / 2;

               mediana = listaValores.get(aux).getValor() +listaValores.get(aux-1).getValor();

               return mediana / 2;
           }
           else {
               int aux = listaValores.size() / 2;
               mediana = listaValores.get(aux).getValor();
               return mediana;
           }

    }

    private int numerosCalculados() {
        List<ValorDTO> listaValores = valorRepository.findAll();
        return listaValores.size();
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
