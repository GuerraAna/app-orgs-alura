package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Produtos

class ProdutosDao {

    fun adiciona(produto: Produtos) {
        Companion.produtos.add(produto)
    }

    fun buscaProdutos(): List<Produtos> {
        return Companion.produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produtos>()
    }

}