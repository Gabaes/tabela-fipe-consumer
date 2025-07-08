package br.com.fipe.tabelafipeconsumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMarcas(String codigo, String  nome) {
}
