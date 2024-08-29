package ru.zatsoft.imageview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import ru.zatsoft.imageview.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageBinding
    private val foto: List<Int> = arrayListOf(
        R.drawable.levoca,
        R.drawable.bardejov,
        R.drawable.telgart,
        R.drawable.spisky_hrad,
        R.drawable.stara_lubovna,
        R.drawable.tatry,
        R.drawable.tatry1,
        R.drawable.jasna,
        R.drawable.deman_jaskyna,
        R.drawable.tokaj
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var count = 0
        binding.imageView.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                foto.get(0)
            )
        )
        binding.btnForward.setOnClickListener {

            if (++count == foto.size) {
                val endIntent = Intent(this, EndActivity::class.java)
                startActivity(endIntent)
                finish()
            } else {
                binding.imageView.setImageDrawable(
                    ContextCompat.getDrawable(this, foto.get(count))
                )
            }
            lastText(count)
            firstText(count)
        }

        binding.btnBackward.setOnClickListener {
            if (--count == -1) {
                finish()
            } else {
                binding.imageView.setImageDrawable(
                    ContextCompat.getDrawable(this, foto.get(count))
                )
            }
            lastText(count)
            firstText(count)
        }
    }

    private fun firstText(count: Int) {
        if (count == 0) {
            binding.btnBackward.text = getString(R.string.textN)
        } else {
            binding.btnBackward.text = getString(R.string.back)
        }
    }

    private fun lastText(count: Int) {
        if (count == foto.lastIndex) {
            binding.btnForward.text = getString(R.string.textK)
        } else {
            binding.btnForward.text = getString(R.string.next)
        }
    }
}
