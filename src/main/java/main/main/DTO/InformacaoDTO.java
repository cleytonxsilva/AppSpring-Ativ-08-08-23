package main.main.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InformacaoDTO {

    private double soma;

    private double media;

    private double mediana;

    private int qtdValores;

    private double desvioPadrao;

    private double valorMaximo;

    private double valorMinimo;

}
