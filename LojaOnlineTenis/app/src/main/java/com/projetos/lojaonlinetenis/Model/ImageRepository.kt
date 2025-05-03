package com.projetos.lojaonlinetenis.Model // Declara o pacote onde a classe ImageRepository está localizada.

import com.projetos.lojaonlinetenis.R // Importa os recursos de drawable do projeto (imagens).

// Classe ImageRepository: Representa o repositório de dados para as imagens e informações dos produtos.
class ImageRepository {

    // Método getImages: Retorna uma lista de objetos ImageModel contendo informações sobre os produtos.
    fun getImages(): List<ImageModel> {
        return listOf(
            // Cria uma lista de objetos ImageModel com dados fictícios (imagens, nomes e preços).
            ImageModel(R.drawable.img_tenis_02, "Tênis 1", "R$ 199,99"), // Produto 1
            ImageModel(R.drawable.img_tenis_01, "Tênis 2", "R$ 249,99"), // Produto 2
            ImageModel(R.drawable.img_tenis_04, "Tênis 3", "R$ 299,99"), // Produto 3
            ImageModel(R.drawable.img_tenis_05, "Tênis 4", "R$ 179,99"), // Produto 4
            ImageModel(R.drawable.img_tenis_06, "Tênis 5", "R$ 219,99"), // Produto 5
            ImageModel(R.drawable.img_tenis_07, "Tênis 6", "R$ 269,99")  // Produto 6
        )
    }
}