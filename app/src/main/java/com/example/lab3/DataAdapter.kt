package com.example.lab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(private val items: List<LibraryItem>) : RecyclerView.Adapter<DataAdapter.LibraryViewHolder>() {

    abstract class LibraryViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: LibraryItem)
    }

    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): LibraryViewHolder {
        val inflater = android.view.LayoutInflater.from(parent.context)
        return when (viewType) {
            LibraryItem.BOOK_TYPE -> {
                val view = inflater.inflate(R.layout.item_book, parent, false)
                BookViewHolder(view)
            }
            LibraryItem.AUTHOR_TYPE -> {
                val view = inflater.inflate(R.layout.item_author, parent, false)
                AuthorViewHolder(view)
            }
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemViewType(position: Int): Int = items[position].getItemType()

    override fun getItemCount(): Int = items.size
    class BookViewHolder(itemView: android.view.View) : LibraryViewHolder(itemView) {
        private val titleTextView: android.widget.TextView = itemView.findViewById(R.id.bookTitleTextView)
        private val genreTextView: android.widget.TextView = itemView.findViewById(R.id.bookGenreTextView)
        private val bookIconImageView: android.widget.ImageView = itemView.findViewById(R.id.bookIconImageView)

        override fun bind(item: LibraryItem) {
            if (item is Book) {
                titleTextView.text = item.title
                genreTextView.text = item.genre
                bookIconImageView.setImageResource(R.drawable.ic_book) // Змініть ресурс на ваш
            }
        }
    }


    // ViewHolder for Author
    class AuthorViewHolder(itemView: android.view.View) : LibraryViewHolder(itemView) {
        private val nameTextView: android.widget.TextView = itemView.findViewById(R.id.authorNameTextView)
        private val bioTextView: android.widget.TextView = itemView.findViewById(R.id.authorBioTextView)
        private val authorIconImageView: android.widget.ImageView = itemView.findViewById(R.id.authorIconImageView)

        override fun bind(item: LibraryItem) {
            if (item is Author) {
                nameTextView.text = item.name
                bioTextView.text = item.biography
                authorIconImageView.setImageResource(R.drawable.ic_author) // Set your author icon resource
            }
        }
    }
}