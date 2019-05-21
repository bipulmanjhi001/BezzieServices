package com.maasuniva


import android.app.AlertDialog
import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.bezzieservices.R


class Dashboard : AppCompatActivity() {
    internal lateinit var view: WebView
    internal lateinit var progressBar: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        view = this.findViewById<View>(R.id.webView) as WebView
        progressBar = ProgressDialog(this@Dashboard)
        progressBar.setMessage("Loading...")
        progressBar.show()
        view.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)

                return false
            }
        }
        view.settings.javaScriptEnabled = true
        view.loadUrl("http://bezzieservices.com")
        progressBar.dismiss()

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && view.canGoBack()) {
            view.goBack()
            return true
        } else if (keyCode == KeyEvent.KEYCODE_BACK) {
            ConfirmExit()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    fun ConfirmExit() {
        val alertDialog = AlertDialog.Builder(this@Dashboard)
        alertDialog.setTitle("Leave application?")
        alertDialog.setMessage("Are you sure you want to leave the application?")
        alertDialog.setIcon(R.drawable.ic_launcher)
        alertDialog.setPositiveButton("YES"
        ) { dialog, which -> finish() }
        alertDialog.setNegativeButton("NO") { dialog, which -> dialog.cancel() }
        alertDialog.show()
    }

}