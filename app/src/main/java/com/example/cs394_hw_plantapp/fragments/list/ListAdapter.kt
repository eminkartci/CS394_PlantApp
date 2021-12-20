package com.example.cs394_hw_plantapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cs394_hw_plantapp.R
import com.example.cs394_hw_plantapp.data.Plant
import kotlinx.android.synthetic.main.plant_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var plantList = emptyList<Plant>();

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.plant_row,parent,false));
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPlant = plantList[position]

        holder.itemView.plant_id.text = currentPlant.id.toString()
        holder.itemView.plant_name.text = currentPlant.name
        holder.itemView.plant_sName.text = currentPlant.scientific_name
        holder.itemView.plant_fName.text = currentPlant.family_name



    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    fun setData(plantList: List<Plant>){
       this.plantList = plantList
        notifyDataSetChanged()
    }
}