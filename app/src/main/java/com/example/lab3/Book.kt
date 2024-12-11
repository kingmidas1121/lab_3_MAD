package com.example.lab3

data class Book(
    val title: String,
    val genre: String
) : LibraryItem {
    override fun getItemType(): Int = LibraryItem.BOOK_TYPE
}