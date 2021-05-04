package fr.lpdam.pokemonquizz.controllers

import fr.lpdam.pokemonquizz.models.Pokemon

class PokemonController {

    companion object {

        var pokemonList : ArrayList<Pokemon> = ArrayList<Pokemon>()

        fun addPokemon(pokemon: Pokemon) {
            pokemonList.add(pokemon)
        }
    }

}