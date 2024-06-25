# Creating-New-Data-Structure

> Primeira avaliação da disciplina de Estrutura de Dados e Algoritmos

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
* O construtor padrão atribui o valor 10 para o tamanho do arranjo. É possível passar como parâmetro do construtor o tamanho do arranjo;
* O método `isEmpty()` verifica se o arranjo está vazio;
* O método `isFull()` verifica se o arranjo está cheio;
* O método `add()` adiciona um novo elemento ao arranjo. Os elementos são inseridos sempre no inicio do arranjo, deslocando os demais elementos para o final do arranjo;
* O método `remove()` remove e retorna um elemento do arranjo. Os elementos são removidos do Clip pelo inicio do arranjo. Caso o arranjo esteja vazio é retornado `null`;
* O método `get()` retorna ao usuário o primeiro elemento sem removê-lo do arranjo. Caso o arranjo esteja vazio é retornado `null`;
* O método `print()` exibe os elementos do arranjo;
* O método `size()` retorna o tamanho do arranjo;

Autor: Saulo Gomes 
