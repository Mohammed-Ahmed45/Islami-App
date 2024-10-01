package IslamiApp.IslamiApp.hadeeth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mohamed.myapplication.databinding.FragmentHadeethBinding


class HadeethFragment : Fragment() {
    lateinit var binding: FragmentHadeethBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHadeethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadeeth()
    }

    private fun readHadeeth()
    {
        val allHadeethList:MutableList<HadeethContant> = mutableListOf()

        var allFiles= requireContext().assets.open("ahadeth.txt")
            .bufferedReader().use { it.readText() }
        val spliteFiles= allFiles.split("#")
        Log.e("Hadeeth",spliteFiles.toString())

        spliteFiles.forEach{
            hadeeth->
           val hadeethline= hadeeth.trim().split("\n").toMutableList()

            val title= hadeethline[0]
            hadeethline.removeAt(0)

            val Hadeeth=HadeethContant(
               title= title,
                content=hadeethline.joinToString("\n")
                )
            allHadeethList.add(Hadeeth)
        }
        bindAllHadethList(allHadeethList)

    }

    private fun bindAllHadethList(allHadeethList: MutableList<HadeethContant>)
    {
        val Adabter = HadeethAdabter(allHadeethList)
        binding.rvHadeeth.adapter = Adabter

        Adabter.onIteamClickListener = HadeethAdabter.OnItemClickListener {
        position, Hadeth ->
            var intent=Intent(context,HadeethChapterDetalisActivity::class.java)
            intent.putExtra(HadeethChapterDetalisActivity.Extra_hadeth,Hadeth)
            startActivity(intent)

        }

    }
}