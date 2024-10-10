import android.icu.text.Transliterator.Position
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ItemCategoryMenuBinding
import com.example.kuit4androidprivate.databinding.ItemShowMoreBinding
import com.example.kuit4androidprivate.home.HomeFragment
import com.example.kuit4androidprivate.model.MenuCategoryData

class MenuCategoryRVAdapter(
    private val context: HomeFragment,
    private val items: ArrayList<MenuCategoryData>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    inner class CategoryViewHolder(val binding: ItemCategoryMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuCategoryData) {
            binding.ivCategoryItem.setImageResource(item.imageRes)
            binding.tvCategoryItem.text = item.name
        }
    }

    inner class ShowMoreViewHolder(val binding: ItemShowMoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener() {}
        }
    }

    companion object {
        private const val VIEW_TYPE_ITEM = 0
        private const val VIEW_TYPE_SHOW_MORE = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 9) VIEW_TYPE_SHOW_MORE
        else VIEW_TYPE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ITEM) {
            val itemBinding = ItemCategoryMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
            return CategoryViewHolder(itemBinding)
        } else {
            val showMoreBinding =
                ItemShowMoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return ShowMoreViewHolder(showMoreBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CategoryViewHolder) holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size + 1
}
