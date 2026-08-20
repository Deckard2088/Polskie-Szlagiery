package pl.dejwik.myapplication

import android.net.SocketKeepalive.Callback
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import pl.dejwik.myapplication.databinding.ActivityStronaBinding
import android.webkit.WebViewClient
import android.webkit.WebSettings
import android.webkit.WebView

class MyWebViewClient: WebViewClient(){
    override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?): Boolean {
        return false
    }
}
class StronaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStronaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityStronaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val webView = binding.webView
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = MyWebViewClient()
        webView.loadUrl("https://hitstergame.com/pl-pl/")

    }
}

