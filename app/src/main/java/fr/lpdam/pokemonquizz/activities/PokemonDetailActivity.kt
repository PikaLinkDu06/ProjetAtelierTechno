package fr.lpdam.pokemonquizz.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import fr.lpdam.pokemonquizz.databinding.ActivityPokemonDetailBinding
import fr.lpdam.pokemonquizz.models.Pokemon

class PokemonDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonDetailBinding
    private lateinit var selectedPokemon : Pokemon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        selectedPokemon = intent.getSerializableExtra("selectedPokemon") as Pokemon

        binding.pokemonDetailName.text = selectedPokemon.name
        Picasso.get().load(selectedPokemon.sprites.front_default).into(binding.pokemonDetailImage)
        binding.pokemonDetailId.text = "%03d".format(selectedPokemon.id)
        binding.pokemonDetailHeight.text = "" + selectedPokemon.height
        binding.pokemonDetailWeight.text = "" + selectedPokemon.weight
    }
}