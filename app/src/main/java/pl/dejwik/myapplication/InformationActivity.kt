package pl.dejwik.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.dejwik.myapplication.databinding.ActivityInformationBinding

/**
 * Information activity
 * This activity contains information of what the application is even about 
 * and how to use it.
 *
 * @constructor Creates a new InformationActivity
 */
class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding

    /**
     * On create
     * Initializes the information screen and configures click listener
     * for the available exit button.
     *
     * @param savedInstanceState the saved instance state
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInformationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.exitFromIa.setOnClickListener(){
            finish()
        }
    }
}