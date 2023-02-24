package com.example.tsm.responsi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.tsm.responsi.database.VideosDatabase
import com.example.tsm.responsi.database.asDomainModel
import com.example.tsm.responsi.domain.CarModel
import com.example.tsm.responsi.network.CarNetwork
import com.example.tsm.responsi.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

// Kelas Repositori untuk proses menyimpan data dari API ke ROOM DB
class   VideosRepository(private val database: VideosDatabase) {

    // Menginisialisasi list CarModel menjadi hasil mapping dari database
    val videos: LiveData<List<CarModel>> = Transformations.map(database.carDao.getVideos()) {
        it.asDomainModel()
    }

    // Untuk proses refresh data yang disimpan di cache offline
    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            Timber.d("refresh berhasil!")
            val playlist = CarNetwork.devbytes.getPlaylist()
            // Insert data ke database
            database.carDao.insertAll(playlist.asDatabaseModel())
        }
    }

}
