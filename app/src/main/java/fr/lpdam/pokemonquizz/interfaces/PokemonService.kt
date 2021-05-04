package fr.lpdam.pokemonquizz.interfaces

import fr.lpdam.pokemonquizz.models.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("/api/v2/pokemon/{id}")
    fun getPokemonFromAPI(@Path("id") id : Int): Call<Pokemon>

}