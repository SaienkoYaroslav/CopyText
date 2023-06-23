package com.example.teslistandrandomnamegeneration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teslistandrandomnamegeneration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: AdapterSpin
    val list: List<Names> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setAdapter()

    }

    fun setAdapter() {
        adapter = AdapterSpin()
        binding.rvSpinner.layoutManager = LinearLayoutManager(this)
        binding.rvSpinner.adapter = adapter
        adapter.setList(
            listOf(
                Names("name0", "description0"),
                Names("name1", "description1"),
                Names("name2", "description2"),
                Names("name3", "description3"),
                Names("name4", "description4")
            )
        )
    }


}