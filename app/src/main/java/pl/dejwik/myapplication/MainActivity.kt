package pl.dejwik.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.dejwik.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.guzikZKartami.setOnClickListener(){
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://polskieszlagiery.ugu.pl/polskie_szlagiery_karty.pdf"))
            startActivity(browserIntent)
        }

        binding.guzikDoZasad.setOnClickListener(){
            //val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://hitstergame.com/pl-pl/"))
            //startActivity(browserIntent)
            startActivity(Intent(applicationContext, StronaActivity::class.java))
        }

        binding.guzikDoGry.setOnClickListener(){
            startActivity(Intent(applicationContext, GrajActivity::class.java))
        }

        binding.guzikDoInfo.setOnClickListener(){
            startActivity(Intent(applicationContext, InformacjaActivity::class.java))
        }

    }
}