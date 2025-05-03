package com.projetos.lojaonlinetenis.Activity // Declara o pacote onde a classe MainActivity está localizada.

import android.os.Bundle // Importa a classe Bundle para manipular dados salvos no estado da atividade.
import androidx.activity.viewModels // Importa a função viewModels para facilitar a inicialização do ViewModel.
import androidx.appcompat.app.AppCompatActivity // Importa a classe AppCompatActivity, que é a base para atividades compatíveis com versões antigas do Android.
import androidx.lifecycle.Observer // Importa a classe Observer para observar mudanças em objetos LiveData.
import androidx.recyclerview.widget.GridLayoutManager // Importa a classe GridLayoutManager para organizar itens em uma grade.
import com.projetos.lojaonlinetenis.Adapter.ImageAdapter // Importa a classe ImageAdapter, que é o adaptador para o RecyclerView.
import com.projetos.lojaonlinetenis.ViewModel.MainViewModel // Importa a classe MainViewModel, que gerencia os dados e a lógica da tela principal.
import com.projetos.lojaonlinetenis.databinding.ActivityMainBinding // Importa a classe gerada pelo ViewBinding para acessar os elementos da interface gráfica.

// Classe MainActivity: Representa a tela principal do aplicativo. Herda de AppCompatActivity.
class MainActivity : AppCompatActivity() {

    // Declaração de uma variável lateinit para o binding, que será usado para acessar os elementos da interface gráfica.
    private lateinit var binding: ActivityMainBinding

    // Declaração de uma variável viewModel usando a delegação viewModels(), que cria uma instância do MainViewModel associada a esta atividade.
    private val viewModel: MainViewModel by viewModels()

    // Método onCreate: Chamado quando a atividade é criada. É onde a inicialização da interface e da lógica ocorre.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Chama o método onCreate da superclasse para inicializar a atividade.

        // Infla o layout da atividade usando ViewBinding e atribui o resultado à variável binding.
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Define o conteúdo da atividade como o layout inflado pelo ViewBinding.
        setContentView(binding.root)

        // Cria uma instância do adaptador ImageAdapter com uma lista vazia inicialmente.
        val adapter = ImageAdapter(emptyList())

        // Configura o RecyclerView para usar um GridLayoutManager com 2 colunas.
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Define o adaptador criado como o adaptador do RecyclerView.
        binding.recyclerView.adapter = adapter

        // Observa a lista de imagens no ViewModel e atualiza o adaptador quando a lista muda.
        viewModel.imageList.observe(this, Observer { images ->
            images?.let {
                adapter.updateList(it) // Atualiza a lista de imagens no adaptador com os novos dados.
            }
        })
    }
}