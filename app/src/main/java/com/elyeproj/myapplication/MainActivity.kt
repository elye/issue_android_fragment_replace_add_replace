package com.elyeproj.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, TopFragment()).commitAllowingStateLoss()
    }

    override fun onBackPressed() {
        if (!(supportFragmentManager.findFragmentById(R.id.container) as TopFragment).onBackPressed()) {
            super.onBackPressed()
        }
    }
}
