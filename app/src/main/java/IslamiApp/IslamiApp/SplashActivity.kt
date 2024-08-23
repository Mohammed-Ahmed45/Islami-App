package IslamiApp.IslamiApp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.mohamed.myapplication.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash2)
        Handler(Looper.getMainLooper()).postDelayed({startHomeActivity() }, 2000)

    }
    private fun startHomeActivity() {
        var intent= Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()

    }
}