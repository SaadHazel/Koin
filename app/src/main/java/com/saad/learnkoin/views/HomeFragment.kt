package com.saad.learnkoin.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.saad.learnkoin.Mainrepository.MainRepository
import com.saad.learnkoin.R
import com.saad.learnkoin.databinding.FragmentHomeBinding
import com.saad.learnkoin.view_model.MainViewModel
import com.saad.learnkoin.view_model.MainViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = MainRepository(requireContext())

        viewModel = ViewModelProvider(requireActivity(), MainViewModelFactory(repository))[MainViewModel::class.java]
           viewModel.productsData.observe(requireActivity()){
               Log.d("DataOfItem","${it.products}")
           }
    }
}