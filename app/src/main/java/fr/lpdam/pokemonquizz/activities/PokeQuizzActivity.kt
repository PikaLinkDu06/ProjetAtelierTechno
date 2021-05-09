package fr.lpdam.pokemonquizz.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import fr.lpdam.pokemonquizz.R
import fr.lpdam.pokemonquizz.controllers.PokemonController
import fr.lpdam.pokemonquizz.databinding.ActivityPokeQuizzBinding
import fr.lpdam.pokemonquizz.models.Pokemon
import kotlin.random.Random

class PokeQuizzActivity: AppCompatActivity() {

    private lateinit var binding: ActivityPokeQuizzBinding
    private lateinit var currentPokemon: Pokemon
    private lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokeQuizzBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("pokemon_captured", Context.MODE_PRIVATE)

        selectRandomPokemon()

        binding.goBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.confirmAnswer.setOnClickListener {
            var userAnswer = binding.userAnswer.text.toString().toLowerCase()
            if(userAnswer != "") {
                if(userAnswer == currentPokemon.name.toLowerCase()) {
                    Toast.makeText(it.context, R.string.pokemon_found, Toast.LENGTH_SHORT).show()
                    var editor = sharedPref.edit()
                    editor.putBoolean("pokemon_captured_" + currentPokemon.id, true)
                    editor.commit()
                } else {
                    Toast.makeText(it.context, R.string.pokemon_not_found, Toast.LENGTH_SHORT).show()
                }
                binding.userAnswer.setText("")
                selectRandomPokemon()
            }
            else {
                Toast.makeText(it.context, R.string.pokemon_name_needed, Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun selectRandomPokemon() {
        val nextPokemon = Random.nextInt(0, PokemonController.pokemonList.size)
        currentPokemon = PokemonController.pokemonList.get(nextPokemon)
        displayPokemon()
    }

    fun displayPokemon(){
        Picasso.get().load(currentPokemon.sprites.front_default).into(binding.picturePokeQuizz)
    }
}