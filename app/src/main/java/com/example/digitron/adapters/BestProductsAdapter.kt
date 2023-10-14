package com.example.digitron.adapters

import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.digitron.data.Product
import com.example.digitron.databinding.ProductRvItemBinding
import com.example.digitron.helper.getProductPrice

class BestProductsAdapter : RecyclerView.Adapter<BestProductsAdapter.BestProductsViewHolder>() {

    inner class BestProductsViewHolder(private val binding: ProductRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.apply {
                val priceAfterOffer = product.offerPercentage.getProductPrice(product.price)
                tvNewPrice.text = "Rs. ${String.format("%.2f", priceAfterOffer)}"

                // Check if the product has an offer and the offer is not equal to 0
                if (product.offerPercentage != null && product.offerPercentage?.toInt() != 0) {
                    tvPrice.paintFlags = tvPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    tvPrice.setTextColor(Color.BLUE)
                    tvNewPrice.visibility = View.VISIBLE
                } else {
                    // If there is no offer or the offer is 0, remove the strike-through and make it not blue
                    tvPrice.paintFlags = tvPrice.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                    tvPrice.setTextColor(Color.BLACK) // Change this to the desired non-blue color
                    tvNewPrice.visibility = View.INVISIBLE
                }

                Glide.with(itemView).load(product.images[0]).into(imgProduct)
                tvPrice.text = "Rs. ${product.price}"
                tvName.text = product.name
            }
        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestProductsViewHolder {
        return BestProductsViewHolder(
            ProductRvItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: BestProductsViewHolder, position: Int) {
        val product = differ.currentList[position]
        holder.bind(product)

        holder.itemView.setOnClickListener {
            onClick?.invoke(product)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    var onClick: ((Product) -> Unit)? = null
}
