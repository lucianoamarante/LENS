package com.projetos.lojaonlinetenis.Adapter // Declara o pacote onde a classe ImageAdapter está localizada.

import android.content.Intent // Importa a classe Intent para navegar entre atividades.
import android.view.LayoutInflater // Importa a classe LayoutInflater para inflar layouts.
import android.view.ViewGroup // Importa a classe ViewGroup para gerenciar grupos de views.
import androidx.recyclerview.widget.RecyclerView // Importa a classe RecyclerView para exibir listas de dados.
import com.projetos.lojaonlinetenis.Activity.DetailActivity // Importa a classe DetailActivity para navegar para a tela de detalhes.
import com.projetos.lojaonlinetenis.Model.ImageModel // Importa a classe ImageModel, que representa os dados do produto.
import com.projetos.lojaonlinetenis.databinding.ItemImageBinding // Importa a classe ItemImageBinding para binding de layout.

// Classe ImageAdapter: Adaptador personalizado para o RecyclerView. Gerencia a exibição da lista de imagens.
class ImageAdapter(private var imageList: List<ImageModel>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    // Classe interna ImageViewHolder: Representa um item individual na lista do RecyclerView.
    inner class ImageViewHolder(private val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
        // Método bind: Vincula os dados do modelo (ImageModel) ao layout do item.
        fun bind(imageModel: ImageModel) {
            binding.imageView.setImageResource(imageModel.imageResId) // Define a imagem do produto.
            binding.textViewName.text = imageModel.name // Define o nome do produto.
            binding.textViewPrice.text = imageModel.price // Define o preço do produto.

            // Configura um listener para o clique no item.
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, DetailActivity::class.java) // Cria uma Intent para navegar para a tela de detalhes.
                intent.putExtra("IMAGE_MODEL", imageModel) // Passa o objeto ImageModel para a próxima atividade.
                binding.root.context.startActivity(intent) // Inicia a atividade de detalhes.
            }
        }
    }

    // Método onCreateViewHolder: Cria e retorna uma nova instância de ImageViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false) // Infla o layout do item.
        return ImageViewHolder(binding) // Retorna uma nova instância de ImageViewHolder.
    }

    // Método onBindViewHolder: Vincula os dados de um item específico ao ViewHolder.
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imageList[position]) // Chama o método bind do ViewHolder para vincular os dados.
    }

    // Método getItemCount: Retorna o número total de itens na lista.
    override fun getItemCount(): Int = imageList.size

    // Método updateList: Atualiza a lista de imagens e notifica o adaptador sobre as mudanças.
    fun updateList(newList: List<ImageModel>) {
        imageList = newList // Atualiza a lista de imagens.
        notifyDataSetChanged() // Notifica o adaptador para atualizar a interface.
    }
}