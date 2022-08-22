package com.example.belgorod.presentation.ui.Menu

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belgorod.MainActivity
import com.example.belgorod.R
import com.example.belgorod.app.appComponent
import com.example.belgorod.databinding.FragmentObjectBinding
import com.example.belgorod.presentation.Adapters.CategoryAdapter
import com.example.belgorod.presentation.Adapters.ObjectsAdapter
import com.example.belgorod.presentation.Adapters.VerticalSpaceItemDecoration

class ObjectsFragment : Fragment() {

    private val viewModel: MenuViewModel by viewModels {
        MenuViewModelFactory(
            menuInteractor = requireActivity().appComponent.menuInteractor
        )
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val actionBar = (activity as MainActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.show()

        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    android.R.id.home -> {
                        actionBar?.setDisplayHomeAsUpEnabled(false)
                        findNavController().popBackStack()
                        return true
                    }
                    else -> {
                        return true
                    }
                }
            }
        },viewLifecycleOwner, Lifecycle.State.RESUMED)

        val binding = FragmentObjectBinding.inflate(inflater, container, false)
        val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        ResourcesCompat.getDrawable(resources, R.drawable.recycler_view_divider,null)?.let{
            dividerItemDecoration.setDrawable(it)
        }
        binding.recyclerView.addItemDecoration(VerticalSpaceItemDecoration(5* requireContext().resources.displayMetrics.density))
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        requireArguments().getString("CategoryName")?.let{
            viewModel.getObjectList(it)
        }

        viewModel.objectListLive.observe(viewLifecycleOwner){
            binding.recyclerView.adapter = ObjectsAdapter(requireContext(),it)
        }





        return binding.root
    }
}