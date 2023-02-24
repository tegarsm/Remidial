package com.example.tsm.responsi.domain

import com.example.tsm.responsi.util.smartTruncate

// Kelas model untuk menampilkan data yang akan diproses.
// Menentukan properti atau atribut kelas model ini
data class CarModel(val title: String,
                    val description: String,
                    val image_url_tumbnail: String,
                    val date: String,
                    val available_count: String) {

   // trucate kata pada properti description
    val shortDescription: String
        get() = description.smartTruncate(150)
}