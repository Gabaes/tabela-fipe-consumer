package br.com.fipe.tabelafipeconsumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosModelo(String codigo, String  nome) {
}
