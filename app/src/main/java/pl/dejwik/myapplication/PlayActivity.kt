package pl.dejwik.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.dejwik.myapplication.databinding.ActivityPlayBinding

/**
 * Play activity
 * Activity responsible for displaying the game mode selection screen.
 *
 * The activity allows the user to choose between the Spotify Free
 * and Spotify Premium game modes.
 *
 * @constructor Creates a new PlayActivity
 */
class PlayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayBinding

    /**
     * On create
     * Initializes the mode selection screen and configures click listeners
     * for the available navigation buttons.
     *
     * @param savedInstanceState the saved instance state
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPlayBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonSF.setOnClickListener(){
            startActivity(Intent(applicationContext, SpotFreeActivity::class.java))
        }

        binding.buttonSP.setOnClickListener(){
            startActivity(Intent(applicationContext, SpotPremActivity::class.java))
        }

        binding.exitFromPa.setOnClickListener(){
            finish()
        }
    }
}