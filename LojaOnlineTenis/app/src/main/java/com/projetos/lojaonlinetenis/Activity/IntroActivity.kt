package com.projetos.lojaonlinetenis.Activity // Pacote onde a classe IntroActivity está localizada

import android.content.Intent // Importação da classe Intent para iniciar novas atividades
import android.os.Bundle // Importação da classe Bundle para manipulação de dados entre atividades
import android.os.Handler // Importação da classe Handler para agendar tarefas
import android.os.Looper // Importação da classe Looper para o loop de mensagens
import androidx.appcompat.app.AppCompatActivity // Importação da classe AppCompatActivity para criação de atividades
import com.projetos.lojaonlinetenis.databinding.ActivityIntroBinding // Importação da classe ActivityIntroBinding para binding de layout

// Classe IntroActivity: Representa a tela de introdução (splash screen) do aplicativo. Herda de AppCompatActivity.
class IntroActivity : AppCompatActivity() {

    // Declaração de uma variável lateinit para o binding, que será usado para acessar os elementos da interface gráfica.
    private lateinit var binding: ActivityIntroBinding

    // Método onCreate: Chamado quando a atividade é criada. É onde a inicialização da interface e da lógica ocorre.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Chama o método onCreate da superclasse para inicializar a atividade.

        // Infla o layout da atividade usando ViewBinding e atribui o resultado à variável binding.
        binding = ActivityIntroBinding.inflate(layoutInflater)

        // Define o conteúdo da atividade como o layout inflado pelo ViewBinding.
        setContentView(binding.root)

        // Agendar a transição para a MainActivity após 3 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            // Cria uma Intent para navegar para a MainActivity
            startActivity(Intent(this, MainActivity::class.java)) // Início da MainActivity

            // Encerra a IntroActivity para que o usuário não possa voltar para ela pressionando o botão "Voltar".
            finish()
        }, 3000) // Tempo de espera de 3 segundos (3000 milissegundos)
    }
}