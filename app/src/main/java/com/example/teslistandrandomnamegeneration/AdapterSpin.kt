package com.example.teslistandrandomnamegeneration

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.teslistandrandomnamegeneration.databinding.ItemSpinerBinding

class AdapterSpin : RecyclerView.Adapter<AdapterSpin.ViewHolder>() {

    var listNames = listOf<Names>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSpinerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = listNames[position]
        holder.binding.tvTitle.text = name.name
        holder.binding.tvDescription.text = name.description
    }

    override fun getItemCount(): Int {
        return listNames.size
    }

    fun setList(list: List<Names>) {
        listNames = list
    }


    inner class ViewHolder(val binding: ItemSpinerBinding) : RecyclerView.ViewHolder(binding.root) {

        var isOpen = false
        val clipBoard =
            binding.root.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager


        init {

            binding.buttonSpin.setOnClickListener {
                if (!isOpen) {
                    binding.layoutDescription.visibility = View.VISIBLE
                    isOpen = true
                    binding.buttonSpin.rotation = 180f
                } else {
                    binding.layoutDescription.visibility = View.GONE
                    isOpen = false
                    binding.buttonSpin.rotation = 360F
                }

                binding.btnCopy.setOnClickListener {
                    val clip = ClipData.newPlainText("label", binding.tvDescription.text)
                    clipBoard.setPrimaryClip(clip)
                    Toast.makeText(binding.root.context, "Copied", Toast.LENGTH_SHORT).show()
                }

            }

        }

    }

}

