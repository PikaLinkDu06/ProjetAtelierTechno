package fr.lpdam.pokemonquizz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import fr.lpdam.pokemonquizz.R
import fr.lpdam.pokemonquizz.controllers.PokemonController
import fr.lpdam.pokemonquizz.models.Pokemon

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}