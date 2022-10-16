package com.eyyuperdogan.learnlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eyyuperdogan.learnlistview.databinding.ActivityDetailsBinding
import com.eyyuperdogan.learnlistview.databinding.ActivityMainBinding
//view binding
private lateinit var binding: ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val intent=getIntent()
        val selectedLendmark=intent.getSerializableExtra("landmark") as Landmark

        binding.textViewName.text=selectedLendmark.name
        binding.textViewCauntryName.text=selectedLendmark.cauntry
        binding.imageView.setImageResource(selectedLendmark.image)

    }
}