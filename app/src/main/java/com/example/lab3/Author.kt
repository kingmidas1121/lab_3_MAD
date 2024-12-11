package com.example.lab3

data class Author(
    val name: String,
    val biography: String
) : LibraryItem {
    override fun getItemType(): Int = LibraryItem.AUTHOR_TYPE
}

