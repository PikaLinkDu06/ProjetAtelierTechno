package fr.lpdam.pokemonquizz.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import fr.lpdam.pokemonquizz.R
import fr.lpdam.pokemonquizz.controllers.PokemonController
import fr.lpdam.pokemonquizz.interfaces.PokemonService
import fr.lpdam.pokemonquizz.models.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val retro = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val service = retro.create(PokemonService::class.java)
        for(i in 1..151) {
            val pokemonRequest = service.getPokemonFromAPI(i)
            pokemonRequest.enqueue(object : Callback<Pokemon> {
                override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                    if(response.isSuccessful) {
                        var pokemonResponse = response.body()!!
                        PokemonController.addPokemon(pokemonResponse)
                    }
                    if(i == 151) {
                     val intent = Intent(this@SplashScreenActivity, PokedexActivity::class.java)
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                    Log.i(SplashScreenActivity::class.simpleName, "on FAILURE!!!!")
                }
            })
        }
    }

    companion object {
        const val API_URL = "https://pokeapi.co/"
    }
}