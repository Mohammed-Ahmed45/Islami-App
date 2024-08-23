package IslamiApp.IslamiApp.quran

import IslamiApp.IslamiApp.hadeeth.HadeethAdabter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.myapplication.R
import com.mohamed.myapplication.databinding.QuranItemsBinding

class SuraRecyclerAdabter(val items: List<String> = listOf()): RecyclerView.Adapter<SuraRecyclerAdabter.SuraViewholder>() {

    class SuraViewholder(var binding: QuranItemsBinding):RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraViewholder {
        val binding=QuranItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return SuraViewholder(binding)

    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: SuraViewholder, position: Int) {
        var title=items[position]
      holder.binding.suraTitle.text = title

        holder.binding.root.setOnClickListener{
            onItemClickListener!!.OnClick(position, title)
        }

    }
    var onItemClickListener:OnItemClickListener?=null
    fun interface OnItemClickListener{
        fun OnClick(position: Int,title:String)
    }
}