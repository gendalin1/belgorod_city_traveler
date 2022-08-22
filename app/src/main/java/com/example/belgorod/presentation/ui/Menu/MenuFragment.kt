package com.example.belgorod.presentation.ui.Menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belgorod.R
import com.example.belgorod.app.appComponent
import com.example.belgorod.databinding.FragmentMenuBinding
import com.example.belgorod.presentation.Adapters.CategoryAdapter
import com.example.belgorod.presentation.Adapters.SliderAdapter
import com.example.belgorod.presentation.Adapters.VerticalSpaceItemDecoration
import com.smarteist.autoimageslider.SliderView

class MenuFragment : Fragment() {

    private val viewModel: MenuViewModel by viewModels {
        MenuViewModelFactory(
            menuInteractor = requireActivity().appComponent.menuInteractor
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}