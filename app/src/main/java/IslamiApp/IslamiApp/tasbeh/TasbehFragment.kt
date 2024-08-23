package IslamiApp.IslamiApp.tasbeh

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.RotateAnimation
import com.mohamed.myapplication.R
import com.mohamed.myapplication.databinding.FragmentTasbehBinding


class TasbehFragment : Fragment() {
    var counter:Int = 0
    var Index:Int = 0
    var Rotation = 0f
    lateinit var AlAzkar:MutableList<String>
    lateinit var binding:FragmentTasbehBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
     savedInstanceState: Bundle?
    ): View? {
        binding= FragmentTasbehBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        AlAzkar=resources.getStringArray(R.array.AlAzkar).toMutableList()
        binding.AzkarTv.text=AlAzkar[Index]
        count()
    }

    private fun count()
    {

        binding.sebhaLogo.setOnClickListener {

            rotateImage()
            if (counter<33)
            {
                counter++
                binding.tasbehConter.text = counter.toString()
            }
            else{
                counter=0
                binding.tasbehConter.text = counter.toString()
                Index=if (Index<AlAzkar.size-1)
                {
                    ++Index
                }
                else { 0 }

                binding.AzkarTv.text=AlAzkar[Index]


            }



        }
    }
    private fun rotateImage() {
      Rotation+=10f

        val rotateAnimation = RotateAnimation(
           Rotation-10,Rotation,
           RotateAnimation.RELATIVE_TO_SELF,0.5f,
           RotateAnimation.RELATIVE_TO_SELF,0.5f
        ).apply {
           duration=500
           fillAfter=true
       }
        binding.sebhaLogo.startAnimation(rotateAnimation)

        // إنشاء حركة دوران
//        val rotateAnimation = RotateAnimation(
//            currentRotation - 90, // زاوية البداية
//            currentRotation, // زاوية النهاية
//            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
//            RotateAnimation.RELATIVE_TO_SELF, 0.5f
//        ).apply {
//            duration = 500 // مدة الدوران
//            fillAfter = true// يبقى الدوران بعد انتهاء الحركة
//        }

        // تطبيق الحركة على الصورة
//        binding.sebhaLogo.startAnimation(rotateAnimation)
    }
}