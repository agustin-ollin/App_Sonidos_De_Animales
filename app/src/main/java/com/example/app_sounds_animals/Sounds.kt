package com.example.app_sounds_animals

/**
 * Clase enum que guarda las referencias hacia el contenido de audio de la carpeta raw
 */
enum class Sounds(val sound: Int) {
    CABALLO(R.raw.caballo),
    ELEFANTE(R.raw.elefante),
    GALLO(R.raw.gallo),
    GATO(R.raw.gato),
    MONO(R.raw.mono),
    PATO(R.raw.pato),
    PERRO(R.raw.perro),
    RANA(R.raw.rana),
    VACA(R.raw.vaca)
}