package IslamiApp.IslamiApp.hadeeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.myapplication.databinding.ActivityHadeethChapterDetalisBinding
import com.mohamed.myapplication.databinding.QuranItemsBinding

class HadeethDetailsAdabter(val list: List<String> ):RecyclerView.Adapter<HadeethDetailsAdabter.HadeethDetailsViewHolder>()
{
    class HadeethDetailsViewHolder(val binding: QuranItemsBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadeethDetailsViewHolder
    {
        val binding =QuranItemsBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return HadeethDetailsViewHolder(binding)
    }

    override fun getItemCount(): Int
    {
       return list.size
    }

    override fun onBindViewHolder(holder: HadeethDetailsViewHolder, position: Int)
    {
        val title=list[position]
//        holder.binding.suraTitle.text=title.ti
    }
}