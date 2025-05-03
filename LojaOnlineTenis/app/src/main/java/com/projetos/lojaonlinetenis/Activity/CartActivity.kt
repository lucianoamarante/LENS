package com.projetos.lojaonlinetenis.Activity // Declara o pacote onde a classe CartActivity está localizada.

import android.os.Bundle // Importa a classe Bundle para manipular dados salvos no estado da atividade.
import android.widget.Toast // Importa a classe Toast para exibir mensagens rápidas na tela.
import androidx.activity.viewModels // Importa a função viewModels para facilitar a inicialização do ViewModel.
import androidx.appcompat.app.AppCompatActivity // Importa a classe AppCompatActivity, que é a base para atividades compatíveis com versões antigas do Android.
import androidx.lifecycle.Observer // Importa a classe Observer para observar mudanças em objetos LiveData.
import com.projetos.lojaonlinetenis.Model.ImageModel // Importa a classe ImageModel, que representa os dados do produto.
import com.projetos.lojaonlinetenis.ViewModel.CartViewModel // Importa a classe CartViewModel, que gerencia os dados e a lógica da tela de carrinho.
import com.projetos.lojaonlinetenis.databinding.ActivityCartBinding // Importa a classe gerada pelo ViewBinding para acessar os elementos da interface gráfica.

// Classe CartActivity: Representa a tela de carrinho de compras. Herda de AppCompatActivity.
class CartActivity : AppCompatActivity() {

    // Declaração de uma variável lateinit para o binding, que será usado para acessar os elementos da interface gráfica.
    private lateinit var binding: ActivityCartBinding

    // Declaração de uma variável viewModel usando a delegação viewModels(), que cria uma instância do CartViewModel associada a esta atividade.
    private val viewModel: CartViewModel by viewModels()

    // Método onCreate: Chamado quando a atividade é criada. É onde a inicialização da interface e da lógica ocorre.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Chama o método onCreate da superclasse para inicializar a atividade.

        // Infla o layout da atividade usando ViewBinding e atribui o resultado à variável binding.
        binding = ActivityCartBinding.inflate(layoutInflater)

        // Define o conteúdo da atividade como o layout inflado pelo ViewBinding.
        setContentView(binding.root)

        // Obtém o objeto ImageModel passado pela Intent e o converte para o tipo correto.
        val imageModel = intent.getSerializableExtra("IMAGE_MODEL") as ImageModel

        // Passa o objeto ImageModel para o ViewModel para que ele possa ser usado na lógica do carrinho.
        viewModel.setImageModel(imageModel)

        // Observa a quantidade de itens no carrinho e atualiza o TextView correspondente na interface.
        viewModel.quantity.observe(this, Observer { quantity ->
            binding.quantityTextView.text = quantity.toString() // Atualiza o texto do TextView com a quantidade atual.
        })

        // Observa o preço total no carrinho e atualiza o TextView correspondente na interface.
        viewModel.totalPrice.observe(this, Observer { totalPrice ->
            binding.totalPriceTextView.text = "R$ ${String.format("%.2f", totalPrice)}" // Formata o preço total e atualiza o TextView.
        })

        // Configura um listener para o botão de aumentar a quantidade.
        binding.increaseButton.setOnClickListener {
            viewModel.increaseQuantity() // Chama o método no ViewModel para aumentar a quantidade de itens.
        }

        // Configura um listener para o botão de diminuir a quantidade.
        binding.decreaseButton.setOnClickListener {
            viewModel.decreaseQuantity() // Chama o método no ViewModel para diminuir a quantidade de itens.
        }

        // Configura um listener para o botão de finalizar compra.
        binding.checkoutButton.setOnClickListener {
            Toast.makeText(this, "Compra Realizada com Sucesso", Toast.LENGTH_SHORT).show() // Exibe uma mensagem de sucesso ao usuário.
        }

        // Configura um listener para o botão de voltar.
        binding.backButton.setOnClickListener {
            finish() // Encerra a atividade atual, retornando à tela anterior.
        }
    }
}