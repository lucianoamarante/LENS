package com.projetos.lojaonlinetenis.ViewModel // Declara o pacote onde a classe CartViewModel está localizada.

import androidx.lifecycle.LiveData // Importa a classe LiveData para observar mudanças nos dados.
import androidx.lifecycle.MutableLiveData // Importa a classe MutableLiveData para atualizar os dados observáveis.
import androidx.lifecycle.ViewModel // Importa a classe ViewModel, que gerencia os dados da interface.
import com.projetos.lojaonlinetenis.Model.ImageModel // Importa a classe ImageModel, que representa os dados do produto.

// Classe CartViewModel: Representa o ViewModel para a tela de carrinho. Gerencia os dados e a lógica relacionada ao carrinho.
class CartViewModel : ViewModel() {

    // Variável privada _quantity: Armazena a quantidade de itens no carrinho como um MutableLiveData.
    private val _quantity = MutableLiveData(1)

    // Variável pública quantity: Expõe a quantidade de itens como um LiveData para ser observada pela View.
    val quantity: LiveData<Int> get() = _quantity

    // Variável privada _totalPrice: Armazena o preço total dos itens no carrinho como um MutableLiveData.
    private val _totalPrice = MutableLiveData(0.0)

    // Variável pública totalPrice: Expõe o preço total como um LiveData para ser observado pela View.
    val totalPrice: LiveData<Double> get() = _totalPrice

    // Variável privada imageModel: Armazena o modelo de imagem (produto) selecionado.
    private var imageModel: ImageModel? = null

    // Método setImageModel: Define o modelo de imagem (produto) no ViewModel e atualiza o preço total.
    fun setImageModel(imageModel: ImageModel) {
        this.imageModel = imageModel // Define o modelo de imagem.
        updateTotalPrice() // Atualiza o preço total com base no novo modelo de imagem.
    }

    // Método increaseQuantity: Aumenta a quantidade de itens no carrinho em 1.
    fun increaseQuantity() {
        _quantity.value = _quantity.value?.plus(1) // Incrementa a quantidade.
        updateTotalPrice() // Atualiza o preço total após aumentar a quantidade.
    }

    // Método decreaseQuantity: Diminui a quantidade de itens no carrinho em 1, se a quantidade for maior que 1.
    fun decreaseQuantity() {
        if (_quantity.value ?: 1 > 1) { // Verifica se a quantidade é maior que 1.
            _quantity.value = _quantity.value?.minus(1) // Decrementa a quantidade.
            updateTotalPrice() // Atualiza o preço total após diminuir a quantidade.
        }
    }

    // Método privado updateTotalPrice: Calcula e atualiza o preço total com base na quantidade e no preço do produto.
    private fun updateTotalPrice() {
        val price = imageModel?.price?.replace("R$ ", "")?.replace(",", ".")?.toDouble() ?: 0.0
        // Remove "R$ " e substitui "," por "." para converter o preço em Double.
        _totalPrice.value = price * (_quantity.value ?: 1) // Calcula o preço total multiplicando o preço unitário pela quantidade.
    }
}