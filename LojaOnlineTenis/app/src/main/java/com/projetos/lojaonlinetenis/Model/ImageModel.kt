package com.projetos.lojaonlinetenis.Model // Pacote onde a classe está localizada

import java.io.Serializable // Importação da interface Serializable para permitir a serialização do objeto

data class ImageModel( // Declaração da classe de dados ImageModel
    val imageResId: Int, // Propriedade para o ID do recurso da imagem
    val name: String, // Propriedade para o nome do item
    val price: String // Propriedade para o preço do item
) : Serializable { // Implementação da interface Serializable para permitir a serialização do objeto
    // A interface Serializable permite que objetos dessa classe sejam convertidos em bytes e transmitidos entre componentes do sistema
}
