package com.eyyuperdogan.learnlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.eyyuperdogan.learnlistview.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private  lateinit var landmarkList:ArrayList<Landmark>

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        landmarkList=ArrayList<Landmark>()
        val eyfel=Landmark("Eyfel","FRANCE",R.drawable.eyfel)
        val collesseum=Landmark("Collesseum","ITALY",R.drawable.collesseum)
        val bridgeLondon=Landmark("Bridge","LONDON",R.drawable.bridge)
        val pissa=Landmark("Pissa","ITALY",R.drawable.pissa)


        landmarkList.add(eyfel)
        landmarkList.add(collesseum)
        landmarkList.add(bridgeLondon)
        landmarkList.add(pissa)

        //Adapter : layaut & Data bağlayıcı

        var adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1, landmarkList.map { landmark -> landmark.name })
        binding.listView.adapter=adapter
        binding.listView.onItemClickListener=AdapterView.OnItemClickListener { parent, view, position, id ->
            val  intent=Intent(MainActivity@this,DetailsActivity::class.java)
            intent.putExtra("landmark", landmarkList.get(position))
            startActivity(intent)
        }

    }

}