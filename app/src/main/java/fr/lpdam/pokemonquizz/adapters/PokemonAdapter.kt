package fr.lpdam.pokemonquizz.adapters

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.lpdam.pokemonquizz.R
import fr.lpdam.pokemonquizz.activities.PokemonDetailActivity
import fr.lpdam.pokemonquizz.databinding.ItemPokemonBinding
import fr.lpdam.pokemonquizz.models.Pokemon

class PokemonAdapter(val items: List<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {
        val sharedPref : SharedPreferences = binding.root.context.getSharedPreferences("pokemon_captured", Context.MODE_PRIVATE)
        fun bindPokemon(pokemon: Pokemon) {
            with(pokemon){
                var isPokemonCaptured = sharedPref.getBoolean("pokemon_captured_" + pokemon.id, false)
                //if(isPokemonCaptured){
                    binding.pokemonName.text = pokemon.name!!.capitalize()
                    Picasso.get().load(pokemon.sprites.front_default).into(binding.image)
                    binding.pokemonItem.setOnClickListener {
                        val intent = Intent(binding.root.context, PokemonDetailActivity::class.java)
                        intent.putExtra("selectedPokemon", pokemon)
                        binding.root.context.startActivity(intent)
                   }
               /* } else{
                    binding.pokemonName.text = "???"
                    binding.image.setImageResource(R.drawable.inconnu);
                }*/
                binding.idPokemon.text = "#" + "%03d".format(pokemon.id)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPokemon(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size
}