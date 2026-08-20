package pl.dejwik.myapplication

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions
import pl.dejwik.myapplication.databinding.ActivityGrajBinding
import pl.dejwik.myapplication.databinding.ActivitySpotFreeBinding
import android.net.Uri
import pl.dejwik.myapplication.databinding.ActivitySpotPremBinding

class GrajActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGrajBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityGrajBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonSF.setOnClickListener(){
            startActivity(Intent(applicationContext, SpotFreeActivity::class.java))
        }

        binding.buttonSP.setOnClickListener(){
            startActivity(Intent(applicationContext, SpotPremActivity::class.java))
        }

        binding.guzikWroc.setOnClickListener(){
            finish()
        }
    }
}