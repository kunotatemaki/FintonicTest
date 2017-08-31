package com.rukiasoft.fintonictest.sheroeslist.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rukiasoft.fintonictest.R

class SuperHeroListActivity : AppCompatActivity(), SuperHeroListView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
