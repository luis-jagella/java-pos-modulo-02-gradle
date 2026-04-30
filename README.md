# Java CLI - Cardápio System

Projeto desenvolvido durante estudos de **Java (pós-graduação)** com foco em construção de aplicações reais utilizando **Collections, Stream API e boas práticas de arquitetura**.

---

## Objetivo:

Construir um sistema de linha de comando (CLI) para gerenciamento de um cardápio, aplicando conceitos fundamentais de Java na prática e evoluindo progressivamente o código.

---

## Conceitos aplicados:

* `List` (ArrayList)
* `Enum` (Categoria)
* Separação de responsabilidades (**CLI vs Service**)
* Validação de dados
* Estrutura de projeto com **Gradle**
* Entrada de dados com `Scanner`
* Base Server HTTP
* Concurrency
* **Stream API**

  * `filter`
  * `sorted`
  * `toList`

---

## 📂 Estrutura do Projeto:

```
modulo2.collections.aula02_cli
│
├── MenuCLI.java         # Interface de interação com o usuário (CLI)
├── Main.java            # Ponto de entrada da aplicação
│
├── model
│   ├── Produto.java     # Entidade do sistema
│   └── Categoria.java   # Enum de categorias
│
└── service
    └── CardapioService.java  # Regras de negócio e manipulação de dados
```

---

## Funcionalidades implementadas

### Listar produtos

* Exibe todos os produtos cadastrados
* Trata cenário de lista vazia

---

### ➕ Adicionar produto

* Nome
* Preço
* Categoria (Enum)
* Validações básicas aplicadas

---

### Buscar por nome

* Busca produtos pelo nome
* Comparação com `equalsIgnoreCase`
* Retorna lista de resultados

---

### Filtrar por categoria

* Filtra produtos por categoria (`Enum`)
* Uso de `Stream API`

---

### Ordenar por preço

* Ordena produtos por preço (crescente)
* Uso de `Comparator` + `Stream API`

---

## Exemplo de uso

```
1 - Listar
2 - Adicionar
3 - Buscar
4 - Filtrar
5 - Ordenar
0 - Sair
```

---

## Como executar

### Pelo IntelliJ IDEA

* Abrir o projeto
* Executar a classe `Main.java`

### Pelo terminal (Gradle)

```
./gradlew run
```

> ⚠️ Certifique-se de que o plugin `application` está configurado no `build.gradle`

---

## Aprendizados importantes

* Diferença entre **lógica de negócio (Service)** e **interface (CLI)**
* Problemas comuns com `Scanner` (`nextInt`, `nextLine`)
* Importância da validação de dados
* Uso correto de `Enum`
* Introdução prática à **Stream API**
* Separação de responsabilidades em projetos reais
* Evitar efeitos colaterais (não alterar lista original em consultas)

---

## 🚧 Próximos passos (Refatoração)

O projeto continuará evoluindo com melhorias estruturais:

* Remoção de código duplicado (métodos utilitários)
* Uso de `switch` no menu
* Tratamento de erros (`try/catch`)
* Melhor organização e legibilidade do código

---

## Observação

Este projeto está sendo desenvolvido com foco em **aprendizado progressivo**, simulando a evolução de um sistema real — começando simples e sendo refinado ao longo do tempo.

---

## Dev

Desenvolvido por **Luís Gabriel Pereira**
