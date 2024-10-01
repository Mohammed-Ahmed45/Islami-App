package IslamiApp.IslamiApp.hadeeth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.IntentCompat
import com.mohamed.myapplication.databinding.ActivityHadeethChapterDetalisBinding

class HadeethChapterDetalisActivity : AppCompatActivity()
{
    lateinit var Hadeth: HadeethContant
    lateinit var binding:ActivityHadeethChapterDetalisBinding


    override fun onCreate(savedInstanceState: Bundle?)
    {
        binding= ActivityHadeethChapterDetalisBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        readHAdeethChapterDetalis()
        initView()

    }
     //to working back
    override fun onSupportNavigateUp(): Boolean
    {
        finish()
        return true
    }

    private fun readHAdeethChapterDetalis()
    {
        // to show back bar
        val toolbar: Toolbar =binding.hadeethToolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title=null

        Hadeth = IntentCompat.getParcelableExtra(intent, Extra_hadeth, HadeethContant::class.java)!!
    }



    private fun initView()
    {

        binding.hadeethTitle.text=Hadeth.title
        binding.content.text=Hadeth.content
    }
    companion object{
        const val Extra_hadeth="hadeth"
    }
}