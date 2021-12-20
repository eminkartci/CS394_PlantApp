package com.example.cs394_hw_plantapp.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cs394_hw_plantapp.R
import com.example.cs394_hw_plantapp.data.PlantViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    private lateinit var mPlantViewModel: PlantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Recyclerview
        val adapter = ListAdapter()
        val rv_plants = view.rv_plants
        rv_plants.adapter = adapter

        rv_plants.layoutManager = LinearLayoutManager(requireContext())

        // User ViewModel
        mPlantViewModel = ViewModelProvider(this).get(PlantViewModel::class.java)
        mPlantViewModel.readAllData.observe(viewLifecycleOwner, Observer{ plant_list ->
            adapter.setData(plant_list)
        })


        view.floatingActionButton2.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return view
    }


}