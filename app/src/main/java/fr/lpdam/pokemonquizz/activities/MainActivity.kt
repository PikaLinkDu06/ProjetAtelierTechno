package fr.lpdam.pokemonquizz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import fr.lpdam.pokemonquizz.R
import fr.lpdam.pokemonquizz.controllers.PokemonController
import fr.lpdam.pokemonquizz.databinding.ActivityMainBinding
import fr.lpdam.pokemonquizz.models.Pokemon

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.jeu.setOnClickListener {  }
        binding.poke.setOnClickListener {  }
    }
}