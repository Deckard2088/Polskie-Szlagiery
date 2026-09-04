package pl.dejwik.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.dejwik.myapplication.databinding.ActivityMainBinding
import androidx.core.net.toUri

/**
 * Main activity
 * This activity provides navigation to the card list, game, rules
 * and information screens.
 *
 * @constructor Creates a new MainActivity
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    /**
     * On create
     * Initializes the main screen and configures click listeners
     * for the available navigation buttons.
     *
     * @param savedInstanceState previously saved activity state,
     * or null if the activity is being created for the first time
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.guzikZKartami.setOnClickListener(){
            val browserIntent = Intent(Intent.ACTION_VIEW,
                "http://polskieszlagiery.ugu.pl/polskie_szlagiery_karty.pdf".toUri())
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