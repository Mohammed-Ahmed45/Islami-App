package IslamiApp.IslamiApp.hadeeth


import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.IntentCompat
import com.mohamed.myapplication.R
import com.mohamed.myapplication.databinding.ActivityHadeethChapterDetalisBinding

class HadeethChapterDetalisActivity : AppCompatActivity()
{
    lateinit var Hadeth:HadeethContant
    lateinit var binding:ActivityHadeethChapterDetalisBinding
    lateinit var Adabter:HadeethDetailsAdabter
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

        Hadeth= IntentCompat.getParcelableExtra(intent, Extra_hadeth,HadeethContant::class.java)!!
    }



    private fun initView()
    {
        binding.hadeethTitle.text=Hadeth.title
        binding.content.text=Hadeth.content

//

    }


//    private fun readContent()
//    {
//        val allFileContent=assets.open("${ChapterPosition+1}.txt")
//            .bufferedReader().use {it.readText()}
//        val splitFile= allFileContent.split("\n")
//        Log.e("hadeeth ",splitFile.toString())
//    }
//
//    // to working back
//    override fun onSupportNavigateUp(): Boolean
//    {
//        finish()
//        return true
//    }
//
//    private fun initView()
//    {
//        ChapterPosition=intent.getIntExtra(Extra_position,-1)
//        ChapterTitle=intent.getStringExtra(Extra_Title)?:""
//
//    }
//
//
//    private fun secondView()
//    {
//        // to show back bar
//        val toolbar:Toolbar=findViewById(R.id.hadeeth_toolbar)
//        setSupportActionBar(toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setDisplayShowHomeEnabled(true)
//        title=null
//
//        tvTitle=findViewById(R.id.hadeeth_title)
//        tvTitle.text = ChapterTitle
//    }



    companion object{
        const val Extra_hadeth="hadeth"
    }


//    companion object{ //static
//        const val  Extra_position="position"
//        const val  Extra_Title="title"
//
//
//
//
//    }
}