package main.main.Repository;

import java.util.List;

public interface ValoresRepository {

    Double create(Double valor);

    List<Double> listar();

    Double somar();
}
