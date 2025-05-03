package br.com.oticaslens.ui.pesquisar

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.oticaslens.R

class PesquisarFragment : Fragment() {

    companion object {
        fun newInstance() = PesquisarFragment()
    }

    private val viewModel: PesquisarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_pesquisar, container, false)
    }
}