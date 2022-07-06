package com.halimbudiprawira.tokoh_tokohpahlawandiindonesia

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.halimbudiprawira.tokoh_tokohpahlawandiindonesia.adapter.AdapterNamaPahlawan
import com.halimbudiprawira.tokoh_tokohpahlawandiindonesia.databinding.ActivityMainBinding
import com.halimbudiprawira.tokoh_tokohpahlawandiindonesia.model.Pahlawan


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPahlawan = ArrayList<Pahlawan>()
        listPahlawan.add(Pahlawan("Abdul Muis", R.drawable.abdulmuis, "Sungai Puar, Agam,Sumatera Barat", "3 Juli 1883", "17 Juni 1959 di Bandung, Jawa Barat","75 tahun"))
        listPahlawan.add(Pahlawan("Ki Hajar Dewantara", R.drawable.kihajardewantara, "Yogyakarta, Indonesia", "2 Mei 1889", "26 April 1959 di Yogyakarta,Indonesia","69 tahun"))
        listPahlawan.add(Pahlawan("R.M. Surjopranoto", R.drawable.suryopranoto, "Yogyakarta, Indonesia", "11 Januari 1871", "15 Oktober 1959 di Cimahi,Jawa Barat","88 tahun"))
        listPahlawan.add(Pahlawan("Mohammad Hoesni Thamrin", R.drawable.mhusnithamrin, "Weltevreden, Batavia(Jakarta, Indonesia)", "16 Februari 1894", "11 Januari 1941 di Senen,Batavia (Jakarta, Indonesia)","46 tahun"))
        listPahlawan.add(Pahlawan("KH. Samanhudi", R.drawable.hsamanhudi, "Laweyan, Surakarta, Jawa Tengah", "8 Oktober 1868", "28 Desember 1956 di Klaten, Jawa Tengah","78 tahun"))
        listPahlawan.add(Pahlawan("H.O.S. Cokroaminoto", R.drawable.hoscokroaminoto, "Desa Bukur Madiun,Jawa Timur", "16 Agustus 1882", "17 Desember 1934 di Yogyakarta, Indonesia","52 tahun"))
        listPahlawan.add(Pahlawan("Danudirja Setiabudi", R.drawable.danudirjasetiabudi, "Pasuruan, Jawa Timur", "8 Oktober 1879", "28 Agustus 1950 di Bandung,Jawa Barat","70 tahun"))
        listPahlawan.add(Pahlawan("Si Singamangaradja XII", R.drawable.sisingamangaradja12, "Bakkara, Tapanuli,Sumatra Utara", "18 Februari 1849", "17 Juni 1907 di Desa SiOnom Hudon, perbatasan Kabupaten Tapanuli Utara dan Kabupaten Dairi","58 tahun"))
        listPahlawan.add(Pahlawan("Dr. G.S.S.J Ratulangie", R.drawable.drgssjratulangie, "Tondano, Sulawesi Utara", "5 November 1890", "30 Juni 1949 di Jakarta,Indonesia","58 tahun"))
        listPahlawan.add(Pahlawan("DR. Sutomo", R.drawable.drsutomo, "Ngepeh, Loceret, Nganjuk,Jawa Timur", "30 Juli 1888", "30 Mei 1938 di Surabaya,Jawa Timur","49 tahun"))

        binding.list.adapter = AdapterNamaPahlawan(this, listPahlawan, object : AdapterNamaPahlawan.OnClickListener {
            override fun detailData(item: Pahlawan?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_pahlawan)

                    val image =this.findViewById<ImageView>(R.id.image_pahlawan)
                    val nama = this.findViewById<TextView>(R.id.txtnamaPhlawan)

                    val tempatlahir = this.findViewById<TextView>(R.id.txttempatlahir)
                    val tanggallahir = this.findViewById<TextView>(R.id.txttanggallahir)
                    val wafat = this.findViewById<TextView>(R.id.txtwafat)
                    val usia = this.findViewById<TextView>(R.id.txtusia)

                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tanggallahir.text = "${item?.tgllahir}"
                    wafat.text = "${item?.wafat}"
                    usia.text = "${item?.usia}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode : Int) {
        when (selectedMode) {
            R.id.myprofile -> {
                val intent = Intent(this, Profile::class.java)
                startActivity(intent)
            }
        }
    }
}