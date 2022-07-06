package com.halimbudiprawira.tokoh_tokohpahlawandiindonesia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.halimbudiprawira.tokoh_tokohpahlawandiindonesia.databinding.ListPahlawanBinding
import com.halimbudiprawira.tokoh_tokohpahlawandiindonesia.model.Pahlawan


class AdapterNamaPahlawan(private val context: Context,
                          private var data: List<Pahlawan>?,
                          private val itemclick: OnClickListener)
                          : RecyclerView.Adapter<AdapterNamaPahlawan.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListPahlawanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama

        holder.itemView.setOnClickListener {
            itemclick.detailData(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?: 0

    inner class ViewHolder(val binding: ListPahlawanBinding): RecyclerView.ViewHolder(binding.root) {
        var foto = binding.image
        var nama = binding.txtnama
    }
    interface OnClickListener {
        fun detailData(item : Pahlawan?)
    }
}
