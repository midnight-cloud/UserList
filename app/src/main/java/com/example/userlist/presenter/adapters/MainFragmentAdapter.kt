package com.example.userlist.presenter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.userlist.R
import com.example.userlist.databinding.UserOneItemBinding
import com.example.userlist.domain.trueModels.UserModel

class MainFragmentAdapter :
    ListAdapter<UserModel, MainFragmentAdapter.UserViewHolder>(UserDiffCallback()) {

    var onItemClickListener: ((UserModel) -> Unit)? = null

    class UserViewHolder(private val binding: UserOneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserModel) {
            binding.image.load(item.picture?.medium) {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_background)
                transformations(CircleCropTransformation())
            }
            binding.firstName.text = item.name?.first
            binding.lastName.text = item.name?.last
            binding.gender.text = item.gender
            binding.country.text = item.location?.country
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserOneItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = currentList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(item)
        }
    }
}

class UserDiffCallback: DiffUtil.ItemCallback<UserModel>() {
    override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem == newItem
    }

}