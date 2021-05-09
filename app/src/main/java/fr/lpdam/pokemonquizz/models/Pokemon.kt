package fr.lpdam.pokemonquizz.models

import java.io.Serializable

data class Pokemon(val id: Int, val name: String, val weight: Int, val height: Int, val sprites: Sprite) : Serializable