package com.example.app_sounds_animals

import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils

/**
 * Activity para reproducir los sonidos de los animales
 */
class SecondActivity : AppCompatActivity() {
    lateinit var sound: MediaPlayer
    lateinit var list: List<Sounds>
    lateinit var listMediaPlayer: MutableList<MediaPlayer>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_second)

        inicializarListas()
        addMediaPlayer()
    }

    /**
     * Función para inicializar Listas
     */
    fun inicializarListas(){
        list = arrayOf(Sounds.CABALLO, Sounds.ELEFANTE, Sounds.GALLO, Sounds.GATO, Sounds.MONO, Sounds.PATO, Sounds.PERRO, Sounds.RANA, Sounds.VACA).toList()
        listMediaPlayer = mutableListOf()
    }

    /**
     * Instancia los elementos MediaPlayer a una MutableList
     */
    fun addMediaPlayer(){
        for (i in 0..8){
            var a: MediaPlayer = MediaPlayer.create(this, list[i].sound)
            listMediaPlayer.add(i, a)
        }
    }

    /**
     * Función para asignar evento a un view
     */
    fun reproducir(view: View) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.click_event))
        selectView(view)
    }

    /**
     * Función para seleccionar de acuerdo a la descripción de un view el tipo de sonido que será reproducido
     */
    fun selectView(view: View){
        when(view.contentDescription){
            "caballo" -> openSound(0)
            "elefante" -> openSound(1)
            "gallo" -> openSound(2)
            "gato" -> openSound(3)
            "mono" -> openSound(4)
            "pato" -> openSound(5)
            "perro" -> openSound(6)
            "rana" -> openSound(7)
            "vaca" -> openSound(8)
            else -> println("ERROR")
        }
    }

    /**
     * Función para crear elemento mediaplayer a reproducir
     */
    fun openSound(i: Int){
        if (!listMediaPlayer[i].isPlaying){
            for (a in listMediaPlayer.indices){
                if (a != i && listMediaPlayer[a].isPlaying) {
                    listMediaPlayer[a].stop()
                    listMediaPlayer[a].prepare()
                }
            }
            listMediaPlayer[i].start()
        } else {
            listMediaPlayer[i].stop()
            listMediaPlayer[i].prepare()
        }
    }
}