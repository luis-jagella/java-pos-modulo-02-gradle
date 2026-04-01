# Java CLI Cardápio System

Projeto desenvolvido durante estudos de **Java (pós-graduação)** com foco em:

* Manipulação de dados com **Collections**
* Estruturação de código em camadas
* Prática de **entrada/saída (CLI)**
* Uso de **Enums**
* Organização com **Gradle**

---

## Objetivo:

Construir um sistema de linha de comando (CLI) para gerenciamento de um cardápio, aplicando conceitos fundamentais de Java na prática.

---

## Conceitos aplicados:

* `List` (ArrayList)
* `Enum` (Categoria)
* Separação de responsabilidades (CLI vs Service)
* Validação de dados
* Estrutura de projeto com Gradle
* Entrada de dados com `Scanner`

---

## Estrutura do Projeto:

```
modulo2.collections.aula02_cli
│
├── MenuCLI.java         # Interface de interação com o usuário
├── Main.java            # Ponto de entrada da aplicação
│
├── model
│   ├── Produto.java     # Entidade do sistema
│   └── Categoria.java   # Enum de categorias
│
└── service
    └── CardapioService.java  # Regras de negócio
```

---

## ⚙Funcionalidades implementadas:

### * Listar produtos

* Exibe todos os produtos cadastrados
* Trata cenário de lista vazia

### * Adicionar produto

* Nome
* Preço
* Categoria (Enum)

### * Validações básicas

* Nome não pode ser vazio
* Preço deve ser maior que 0
* Categoria obrigatória

---

## Exemplo de uso:

```
1 - Listar
2 - Adicionar
0 - Sair

Qual o nome do produto?
Leite

Qual o preço do produto?
1

Qual a categoria do produto? (LANCHE, BEBIDA, SOBREMESA)
BEBIDA

O produto Leite foi adicionado!
```

---

## ▶ Como executar

### Pelo IntelliJ IDEA

* Abrir o projeto
* Executar a classe `Main.java`

### Pelo terminal (Gradle)

```
./gradlew run
```

> obs: Certifique-se de que o plugin `application` está configurado no `build.gradle`

---

## Aprendizados importantes:

* Diferença entre **lógica de negócio (Service)** e **interface (CLI)**
* Problemas comuns com `Scanner` (`nextInt`, `nextLine`)
* Importância de validação de dados
* Uso correto de `Enum`
* Organização de código para projetos reais

---

## Próximos passos (Aula 03)

O projeto será evoluído (sem recriar do zero) com:

* Busca de produtos por nome
* Filtro por categoria
* Ordenação por preço
* Introdução à Stream API

---

## Observação

Este projeto está sendo construído com foco em **aprendizado prático**, evoluindo gradualmente a cada módulo.

---

Desenvolvido por **Luis Gabriel Pereira**
