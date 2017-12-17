package mobiledev.rpm.com.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import mobiledev.rpm.com.R
import mobiledev.rpm.com.databinding.ItemRowBinding
import mobiledev.rpm.com.model.Results

/**
 * Created by renzmanacmol
 */

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductAdapterViewHolder>() {

  private var resultsList: List<Results>? = null

  init {
    this.resultsList = emptyList()
  }

  fun setResultList(resultsList: List<Results>) {
    this.resultsList = resultsList
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapterViewHolder {
    val itemRowBinding = DataBindingUtil
      .inflate<ItemRowBinding>(LayoutInflater.from(parent.context), R.layout.item_row, parent, false)
    return ProductAdapterViewHolder(itemRowBinding)
  }

  override fun onBindViewHolder(holder: ProductAdapterViewHolder, position: Int) {
    holder.bindItem(resultsList!![position])
  }

  override fun getItemCount(): Int {
    return resultsList!!.size
  }

  inner class ProductAdapterViewHolder(internal var mBinding: ItemRowBinding) : RecyclerView.ViewHolder(mBinding.cvProduct) {

    internal fun bindItem(results: Results) {

      mBinding.viewModel = results
      mBinding.executePendingBindings()

      Glide.with(itemView.context).load(results.images[0].url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(mBinding.ivProductImage)

    }
  }
}

