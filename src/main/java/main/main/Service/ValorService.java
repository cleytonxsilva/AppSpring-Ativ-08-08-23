package main.main.Service;


import main.main.DTO.InformacaoDTO;
import main.main.InMemoryRepository.InMemoryValoresRepository;
import main.main.Repository.ValoresRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ValorService {

    private final ValoresRepository valoresRepository = new InMemoryValoresRepository();

    public Double create(Double valor) {
        return valoresRepository.create(valor);
    }

    public List<Double> listar(){
        return valoresRepository.listar();
    }

    public Double somar(){
        return valoresRepository.somar();
    }

    public int tamanhoLista(){
        return valoresRepository.listar().size();
    }

    public Double valorMinimo() {
        List<Double> listaValores = listar();
        return Collections.min(listaValores);
    }

    public Double valorMaximo() {
        List<Double> listaValores = listar();
        return Collections.max(listaValores);
    }

    public Double calcularMedia(){
        return somar() / tamanhoLista();
    }

    public double calcularMediana() {
        List<Double> listaValores = listar();

        Collections.sort(listaValores);

        double mediana;

        if (listaValores.size() % 2 == 0) {
            int indice1 = listaValores.size() / 2 - 1;
            int indice2 = listaValores.size() / 2;
            mediana = (listaValores.get(indice1) + listaValores.get(indice2)) / 2;
        } else {
            int indice = listaValores.size() / 2;
            mediana = listaValores.get(indice);

        }

        return mediana;
    }

    public Double calcularDesvioPadrao() {
        List<Double> listaValores = listar();
        Double media = calcularMedia();
        Double difQuadrado = 0.0;

        for (int i = 0; i < listaValores.size(); i++){
            double diferenca = listaValores.get(i) - media;
            difQuadrado += Math.pow(diferenca, 2);
        }

        return Math.sqrt(difQuadrado / (listaValores.size() - 1));
    }

    public InformacaoDTO informacao() {
        return new InformacaoDTO(
                somar(),
                calcularMedia(),
                calcularMediana(),
                tamanhoLista(),
                calcularDesvioPadrao(),
                valorMaximo(),
                valorMinimo()
        );
    }
}
