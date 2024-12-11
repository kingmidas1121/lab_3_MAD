package com.example.lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.ui.theme.Lab3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val testData = generateTestData()

        val adapter = DataAdapter(testData)

        recyclerView.adapter = adapter
    }

    private fun generateTestData(): List<LibraryItem> {
        return listOf(
            Book("The Great Gatsby", "Classic Fiction"),
            Author("F. Scott Fitzgerald", "An American novelist and short story writer."),
            Book("To Kill a Mockingbird", "Historical Fiction"),
            Author("Harper Lee", "Famous for her novel \"To Kill a Mockingbird\".")
        )
    }
}
