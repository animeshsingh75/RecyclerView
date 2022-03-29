package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import android.widget.Toast




class MainActivity : AppCompatActivity(),RecyclerViewAdapter.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list= mutableListOf<Model>()
        list.add(Model(1,"A"))
        list.add(Model(2,"B"))
        list.add(Model(3,"C"))
        list.add(Model(4,"D"))
        list.add(Model(5,"E"))

        val adapter=RecyclerViewAdapter(list,this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter=adapter
        binding.button.setOnClickListener{
            val models: ArrayList<Model> = ArrayList()

            for (model in list) {
                models.add(model)
            }
            models.add(Model(6, "N"))
            models.add(Model(7, "R"))
            adapter.setData(models)

        }

    }

    override fun onClick(position: Int) {
        Toast.makeText(this, "CLICKED $position", Toast.LENGTH_SHORT).show()
    }

}