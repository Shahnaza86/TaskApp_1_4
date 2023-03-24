package com.example.taskapp_1_4.ui.onBoard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskapp_1_4.databinding.ItemOnboardingBinding
import com.example.taskapp_1_4.ext.loadImage
import com.example.taskapp_1_4.model.OnBoard


class OnBoardingAdapter(private val onClick:()->Unit,
                        private val onNextClick:()->Unit)
:Adapter<OnBoardingAdapter.OnBordingViewHolder> (){
private val data = arrayListOf<OnBoard>(
   OnBoard("https://toggl.com/blog/wp-content/uploads/2018/09/project-task-list.jpg","Task Manager1","Task Manager description"),
   OnBoard("https://flow-e.com/wp-content/uploads/bfi_thumb/Google-task-list-379tmv50jkyo35v5zqpoui.png","Task Manager2","Task Manager description"),
   OnBoard("https://images.ctfassets.net/rz1oowkt5gyp/1IgVe0tV9yDjWtp68dAZJq/36ca564d33306d407dabe39c33322dd9/TaskManagement-hero.png","Task Manager3","Task Manager description")
)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBordingViewHolder {
        return OnBordingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: OnBordingViewHolder, position: Int) {
        holder.bind(data[position])
    }
    override fun getItemCount(): Int =data.size




    inner class OnBordingViewHolder(private val binding:ItemOnboardingBinding):
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.tvTitle.text=onBoard.title
            binding.tvDesc.text=onBoard.description
binding.ivBoard.loadImage(onBoard.image)
            binding.scip.isVisible=adapterPosition!=2
            binding.start.isVisible=adapterPosition==2
            binding.next.isVisible=adapterPosition!=2
            binding.scip.setOnClickListener { onClick() }
            binding.start.setOnClickListener { onClick() }
            binding.next.setOnClickListener { onNextClick ()}
        }
    }
}

