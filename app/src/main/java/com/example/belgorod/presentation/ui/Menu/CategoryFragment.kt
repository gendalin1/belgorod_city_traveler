package com.example.belgorod.presentation.ui.Menu

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belgorod.R
import com.example.belgorod.app.appComponent
import com.example.belgorod.databinding.FragmentCategoryBinding
import com.example.belgorod.presentation.Adapters.CategoryAdapter
import com.example.belgorod.presentation.Adapters.SliderAdapter
import com.example.belgorod.presentation.Adapters.VerticalSpaceItemDecoration

class CategoryFragment : Fragment() {

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
        val binding = FragmentCategoryBinding.inflate(inflater, container, false)

        val imageList = listOf(
            "https://wikiway.com/upload/iblock/e24/Belgorod.jpg",
            "https://traveltimes.ru/wp-content/uploads/2021/09/JCFFqdC-Hvs.jpg",
            "https://bel.cultreg.ru/uploads/b3e417ebf826e69c5d661d04b90fe61c.jpg",
            "https://st.gorodzovet.ru/uploads/ru/2022/8/6/extraphoto1-8988343.jpg"
        )

        binding.imageSlider.setSliderAdapter(SliderAdapter(requireContext(),imageList))

        val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        ResourcesCompat.getDrawable(resources, R.drawable.recycler_view_divider,null)?.let{
            dividerItemDecoration.setDrawable(it)
        }
        binding.recyclerView.addItemDecoration(VerticalSpaceItemDecoration(5* requireContext().resources.displayMetrics.density))
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.getCategoryList()
        viewModel.categoryListLive.observe(viewLifecycleOwner){
            binding.recyclerView.adapter = CategoryAdapter(requireContext(),it,object: OnClickCategory{
                override fun OnClick(category: String) {
                    val bundle = Bundle()
                    bundle.putString("CategoryName", category)
                    findNavController().navigate(R.id.action_navigation_category_to_navigation_object, bundle)

                }
            })
        }


        return binding.root
    }
}