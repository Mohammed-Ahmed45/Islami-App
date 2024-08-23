package IslamiApp.IslamiApp.quran

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.mohamed.myapplication.R
import com.mohamed.myapplication.databinding.ActivityQuranChapterBinding

class QuranChapterDetailesActivity : AppCompatActivity()
{
    var ChapterPosition:Int =-1
    lateinit var ChapterTitle:String
    lateinit var Title:TextView
    lateinit var binding:ActivityQuranChapterBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding= ActivityQuranChapterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inintView()
        readQuranChapter()


    }



    private fun readQuranChapter()
    {
       var allFiles= assets.open("${ChapterPosition+1}.txt")
            .bufferedReader().use { it.readText() }
        val spliteFiles= allFiles.split("\n")
        Log.e("Quran",spliteFiles.toString())
        bindRecyclerViewSuraDetails(spliteFiles)

    }

    private fun bindRecyclerViewSuraDetails(spliteFiles: List<String>)
    {
        var Adabter=SuraDetailsAadabter(spliteFiles)
        binding.rvSuraDetails.adapter=Adabter
    }

    override fun onSupportNavigateUp(): Boolean
    {
        finish()
        return true
    }
    private fun inintView()
    {
        val toolbar: Toolbar =binding.quranToolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title=null

        ChapterPosition=intent.getIntExtra(Extra_position,-1)
        ChapterTitle=intent.getStringExtra(Extra_title) ?:""

        Title=findViewById(R.id.sura_title)
        Title.text=ChapterTitle


    }

    companion object{
        const val Extra_position="position"
        const val Extra_title="title"
    }
}