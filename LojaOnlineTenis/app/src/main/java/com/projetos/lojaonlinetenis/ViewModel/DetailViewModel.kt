package com.projetos.lojaonlinetenis.ViewModel // Declara o pacote onde a classe DetailViewModel está localizada.

import android.widget.Button // Importa a classe Button para manipular botões na interface.
import androidx.core.content.ContextCompat // Importa a classe ContextCompat para acessar recursos de forma segura.
import androidx.lifecycle.LiveData // Importa a classe LiveData para observar mudanças nos dados.
import androidx.lifecycle.MutableLiveData // Importa a classe MutableLiveData para atualizar os dados observáveis.
import androidx.lifecycle.ViewModel // Importa a classe ViewModel, que gerencia os dados da interface.
import com.projetos.lojaonlinetenis.Model.ImageModel // Importa a classe ImageModel, que representa os dados do produto.

// Classe DetailViewModel: Representa o ViewModel para a tela de detalhes. Gerencia os dados e a lógica relacionada à tela de detalhes.
class DetailViewModel : ViewModel() {

    // Variável privada _imageModel: Armazena o modelo de imagem (produto) como um MutableLiveData.
    private val _imageModel = MutableLiveData<ImageModel>()

    // Variável pública imageModel: Expõe o modelo de imagem como um LiveData para ser observado pela View.
    val imageModel: LiveData<ImageModel> get() = _imageModel

    // Variável privada _selectedSizeButton: Armazena o botão de tamanho selecionado como um MutableLiveData.
    private val _selectedSizeButton = MutableLiveData<Button?>()

    // Variável pública selectedSizeButton: Expõe o botão de tamanho selecionado como um LiveData para ser observado pela View.
    val selectedSizeButton: LiveData<Button?> get() = _selectedSizeButton

    // Método setImageModel: Define o modelo de imagem (produto) no ViewModel.
    fun setImageModel(imageModel: ImageModel) {
        _imageModel.value = imageModel // Atualiza o valor do modelo de imagem.
    }

    // Método selectSizeButton: Seleciona um botão de tamanho e atualiza sua aparência.
    fun selectSizeButton(button: Button) {
        _selectedSizeButton.value?.isSelected = false // Desmarca o botão anteriormente selecionado.
        _selectedSizeButton.value?.setTextColor(ContextCompat.getColor(button.context, android.R.color.black)) // Restaura a cor do texto do botão anterior.
        button.isSelected = true // Marca o botão atual como selecionado.
        button.setTextColor(ContextCompat.getColor(button.context, android.R.color.white)) // Altera a cor do texto do botão atual para branco.
        _selectedSizeButton.value = button // Atualiza o botão selecionado no ViewModel.
    }
}