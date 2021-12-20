package com.example.cs394_hw_plantapp.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.cs394_hw_plantapp.R
import com.example.cs394_hw_plantapp.data.Plant
import com.example.cs394_hw_plantapp.data.PlantViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mPlantViewModel: PlantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_add, container, false)
        mPlantViewModel = ViewModelProvider(this).get(PlantViewModel::class.java)
        view.btn_add.setOnClickListener{
            insert2database()
        }

        return view
    }

    private fun insert2database(){
        val plant_name = et_plant_name.text.toString()
        val scientific_name = et_scientific_name.text.toString()
        val family_name = et_family_name.text.toString()

        if(areValid(plant_name,scientific_name,family_name)){

            val newPlant = Plant(0,plant_name,family_name,scientific_name,1);

            mPlantViewModel.addPlant(newPlant)
            Toast.makeText(requireContext(),"Successfully Added!",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireContext(),"Error on Insert!",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
    }

    private fun areValid(pName:String,sName:String,fName:String):Boolean{
        return !(TextUtils.isEmpty(pName) && TextUtils.isEmpty(sName) && TextUtils.isEmpty(fName))
    }


}