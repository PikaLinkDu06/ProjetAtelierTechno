package fr.lpdam.pokemonquizz.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import fr.lpdam.pokemonquizz.adapters.PokemonAdapter
import fr.lpdam.pokemonquizz.controllers.PokemonController
import fr.lpdam.pokemonquizz.databinding.ActivityPokedexBinding

class PokedexActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokedexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokedexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = PokemonController.pokemonList.sortedWith(compareBy({ it.id }))
        binding.pokedexRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.pokedexRecyclerView.adapter = PokemonAdapter(items)
    }
}