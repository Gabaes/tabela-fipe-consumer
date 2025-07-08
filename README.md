# 🚗 Consulta Tabela FIPE

![Status](https://img.shields.io/badge/status-concluído-brightgreen)
![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x.x-green)

## 📝 Descrição

Aplicação de console (CLI - Command Line Interface) desenvolvida em Java com o framework Spring Boot para consultar preços de veículos da Tabela FIPE. O projeto consome a API pública da [Parallelum](https://deividfortuna.github.io/fipe/) para obter dados atualizados de carros, motos e caminhões.

Este projeto foi criado como um exercício prático para solidificar os estudos sobre o ecossistema Spring, focando em conceitos como consumo de APIs, deserialização de dados JSON com a biblioteca Jackson, e manipulação de coleções com Streams.

## ✨ Funcionalidades

O fluxo da aplicação no console permite ao usuário:

* Escolher o tipo de veículo (Carro, Moto ou Caminhão).
* Visualizar uma lista completa das marcas disponíveis para o tipo escolhido.
* Selecionar uma marca através do seu código.
* Visualizar todos os modelos de veículos da marca selecionada.
* Filtrar os modelos por um trecho do nome para facilitar a busca.
* Selecionar um modelo específico através do seu código.
* Exibir uma lista completa com os valores do veículo selecionado para todos os anos disponíveis na Tabela FIPE.

## 🛠️ Tecnologias Utilizadas

* **Java 17:** Versão LTS do Java, utilizada como base para o projeto.
* **Spring Boot:** Framework principal para a criação da aplicação, gerenciamento de dependências e configuração simplificada.
* **Jackson Databind:** Biblioteca para a conversão (deserialização) de dados do formato JSON, retornado pela API, para objetos Java (`Records`).
* **Maven:** Ferramenta para gerenciamento de dependências e build do projeto.
* **API FIPE Parallelum:** API REST pública utilizada como fonte de dados para a consulta de veículos.

## 🚀 Como Executar o Projeto

Para executar este projeto localmente, siga os passos abaixo.

### Pré-requisitos

* [Git](https://git-scm.com)
* [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) - Versão 17 ou superior.
* [Apache Maven](https://maven.apache.org/)

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/Gabaes/tabela-fipe-consumer.git
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd tabela-fipe-consumer
    ```

3.  **Execute a aplicação com o Maven:**
    ```bash
    mvn spring-boot:run
    ```

Após a execução, a aplicação iniciará no seu terminal e exibirá o menu de opções para começar a consulta.

## 👨‍💻 Autor

Desenvolvido por **Gabriel Guedes de Oliveira**.

[![Github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Gabaes)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](http://www.linkedin.com/in/gabriel-guedes-de-oliveira-dev)

## 🙏 Agradecimentos

* Agradecimento especial à **API Parallelum** por fornecer os dados da Tabela FIPE de forma pública e gratuita, viabilizando este projeto.
