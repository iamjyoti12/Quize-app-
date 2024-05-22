package com.my.quizeapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.my.quizeapp.Domain.UserMode
import com.my.quizeapp.databinding.ViewholderBinding

class LeaderAdapter: RecyclerView.Adapter<LeaderAdapter.ViewHolder>() {

     private lateinit var binding: ViewholderBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderAdapter.ViewHolder {
        val  inflater = LayoutInflater.from(parent.context)
        binding= ViewholderBinding.inflate(inflater,parent,false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: LeaderAdapter.ViewHolder, position: Int) {
        val binding = ViewholderBinding.bind(holder.itemView)
        binding.titleTxt.text=differ.currentList[position].name


        val drawableResourceId : Int = binding.root.resources.getIdentifier(
            differ.currentList[position].pic,
            "drawable",binding.root.context.packageName
        )

       Glide.with(binding.root.context)
           .load(drawableResourceId)
           .into(binding.pic)

        binding.rawTxt.text= (position+4).toString()
        binding.score.text = differ.currentList[position].score.toString()

    }

    override fun getItemCount()=differ.currentList.size

        inner class  ViewHolder: RecyclerView.ViewHolder(binding.root)


    private val differCallback = object :DiffUtil.ItemCallback<UserMode>(){
        override fun areItemsTheSame(oldItem: UserMode, newItem: UserMode): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: UserMode, newItem: UserMode): Boolean {
            return  oldItem == newItem
        }
    }
    val differ= AsyncListDiffer(this,differCallback)
}