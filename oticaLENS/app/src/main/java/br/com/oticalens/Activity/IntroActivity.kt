package br.com.oticalens.Activity


import android.content.Intent
import android.os.Bundle
import android.os.Handler

import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import br.com.oticalens.R
import br.com.oticalens.databinding.ActivityIntroBinding
import kotlinx.coroutines.handleCoroutineException
import java.lang.invoke.MethodHandles
import java.util.logging.Handler


class IntroActivity : AppCompatActivity() {

    // as definindo as variaves de interface grafica
    private lateinit var binding: ActivityIntroBinding


    // vai inicializar a lógica
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // inflando activity
        binding = ActivityIntroBinding.inflate(layoutInflater)
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