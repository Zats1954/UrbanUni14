package ru.zatsoft.imageview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.zatsoft.imageview.databinding.ActivityEndBinding


class EndActivity: AppCompatActivity() {
    private lateinit var binding: ActivityEndBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEndBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExit.setOnClickListener {
           finish()
       }
    }
}