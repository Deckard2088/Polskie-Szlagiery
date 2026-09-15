package pl.dejwik.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import pl.dejwik.myapplication.databinding.ActivityWebsiteBinding
import android.webkit.WebViewClient
import android.webkit.WebView

/**
 * My web view client
 * Custom WebViewClient responsible for handling keyboard events
 * inside the WebView.
 *
 * Extends [WebViewClient] to control the behavior of the WebView
 * and allow the web page to be displayed directly inside the application.
 *
 * @constructor Creates a new MyWebViewClient
 */
class MyWebViewClient: WebViewClient(){

    /**
     * Handles keyboard events received by the WebView.
     * Returning 'false' allows the event to be handled normally
     * by the WebView instead of being overridden by the application.
     *
     * @param view the WebView in which the event occurred
     * @param event the keyboard event
     * @return `false` to allow the WebView to handle the event normally
     */
    override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?): Boolean {
        return false
    }
}

/**
 * Strona activity
 * Activity responsible for displaying the Hitster game website
 * inside a WebView.
 *
 * The activity configures the WebView, enables JavaScript support,
 * sets a custom WebViewClient, and loads the Hitster game website.
 *
 * @constructor Creates a new StronaActivity
 */
class WebsiteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebsiteBinding

    /**
     * On create
     * Initializes the activity and configures the WebView.
     *
     * View Binding is used to access the views defined in the layout.
     * JavaScript support is enabled because it is required by the
     * loaded website. A custom [WebViewClient] is also assigned
     * to the WebView.
     *
     * Finally, the Hitster game website is loaded.
     *
     * @param savedInstanceState the saved instance state
     */
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityWebsiteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val webView = binding.webView
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = MyWebViewClient()
        webView.loadUrl("https://hitstergame.com/pl-pl/")

    }
}

