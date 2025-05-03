package com.projetos.lojaonlinetenis.Activity // Declara o pacote onde a classe DetailActivity está localizada.

import android.content.Intent // Importa a classe Intent para navegar entre atividades.
import android.os.Bundle // Importa a classe Bundle para manipular dados salvos no estado da atividade.
import android.widget.Toast // Importa a classe Toast para exibir mensagens rápidas na tela.
import androidx.activity.viewModels // Importa a função viewModels para facilitar a inicialização do ViewModel.
import androidx.appcompat.app.AppCompatActivity // Importa a classe AppCompatActivity, que é a base para atividades compatíveis com versões antigas do Android.
import androidx.core.content.ContextCompat // Importa a classe ContextCompat para acessar recursos de forma segura.
import com.projetos.lojaonlinetenis.Model.ImageModel // Importa a classe ImageModel, que representa os dados do produto.
import com.projetos.lojaonlinetenis.ViewModel.DetailViewModel // Importa a classe DetailViewModel, que gerencia os dados e a lógica da tela de detalhes.
import com.projetos.lojaonlinetenis.databinding.ActivityDetailBinding // Importa a classe gerada pelo ViewBinding para acessar os elementos da interface gráfica.

// Classe DetailActivity: Representa a tela de detalhes do produto. Herda de AppCompatActivity.
class DetailActivity : AppCompatActivity() {

    // Declaração de uma variável lateinit para o binding, que será usado para acessar os elementos da interface gráfica.
    private lateinit var binding: ActivityDetailBinding

    // Declaração de uma variável viewModel usando a delegação viewModels(), que cria uma instância do DetailViewModel associada a esta atividade.
    private val viewModel: DetailViewModel by viewModels()

    // Método onCreate: Chamado quando a atividade é criada. É onde a inicialização da interface e da lógica ocorre.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Chama o método onCreate da superclasse para inicializar a atividade.

        // Infla o layout da atividade usando ViewBinding e atribui o resultado à variável binding.
        binding = ActivityDetailBinding.inflate(layoutInflater)

        // Define o conteúdo da atividade como o layout inflado pelo ViewBinding.
        setContentView(binding.root)

        // Obtém o objeto ImageModel passado pela Intent e o converte para o tipo correto.
        val imageModel = intent.getSerializableExtra("IMAGE_MODEL") as ImageModel

        // Passa o objeto ImageModel para o ViewModel para que ele possa ser usado na lógica da tela de detalhes.
        viewModel.setImageModel(imageModel)

        // Observa o modelo de imagem no ViewModel e atualiza a interface com os dados do produto.
        viewModel.imageModel.observe(this, { imageModel ->
            binding.shoeImage.setImageResource(imageModel.imageResId) // Define a imagem do produto.
            binding.shoeName.text = imageModel.name // Define o nome do produto.
            binding.shoePrice.text = imageModel.price // Define o preço do produto.
            binding.shoeDescription.text =
                "Eles são um cruzamento entre o Air Force 1, o Air Jordan e o Nike Terminator. O primeiro modelo saiu em 1985 e foi chamado de Dunk em homenagem aos feitos dos jogadores. Peter Moore cria a silhueta em um design alto. Arredondado na ponta, sola larga para estabilidade e calcanhar macio. Perfeito para jogos de basquete. Eles são para competição." // Define a descrição fixa do produto.
        })

        // Observa o botão de tamanho selecionado no ViewModel e atualiza sua aparência na interface.
        viewModel.selectedSizeButton.observe(this, { selectedButton ->
            selectedButton?.let { button ->
                button.isSelected = true // Marca o botão como selecionado.
                button.setTextColor(ContextCompat.getColor(this, android.R.color.white)) // Altera a cor do texto do botão para branco.
            }
        })

        // Cria uma lista com os botões de tamanho disponíveis na interface.
        val sizeButtons = listOf(
            binding.buttonSize38,
            binding.buttonSize39,
            binding.buttonSize40,
            binding.buttonSize41,
            binding.buttonSize42,
            binding.buttonSize43
        )

        // Configura um listener para cada botão de tamanho.
        sizeButtons.forEach { button ->
            button.setOnClickListener {
                viewModel.selectSizeButton(button) // Chama o método no ViewModel para selecionar o botão de tamanho.
            }
        }

        // Configura um listener para o botão de comprar agora.
        binding.buttonBuyNow.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java) // Cria uma Intent para navegar para a tela de carrinho.
            intent.putExtra("IMAGE_MODEL", imageModel) // Passa o objeto ImageModel para a próxima atividade.
            startActivity(intent) // Inicia a atividade de carrinho.
        }

        // Configura um listener para o ícone de favoritos.
        binding.favoriteIcon.setOnClickListener {
            Toast.makeText(this, "Adicionado aos Favoritos!", Toast.LENGTH_SHORT).show() // Exibe uma mensagem informando que o item foi adicionado aos favoritos.
        }

        // Configura um listener para o botão de voltar.
        binding.backButton.setOnClickListener {
            finish() // Encerra a atividade atual, retornando à tela anterior.
        }
    }
}