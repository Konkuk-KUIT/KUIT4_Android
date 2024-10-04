package detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.kuit4androidprivate.R
import com.example.kuit4androidprivate.databinding.ActivityDetailBinding
import com.example.kuit4androidprivate.model.MenuData

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menuData = intent.getSerializableExtra("menuData") as? MenuData

        menuData?.let {
            binding.tvDetailName.text = it.title
            binding.tvDetailRate.text = it.rate
            binding.tvDetailNumber.text = it.number

            Glide.with(this@DetailActivity)
                .load(it.imageUrl)
                .error(R.drawable.image1)
                .into(binding.ivDetailImage1)
        }

        binding.ivDetailBack.setOnClickListener{
            finish()
        }


    }
}