package IslamiApp.IslamiApp.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.myapplication.databinding.ActivitySuraDetailsBinding
import com.mohamed.myapplication.databinding.QuranItemsBinding

class SuraDetailsAadabter(var list: List<String> = listOf()):RecyclerView.Adapter<SuraDetailsAadabter.SuraViewHolder>()
{
    class SuraViewHolder(val binding: ActivitySuraDetailsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraViewHolder
    {
        val binding=ActivitySuraDetailsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SuraViewHolder(binding)
    }

    override fun getItemCount(): Int
    {
      return list.size
    }

    override fun onBindViewHolder(holder: SuraViewHolder, position: Int)
    {
        val title=list[position]
       holder.binding.suraDetails.text="$title (${position+1})"

    }

}