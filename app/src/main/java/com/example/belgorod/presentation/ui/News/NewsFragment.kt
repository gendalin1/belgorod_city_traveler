package com.example.belgorod.presentation.ui.News

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belgorod.R
import com.example.belgorod.app.appComponent
import com.example.belgorod.databinding.FragmentNewsBinding
import com.example.belgorod.presentation.Adapters.NewsAdapter
import com.example.belgorod.presentation.Adapters.VerticalSpaceItemDecoration

class NewsFragment : Fragment() {

    private val viewModel: NewsViewModel by viewModels {
        NewsViewModelFactory(
            newsInteractor = requireActivity().appComponent.newsInteractor
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNewsBinding.inflate(inflater, container, false)

        val dividerItemDecoration = DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL)
        ResourcesCompat.getDrawable(resources,R.drawable.recycler_view_divider,null)?.let{
            dividerItemDecoration.setDrawable(it)
        }

        binding.recyclerView.addItemDecoration(VerticalSpaceItemDecoration(5* requireContext().resources.displayMetrics.density))
        binding.recyclerView.addItemDecoration(dividerItemDecoration)

        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = linearLayoutManager


        viewModel.getNewsList(0)
        viewModel.newsListLive.observe(viewLifecycleOwner){
            val adapter = NewsAdapter(context = requireContext(),list = it)
            binding.recyclerView.adapter = adapter
        }


        return binding.root
    }

}