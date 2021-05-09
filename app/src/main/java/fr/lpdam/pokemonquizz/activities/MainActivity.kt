package fr.lpdam.pokemonquizz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.lpdam.pokemonquizz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playButton.setOnClickListener {
            val intent = Intent(binding.root.context, PokeQuizzActivity::class.java)
            startActivity(intent)
        }
        binding.pokedexButton.setOnClickListener {
            val intent = Intent(binding.root.context, PokedexActivity::class.java)
            startActivity(intent)
        }
    }
}