package IslamiApp.IslamiApp.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mohamed.myapplication.databinding.FragmentQuranBinding


class QuranFragment : Fragment() {
    var suraList= listOf(
        "الفاتحه",
        "البقرة",
        "آل عمران",
        "النساء",
        "المائدة",
        "الأنعام",
        "الأعراف",
        "الأنفال",
        "التوبة",
        "يونس",
        "هود",
        "يوسف",
        "الرعد",
        "إبراهيم",
        "الحجر",
        "النحل",
        "الإسراء",
        "الكهف",
        "مريم",
        "طه",
        "الأنبياء",
        "الحج",
        "المؤمنون",
        "النّور",
        "الفرقان",
        "الشعراء",
        "النّمل",
        "القصص",
        "العنكبوت",
        "الرّوم",
        "لقمان",
        "السجدة",
        "الأحزاب",
        "سبأ",
        "فاطر",
        "يس",
        "الصافات",
        "ص",
        "الزمر",
        "غافر",
        "فصّلت",
        "الشورى",
        "الزخرف",
        "الدّخان",
        "الجاثية",
        "الأحقاف",
        "محمد",
        "الفتح",
        "الحجرات",
        "ق",
        "الذاريات",
        "الطور",
        "النجم",
        "القمر",
        "الرحمن",
        "الواقعة",
        "الحديد",
        "المجادلة",
        "الحشر",
        "الممتحنة",
        "الصف",
        "الجمعة",
        "المنافقون",
        "التغابن",
        "الطلاق",
        "التحريم",
        "الملك",
        "القلم",
        "الحاقة",
        "المعارج",
        "نوح",
        "الجن",
        "المزّمّل",
        "المدّثر",
        "القيامة",
        "الإنسان",
        "المرسلات",
        "النبأ",
        "النازعات",
        "عبس",
        "التكوير",
        "الإنفطار",
        "المطفّفين",
        "الإنشقاق",
        "البروج",
        "الطارق",
        "الأعلى",
        "الغاشية",
        "الفجر",
        "البلد",
        "الشمس",
        "الليل",
        "الضحى",
        "الشرح",
        "التين",
        "العلق",
        "القدر",
        "البينة",
        "الزلزلة",
        "العاديات",
        "القارعة",
        "التكاثر",
        "العصر",
        "الهمزة",
        "الفيل",
        "قريش",
        "الماعون",
        "الكوثر",
        "الكافرون",
        "النصر",
        "المسد",
        "الإخلاص",
        "الفلق",
        "الناس"
    )

    lateinit var binding:FragmentQuranBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding=FragmentQuranBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    var Adabter=SuraRecyclerAdabter(suraList)
//    var Adabter=SuraRecyclerAdabter(suraList)

    private fun initView(view: View) {
        binding.rvQuran.adapter=Adabter
        Adabter.onItemClickListener= SuraRecyclerAdabter.OnItemClickListener {
        position, title ->
            strartQuranChapter(position,title)

        }
//        binding.rvQuran.adapter=Adabter
//        Adabter.onItemClickListener= SuraRecyclerAdabter.OnItemClickListener {
//        position, title ->
//        startQuranChapter(position,title)

        }

    private fun strartQuranChapter(position: Int, title: String)
    {
        val intent=Intent(context,QuranChapterDetailesActivity::class.java)
        intent.putExtra(QuranChapterDetailesActivity.Extra_position,position)
        intent.putExtra(QuranChapterDetailesActivity.Extra_title,title)
        startActivity(intent)
    }


//       recyclerView=view.findViewById(R.id.rv_quran)
//        rv_Adabter= SuraRecyclerAdabter(suraList)
//        recyclerView.adapter=rv_Adabter



//    private fun startQuranChapter(position: Int, title: String)
//    {
//        var intent=Intent(context,QuranChapterActivity::class.java)
//        intent.putExtra(QuranChapterActivity.Extra_position,position)
//
////        intent.putExtra(QuranChapterActivity.Extra_position,position)
////        intent.putExtra(QuranChapterActivity.Extra_title,title)
//        startActivity(intent)



}

//private fun intView() {
//    recyclerView=findViewById(R.id.rv_quran)
//    rv_Adabter=SuraRecyclerAdabter(contactlist)
