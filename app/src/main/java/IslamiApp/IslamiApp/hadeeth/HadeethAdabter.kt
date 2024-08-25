package IslamiApp.IslamiApp.hadeeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.myapplication.databinding.QuranItemsBinding

class HadeethAdabter(val hadeethList:List<HadeethContant>):RecyclerView.Adapter<HadeethAdabter.HadeethViewHolder>()

{
    class HadeethViewHolder(val binding:QuranItemsBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadeethViewHolder
    {
        var binding=QuranItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return HadeethViewHolder(binding)
    }

    override fun getItemCount(): Int
    {
        return hadeethList.size
    }

    override fun onBindViewHolder(holder: HadeethViewHolder, position: Int)
    {
        val Hadeth=hadeethList[position]
        holder.binding.suraTitle.text=Hadeth.title

        if(onIteamClickListener!=null)
            holder.binding.root.setOnClickListener{
                onIteamClickListener!!.OnClcik(position,Hadeth)
            }


    }
    var onIteamClickListener: OnItemClickListener?=null
    fun interface OnItemClickListener{
        fun OnClcik(position: Int,Hadeth: HadeethContant)
    }

//    var onItemClickListener:OnItemClickListener?=null
//    fun interface OnItemClickListener{
//        fun onClick(position: Int, title: HadeethContant)
//    }

}
//    class HadeethViewHolder(val binding:QuranItemsBinding):RecyclerView.ViewHolder(binding.root)
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadeethViewHolder
//    {
////        val view= LayoutInflater.from(parent.context)
////            .inflate(R.layout.quran_items,parent,false)
//        val binding=QuranItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return HadeethViewHolder(binding)
//    }
//
//
//    override fun getItemCount(): Int
//    {
//      return items.size
//    }
//
//
//    override fun onBindViewHolder(holder: HadeethViewHolder, position: Int)
//    {
//        val title=items[position]
//        holder.binding.suraTitle.text = title
//
//
//
//        holder.binding.root.setOnClickListener{
//            onItemClickListener!!.onClick(position,title)
//        }
//    }
//
//
//    var onItemClickListener:OnItemClickListener?=null
//    fun interface OnItemClickListener{
//        fun onClick(position: Int,title:String)
//    }
