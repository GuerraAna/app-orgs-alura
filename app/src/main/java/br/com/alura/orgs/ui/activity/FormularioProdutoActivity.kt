package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutosDao
import br.com.alura.orgs.databinding.ActivityFormularioProdutoBinding
import br.com.alura.orgs.model.Produtos
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    private lateinit var binding: ActivityFormularioProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFormularioProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        toolbarDados(binding)

        buttonSalvar(binding)

    }

    private fun toolbarDados(binding: ActivityFormularioProdutoBinding) {
        val toolbarDados = binding.toolbarDados
        toolbarDados.setNavigationIcon(getDrawable(R.drawable.ic_baseline_arrow_back_ios_24))
        toolbarDados.setTitle("Orgs Cadastro de Produtos")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toolbarDados.setBackgroundColor(getColor(R.color.purple_500))
            toolbarDados.setTitleTextColor(getColor(R.color.white))
        }
        toolbarDados.setNavigationOnClickListener {
            val intent = Intent(this, ListaProdutosActivity::class.java)
            startActivity(intent)
        }
    }

    private fun buttonSalvar(binding: ActivityFormularioProdutoBinding) {
        val button = binding.btSalvar
        val dao = ProdutosDao()
        button.setOnClickListener {
            val produtoNovo = criaProduto(binding)
            dao.adiciona(produtoNovo)
        }
    }

    private fun criaProduto(binding: ActivityFormularioProdutoBinding): Produtos {
        val campoNome = binding.insereNomeProduto
        val nome = campoNome.text.toString()
        val campoDescricao = binding.insereDescricaoProduto
        val descricao = campoDescricao.text.toString()
        val campoValor = binding.insereValorProduto
        val valor = campoValor.text.toString()
        val condicaoCampoValor = if (valor.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valor)
        }

        return Produtos(
            nome = nome,
            descricao = descricao,
            valor = condicaoCampoValor
        )
    }

}