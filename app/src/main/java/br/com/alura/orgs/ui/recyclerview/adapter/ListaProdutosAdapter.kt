package br.com.alura.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produtos

class ListaProdutosAdapter(
    produtos: List<Produtos>,
    private val context: Context
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun vincula(produto: Produtos) {
            val nome = itemView.findViewById<TextView>(R.id.nome_do_produto)
                nome.text = produto.nome
            val ingredientes = itemView.findViewById<TextView>(R.id.ingredientes_do_produto)
                ingredientes.text =produto.descricao
            val valor = itemView.findViewById<TextView>(R.id.valor_do_produto)
                valor.text = produto.valor.toPlainString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_view_lista, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size

    fun atualiza(produtos: List<Produtos>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

}
