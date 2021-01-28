package com.androidfactory.epl

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class SoccerTileAdapter(
    private val data: ArrayList<SoccerTile>,
    private val soccerTileInterface: SoccerTileInterface
): RecyclerView.Adapter<SoccerTileAdapter.SoccerTileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoccerTileViewHolder {
        return SoccerTileViewHolder(parent)
    }

    override fun onBindViewHolder(holder: SoccerTileViewHolder, position: Int) {
        holder.onBind(data[position], soccerTileInterface)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class SoccerTileViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_soccer_tile, parent, false)
    ) {

        private val headerImageView: ImageView = itemView.findViewById(R.id.teamHeaderImageView)
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        private val button: MaterialButton = itemView.findViewById(R.id.button)
        private val favoriteImageView: AppCompatImageView = itemView.findViewById(R.id.favoriteImageView)

        fun onBind(soccerTile: SoccerTile, soccerTileInterface: SoccerTileInterface) {
            headerImageView.setImageResource(soccerTile.headerImageResId)
            titleTextView.text = soccerTile.title
            descriptionTextView.text = soccerTile.description

            button.setOnClickListener {
                soccerTileInterface.onLearnMoreButtonClicked(adapterPosition)
            }

            val icon = if (soccerTile.isFavorite) R.drawable.ic_favorite_24dp else R.drawable.ic_favorite_outline_24dp
            favoriteImageView.setImageResource(icon)
            favoriteImageView.setOnClickListener {
                soccerTileInterface.onFavoriteClicked(adapterPosition)
            }
        }
    }
}