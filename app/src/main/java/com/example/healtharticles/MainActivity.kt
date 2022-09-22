package com.example.healtharticles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.healtharticles.HealthArticlesFragment
import com.example.healtharticles.MeasureFragment
import com.example.healtharticles.OrgansArticlesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.random.Random

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private val healthArticlesFragment = HealthArticlesFragment()
    private val organsArticlesFragment = OrgansArticlesFragment()
    private val measureFragment = MeasureFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigation.setOnNavigationItemSelectedListener() {
            when(it.itemId){
                R.id.healthArticlesFragment -> replaceFragment(healthArticlesFragment)
                R.id.organsArticlesFragment -> replaceFragment(organsArticlesFragment)
                R.id.measureFragment -> replaceFragment(measureFragment)
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        if(fragment!=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, fragment)
            transaction.commit()
        }
    }
}