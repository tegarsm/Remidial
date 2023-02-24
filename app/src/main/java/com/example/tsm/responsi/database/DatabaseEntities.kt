package com.example.tsm.responsi.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tsm.responsi.domain.CarModel

// Kelas Entitas untuk Room Database.
// Untuk merepresentasikan entitas pada database
@Entity
data class DatabaseVideo constructor(
        @PrimaryKey
        val title: String,
        val description: String,
        val image_url_tumbnail: String,
        val date: String,
        val available_count: String)


// Mengembalikan mapping Database terhadap Kelas Model
fun List<DatabaseVideo>.asDomainModel(): List<CarModel> {
        return map {
                CarModel(
                        title = it.title,
                        description = it.description,
                        image_url_tumbnail = it.image_url_tumbnail,
                        date = it.date,
                        available_count = it.available_count)
        }
}
