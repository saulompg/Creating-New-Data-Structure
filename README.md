# data-structure-assessment

> Primeira avaliação da disciplina de estrutura de dados e algoritmos

Implemente um novo tipo de dado, o qual deve conter um método de inserção, leitura, remoção e impressão dos valores armazenados.
O seu tipo de dado não pode ser igual a nenhum dos tipos apresentados:
* Lista: inserir e remover no inicio e final;
* Fila: inserir no final e remover no início;
* Pilha: inserir e remover no final;

Implemente:
1. Uma classe para a sua estrutura de dados;
2. Uma classe que implemente o tipo de dado Agenda(nome, email, telefone, endereço e CEP);
3. Uma classe Interface para implementar o seu tipo de dado e estrutura de dados criada;

## Estrutura de Dados - Clip
Na Estrutura de Dados Clip:
* O construtor padrão atribui o valor 10 para o tamanho do arranjo. É possível passar como parâmetro do contrutor o tamanho do arranjo;
* A função `isEmpty()` verifica se o arranjo está vazio;
* A função `isFull()` verifica se o arranjo está cheio;
* A função `add()` adiciona um novo elemento ao arranjo. Os elementos são inseridos sempre no inicio do arranjo, deslocando os demais elementos para o final do arranjo;
* A função `remove()` remove e retorna um elemento do arranjo. Os elementos são removidos do Clip pelo inicio do arranjo. Caso o arranjo esteja vazio a função retorna `null`;
* A função `get()` retorna ao usuário o primeiro elemento sem removê-lo do arranjo. Caso o arranjo esteja vazio a função retorna `null`;
* A função `print()` exibe os elementos do arranjo;
* A função `size()` retorna o tamanho do arranjo;

Author: Saulo Gomes 
