package main.main.Repository;


import main.main.Entity.Valor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ValorRepository {

    private List<Valor> valores = new ArrayList<>();
    public List<Valor> findAll() {
        return this.valores;
    }

    public void save(Valor valor) {
        valores.add(valor);
    }
}
