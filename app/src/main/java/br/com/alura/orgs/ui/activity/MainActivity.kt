package br.com.alura.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import br.com.alura.orgs.databinding.ActiviryMainBinding
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

class MainActivity: Activity() {

    private lateinit var binding: ActiviryMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActiviryMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        recyclerView.adapter = ListaProdutosAdapter()

    }
}