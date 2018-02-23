package com.elyeproj.myapplication


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_top.*

class TopFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_top, container, false)

        setHasOptionsMenu(true)
        //(activity as AppCompatActivity).setSupportActionBar(toolbar_actionbar)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        childFragmentManager.beginTransaction().add(R.id.container, fragment)
                .addToBackStack(name).commitAllowingStateLoss()
    }

    private fun replaceFragment(fragment: Fragment, name: String) {
        childFragmentManager.beginTransaction().replace(R.id.container, fragment)
                .addToBackStack(name).commitAllowingStateLoss()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            activity?.onBackPressed()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    fun onBackPressed() : Boolean {
        if (childFragmentManager.backStackEntryCount > 0) {
            childFragmentManager.popBackStackImmediate()
            return true
        }

        return false
    }

}// Required empty public constructor
