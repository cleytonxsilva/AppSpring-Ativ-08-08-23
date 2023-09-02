package main.main.InMemoryRepository;

import main.main.Repository.ValoresRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryValoresRepository implements ValoresRepository {

    private List<Double> valores = new ArrayList<>();

    @Override
    public Double create(Double valor) {
        valores.add(valor);
        return valor;
    }

    @Override
    public List<Double> listar() {
        return valores;
    }

    @Override
    public Double somar() {
        Double soma = 0.0;
        for(int i = 0; i < valores.size(); i++){
            soma += valores.get(i);
        }
        return soma;
    }
}
