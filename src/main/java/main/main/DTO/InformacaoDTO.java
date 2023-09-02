package main.main.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InformacaoDTO implements Serializable {

    private Double soma;

    private Double media;

    private Double mediana;

    private int qtdValores;

    private Double desvioPadrao;

    private Double valorMaximo;

    private Double valorMinimo;

}
