package IslamiApp.IslamiApp.hadeeth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val Adater=HadeethAdabter(allHadeethList)
        binding.rvHadeeth.adapter=Adater

        Adater.onIteamClickListener= HadeethAdabter.OnItemClickListener {
        position, Hadeth ->
            var intent=Intent(context,HadeethChapterDetalisActivity::class.java)
            intent.putExtra(HadeethChapterDetalisActivity.Extra_hadeth,Hadeth)
            startActivity(intent)

        }

    }

//    private fun initView()
//    {
//        Adabter.onItemClickListener= HadeethAdabter.OnItemClickListener {
//         position, title ->
//            starHadeethDetails(position,title)
//
//        }
//        binding.rvHadeeth.adapter=Adabter
//    }
//
//    private fun starHadeethDetails(position: Int, title: String)
//    {
//        val intent=Intent(context,HadeethChapterDetalisActivity::class.java)
//        intent.putExtra(HadeethChapterDetalisActivity.Extra_position,position)
//        intent.putExtra(HadeethChapterDetalisActivity.Extra_Title,title)
//        startActivity(intent)
//
//    }

//    var Adapter = HadeethAdabter(hadeethList)
//
//    private fun initView() {
//        Adapter.onItemClickListener= HadeethAdabter.OnItemClickListener{
//                position, title ->
//            startActivityDetails(position, title)
//        }
//
//        binding.rvHadeeth.adapter = Adapter
//    }
//
//
//    private fun startActivityDetails(position: Int, title: String)
//    {
//    val intent=Intent(activity, HadeethChapterDetalisActivity::class.java)
//        intent.putExtra(HadeethChapterDetalisActivity.Extra_position,position)
//        intent.putExtra(HadeethChapterDetalisActivity.Extra_Title,title)
//        startActivity(intent)
//
//    }


}