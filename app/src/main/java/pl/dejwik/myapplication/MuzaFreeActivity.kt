package pl.dejwik.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebViewClient
import pl.dejwik.myapplication.databinding.ActivityMuzaFreeBinding

class MuzaFreeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMuzaFreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMuzaFreeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"

        //ustawienia toolbara
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        //odpalamy stronke
        val webView = binding.webview
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true

        if (intent.hasExtra("TEXT_DATA")){
            val link = intent.getStringExtra("TEXT_DATA")
            webView.loadUrl(link.toString())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Obsługa kliknięć elementów menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_refresh -> {

                // Odśwież stronę w WebView
                //val webView = binding.webview
                //webView.reload()
                finish()
                true
            }
            R.id.odswiez ->{
                val webView = binding.webview
                webView.reload()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}