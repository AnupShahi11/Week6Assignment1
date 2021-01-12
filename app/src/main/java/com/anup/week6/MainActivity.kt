package com.anup.week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.anup.week6.fragments.AboutFragment
import com.anup.week6.fragments.AddFragment
import com.anup.week6.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation = findViewById(R.id.bottomNavigation)

        val firstFragment = HomeFragment()
        val secondFragment = AddFragment()
        val thirdFragment = AboutFragment()
        setCurrentFragment(firstFragment)


        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.idHome -> setCurrentFragment(firstFragment)
                R.id.idAdd -> setCurrentFragment(secondFragment)
                R.id.idAbout -> setCurrentFragment(thirdFragment)
            }
            true
        }








    }
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.linearContainer,fragment)
            commit()
        }

}


