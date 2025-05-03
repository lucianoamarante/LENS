package com.projetos.lojaonlinetenis.ViewModel // Declara o pacote onde a classe MainViewModel está localizada.

import androidx.lifecycle.LiveData // Importa a classe LiveData para observar mudanças nos dados.
import androidx.lifecycle.MutableLiveData // Importa a classe MutableLiveData para atualizar os dados observáveis.
import androidx.lifecycle.ViewModel // Importa a classe ViewModel, que gerencia os dados da interface.
import com.projetos.lojaonlinetenis.Model.ImageModel // Importa a classe ImageModel, que representa os dados do produto.
import com.projetos.lojaonlinetenis.Model.ImageRepository // Importa a classe ImageRepository, que fornece acesso aos dados dos produtos.

// Classe MainViewModel: Representa o ViewModel para a tela principal. Gerencia os dados e a lógica relacionada à lista de imagens.
class MainViewModel : ViewModel() {

    // Variável privada _imageList: Armazena a lista de imagens como um MutableLiveData.
    private val _imageList = MutableLiveData<List<ImageModel>>()

    // Variável pública imageList: Expõe a lista de imagens como um LiveData para ser observada pela View.
    val imageList: LiveData<List<ImageModel>> get() = _imageList

    // Instância do repositório que fornece os dados das imagens.
    private val repository = ImageRepository()

    // Bloco init: Executado quando a instância do ViewModel é criada. Carrega as imagens iniciais.
    init {
        loadImages() // Chama o método para carregar as imagens.
    }

    // Método privado loadImages: Carrega a lista de imagens do repositório e atualiza o LiveData.
    private fun loadImages() {
        val images = repository.getImages() // Obtém a lista de imagens do repositório.
        _imageList.value = images // Atualiza o valor do LiveData com a lista de imagens.
    }
}