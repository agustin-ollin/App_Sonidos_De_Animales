package com.example.app_sounds_animals

import android.content.Context
import android.media.MediaPlayer

/**
 * Lista de elementos de enums
 */
val list = arrayOf(Sounds.CABALLO, Sounds.ELEFANTE, Sounds.GALLO, Sounds.GATO, Sounds.MONO, Sounds.PATO, Sounds.PERRO, Sounds.RANA, Sounds.VACA)
val listMediaPlayer: MutableList<MediaPlayer> = mutableListOf()

fun stereo(i: Int){
    for (a in list.indices){
        if (i == a){
            listMediaPlayer[i].start()
            listMediaPlayer[i].isLooping = false
        } else {
            if (listMediaPlayer[i].isPlaying){
                listMediaPlayer[i].stop()
                listMediaPlayer[i].release()
            }
        }
    }
}

fun addMediaPlayer(indice: Int,context: Context){
    for (i in 0..5){
        var a: MediaPlayer = MediaPlayer.create(context, list[i].sound)
        listMediaPlayer.add(i, a)
    }

    stereo(indice)
}