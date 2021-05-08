package fr.lpdam.pokemonquizz.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.lpdam.pokemonquizz.databinding.ItemPokemonBinding
import fr.lpdam.pokemonquizz.models.Pokemon

class PokemonAdapter(val items: Array<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindPokemon(pokemon: Pokemon) {

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