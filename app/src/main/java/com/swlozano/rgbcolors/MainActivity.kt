package com.swlozano.rgbcolors

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListeners()
    }

    private fun setupListeners() {
        findViewById<MaterialButton>(R.id.color_creator_button).setOnClickListener {
            val color = getColorToDisplay()
            setColorOnPanel(color)
        }
    }

    private fun setColorOnPanel(color: String) {
        try {
            val colorAsInt = Color.parseColor(color)
            findViewById<View>(R.id.view_panel_color)?.setBackgroundColor(colorAsInt)
        } catch (e: IllegalArgumentException) {
            val errorMessage = getString(R.string.invalid_error_message, color)
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
        }

    }

    private fun getColorToDisplay(): String {
        val redTxt = findViewById<TextInputEditText>(R.id.red_channel)?.text.toString()
        val greenTxt = findViewById<TextInputEditText>(R.id.green_channel)?.text.toString()
        val blueTxt = findViewById<TextInputEditText>(R.id.blue_channel)?.text.toString()
        return "#$redTxt$greenTxt$blueTxt"
    }
}