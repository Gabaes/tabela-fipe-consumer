package br.com.fipe.tabelafipeconsumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelosWrapper(@JsonProperty("modelos") List<DadosModelo> modelos,
                             @JsonProperty("anos") List<DadosMarcas> anos) {
}
