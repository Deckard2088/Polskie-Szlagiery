package pl.dejwik.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.dejwik.myapplication.databinding.ActivityInformacjaBinding

class InformacjaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformacjaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInformacjaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.guzikWroc2.setOnClickListener(){
            finish()
        }
    }
}