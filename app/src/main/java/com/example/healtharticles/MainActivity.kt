package com.example.healtharticles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private val healthArticlesFragment = HealthArticlesFragment()
    private val organsArticlesFragment = OrgansArticlesFragment()
    private val measureFragment = MeasureFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.healthArticlesFragment -> replaceFragment(healthArticlesFragment)
                R.id.organsArticlesFragment -> replaceFragment(organsArticlesFragment)
                R.id.measureFragment -> replaceFragment(measureFragment)
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, fragment)
        transaction.commit()
    }
}