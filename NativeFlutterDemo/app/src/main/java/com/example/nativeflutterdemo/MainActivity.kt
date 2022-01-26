package com.example.nativeflutterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.idlefish.flutterboost.FlutterBoost

import com.idlefish.flutterboost.FlutterBoostRouteOptions




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val  btn=findViewById<TextView>(R.id.btn)
        btn.setOnClickListener {
            val options = FlutterBoostRouteOptions.Builder()
                .pageName("mainPage")
                .arguments(HashMap())
                .requestCode(1111)
                .build()
            FlutterBoost.instance().open(options)
        }
    }
}