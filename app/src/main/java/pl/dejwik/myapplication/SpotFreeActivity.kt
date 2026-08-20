package pl.dejwik.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import pl.dejwik.myapplication.databinding.ActivitySpotFreeBinding

class SpotFreeActivity : AppCompatActivity() {
    private lateinit var codeScanner: CodeScanner

    private lateinit var binding: ActivitySpotFreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySpotFreeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val scannerView = binding.scannerView

        codeScanner = CodeScanner(this, scannerView)

        //parametry skanera
        codeScanner.camera = CodeScanner.CAMERA_BACK
        codeScanner.formats = CodeScanner.ALL_FORMATS

        codeScanner.autoFocusMode = AutoFocusMode.SAFE
        codeScanner.isAutoFocusEnabled = true
        codeScanner.isFlashEnabled = false
        codeScanner.scanMode = ScanMode.SINGLE

        //callbacks
        Toast.makeText(this, "Zeskanuj kod QR z karty", Toast.LENGTH_LONG).show()
        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                if (it.text.contains("open.spotify.com")){
                    Toast.makeText(this, "JEST GIT", Toast.LENGTH_LONG).show()
                    var linkDoMuzy = it.text.replace("/track", "/embed/track")
                    linkDoMuzy = linkDoMuzy.replace(Regex("[<>]"), "")
                    val explicitIntent = Intent(applicationContext, MuzaFreeActivity::class.java)
                    explicitIntent.putExtra("TEXT_DATA", linkDoMuzy)
                    startActivity(explicitIntent)
                    println(linkDoMuzy.toString())
                }
                else {
                    Toast.makeText(this, "Błąd: kod nie prowadzi do Spotify", Toast.LENGTH_LONG).show()
                }
                Toast.makeText(this, "Scan result: ${it.text}", Toast.LENGTH_LONG).show()
            }
        }
        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
            runOnUiThread {
                Toast.makeText(this, "Wystąpił error: ${it.message}",
                    Toast.LENGTH_LONG).show()
            }
        }

        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }


        binding.guzikWroc3.setOnClickListener(){
            finish()
        }

    }
    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}