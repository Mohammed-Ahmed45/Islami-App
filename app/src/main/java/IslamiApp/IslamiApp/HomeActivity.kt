package IslamiApp.IslamiApp

import IslamiApp.IslamiApp.hadeeth.HadeethFragment
import IslamiApp.IslamiApp.quran.QuranFragment
import IslamiApp.IslamiApp.radio.RadioFragment
import IslamiApp.IslamiApp.tasbeh.TasbehFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mohamed.myapplication.R

class HomeActivity : AppCompatActivity() {


    lateinit var bottomNav:BottomNavigationView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initView()

    }



    private fun initView() {
        bottomNav=findViewById(R.id.navigation_home)

        bottomNav.setOnItemSelectedListener {item->

            when (item.itemId) {
                R.id.nav_quran -> {
                showFragment(QuranFragment())

                }
                R.id.nav_ahadeth -> {
                    showFragment(HadeethFragment())

                }
                R.id.nav_tasbeh -> {
                    showFragment(TasbehFragment())

                }
                R.id.nav_radio -> {
                    showFragment(RadioFragment())

                }
            }
//            if (item.itemId==R.id.nav_quran){
//
//            }
//            else if (item.itemId==R.id.nav_ahadeth){
//
//            }
//            else if (item.itemId==R.id.nav_tasbeh){
//
//            }
//            else if (item.itemId==R.id.nav_radio){
//
//            }

            return@setOnItemSelectedListener true

        }
        bottomNav.selectedItemId=R.id.nav_quran


    }
    fun showFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.islami_fragment_container,fragment)
            .commit()
    }

}