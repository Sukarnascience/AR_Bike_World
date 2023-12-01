package com.example.arbikeworld

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ARViewActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arview)

        // Retrieve the clicked button information from the intent
        val whichProduct = intent.getStringExtra("productName")

        val fab: FloatingActionButton = findViewById(R.id.productInfoBtn)
        fab.setOnClickListener {
            var webPageUrl: String = ""

            when (whichProduct) {
                "Bike01" -> webPageUrl = "https://www.yamaha-motor-india.com/yamaha-r15v4.html"
                "Bike02" -> webPageUrl = "https://www.yamaha-motor-india.com/yamaha-fzs-fi-v4.html"
                "Bike03" -> webPageUrl = "https://www.yamaha-motor-india.com/yamaha-mt-15-v2.html"
                "Scooter01" -> webPageUrl = "https://www.yamaha-motor-india.com/yamaha-fascino125fi-new.html"
                "Scooter02" -> webPageUrl = "https://www.yamaha-motor-india.com/yamaha-ray-zrstreetrally125fihybrid.html"
                "Scooter03" -> webPageUrl = "https://www.yamaha-motor-india.com/yamaha-ray-zr125fihybrid.html"
                else -> webPageUrl = "https://www.yamaha-motor-india.com/"
            }

            openWebView(webPageUrl)
        }
    }

    private fun openWebView(url: String) {
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("URL", url)
        startActivity(intent)
    }
}