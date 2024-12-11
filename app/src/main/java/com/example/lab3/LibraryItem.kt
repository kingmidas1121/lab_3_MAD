package com.example.lab3

interface LibraryItem {
    fun getItemType(): Int

    companion object {
        const val BOOK_TYPE = 1
        const val AUTHOR_TYPE = 2
    }
}
