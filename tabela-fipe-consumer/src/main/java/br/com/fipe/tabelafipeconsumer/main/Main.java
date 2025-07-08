package br.com.fipe.tabelafipeconsumer.main;

import br.com.fipe.tabelafipeconsumer.model.DadosMarcas;
import br.com.fipe.tabelafipeconsumer.model.DadosModelo;
import br.com.fipe.tabelafipeconsumer.model.ModelosWrapper;
import br.com.fipe.tabelafipeconsumer.model.Veiculo;
import br.com.fipe.tabelafipeconsumer.service.ConsumoApi;
import br.com.fipe.tabelafipeconsumer.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public void exibeMenu() {
        Scanner scanner = new Scanner(System.in);
        ConsumoApi consumoApi = new ConsumoApi();
        ConverteDados conversor = new ConverteDados();

        final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

        System.out.println("*** OPÇÕES *** \n Carro \n Caminhão \n Moto \n");
        System.out.println("Digite uma das opções para consultar valores: \n");
        var opcao = scanner.nextLine();

        String enderecoBusca;
        if (opcao.equalsIgnoreCase("Caminhão")) {
            enderecoBusca = ENDERECO + "caminhoes/marcas/";
        } else {
            enderecoBusca = ENDERECO + opcao.toLowerCase() + "s/marcas/";
        }

        String resultadoBuscaMarcas = consumoApi.obterDados(enderecoBusca);

        List<DadosMarcas> marcas = conversor.obterLista(resultadoBuscaMarcas, DadosMarcas.class);

        marcas.stream()
                .sorted(Comparator.comparing(DadosMarcas::codigo))
                .forEach(marca ->
            System.out.println("Cód: " + marca.codigo() + ", Descrição: " + marca.nome())
        );

        System.out.println("Informe o código da marca para consulta: \n");
        var codigoConsulta = scanner.nextLine();

        String resultadoBuscaModelo = consumoApi.obterDados(enderecoBusca + codigoConsulta + "/modelos");

        ModelosWrapper wrapper = conversor.obterDados(resultadoBuscaModelo, ModelosWrapper.class);

        List<DadosModelo> modelos = wrapper.modelos();

        modelos.stream()
                .sorted(Comparator.comparing(DadosModelo::codigo))
                .forEach(modelo ->
                        System.out.println("Cód: " + modelo.codigo() + " Descrição: " + modelo.nome())
                );

        System.out.println("Digite um trecho do nome do veículo para consulta: \n");
        var trechoVeiculo = scanner.nextLine();

        List<DadosModelo> modelosFiltrados = modelos.stream()
                .filter(m -> m.nome().toLowerCase().contains(trechoVeiculo.toLowerCase()))
                .toList();

        modelosFiltrados.forEach(trecho ->
                        System.out.println("Cód: " + trecho.codigo() + " Descrição: " + trecho.nome())
                );

        System.out.println("Digite o código do modelo para consultar valores: \n");
        var consultaModeloValor = scanner.nextLine();

        String enderecoAnosDoModelo = enderecoBusca + codigoConsulta + "/modelos/" + consultaModeloValor + "/anos";

        String jsonAnos = consumoApi.obterDados(enderecoAnosDoModelo);
        List<DadosMarcas> anos = conversor.obterLista(jsonAnos, DadosMarcas.class);

        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = enderecoAnosDoModelo + "/" + anos.get(i).codigo();
            String jsonVeiculo = consumoApi.obterDados(enderecoAnos);
            Veiculo veiculo = conversor.obterDados(jsonVeiculo, Veiculo.class);
            veiculos.add(veiculo);
        }
        System.out.println("Todos os veículos com os valores por ano: ");
        veiculos.forEach(System.out::println);
    }
}
