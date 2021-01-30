package com.elyeproj.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_f1.setOnClickListener {
            addFragment(OneFragment(),  "OneFragment")
        }

        replace_f1.setOnClickListener {
            replaceFragment(OneFragment(),  "OneFragment")
        }

        add_f2.setOnClickListener {
            addFragment(TwoFragment(),  "TwoFragment")
        }

        replace_f2.setOnClickListener {
            replaceFragment(TwoFragment(),  "TwoFragment")
        }

        add_f3.setOnClickListener {
            addFragment(ThreeFragment(),  "ThreeFragment")
        }

        replace_f3.setOnClickListener {
            replaceFragment(ThreeFragment(),  "ThreeFragment")
        }

        add_f4.setOnClickListener {
            addFragment(FourFragment(),  "FourFragment")
        }

        replace_f4.setOnClickListener {
            replaceFragment(FourFragment(),  "FourFragment")
        }
    }

    private fun addFragment(fragment: Fragment, name: String) {
        supportFragmentManager.beginTransaction().add(R.id.container, fragment, name)
                .addToBackStack(name).commit()
    }

    private fun replaceFragment(fragment: Fragment, name: String) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment, name)
                .addToBackStack(name).commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
        } else {
            super.onBackPressed()
        }
    }
}
