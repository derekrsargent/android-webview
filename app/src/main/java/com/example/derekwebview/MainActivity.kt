package com.example.derekwebview

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create and configure the WebView
        val webView = WebView(this)
        webView.settings.javaScriptEnabled = true  // Enable JavaScript
        webView.settings.domStorageEnabled = true

        webView.webViewClient = WebViewClient()     // Handle page navigation within the WebView

        // Load some HTML content
        val htmlContent = """
            <!DOCTYPE html>
            <html lang="en">
              <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <meta http-equiv="X-UA-Compatible" content="ie=edge">
                  <title> YOUR TITLE HERE </title>
                  <script src="https://api-stg.measureone.com/v3/js/m1-link-2021042000.js"></script> 
              </head>
              <body>
                <h1>YOUR TITLE HERE</h1>
                <div>
                  <m1-link></m1-link>
                
                <script>
                  var config = {
                      access_key: "INCORRECT-TOKEN-WILL-STILL-DISPLAY-A-NONLOADING-SCREEN",
                      host_name: "api-stg.measureone.com",
                      datarequest_id: "dr_2nWWtV60J17DaZ06kqk1S8M4cuP",
                      branding: {
                          styles: {
                              primary_dark: "#186793",
                              primary_light: "#2e9ccb",
                              secondary_color: "#ffffff",
                              min_height: "700px"
                          }
                      },
                      options: {
                          "display_profile": false
                      }
                  }
                          
                  // Take reference to widget
                  const m1_widget = document.querySelector("m1-link");
                  
                  // Add configuration
                  m1_widget.setAttribute("config", JSON.stringify(config));
            
                </script>
              </body>
            </html>
        """.trimIndent()

        webView.loadDataWithBaseURL("https://api-stg.measureone.com", htmlContent, "text/html", "utf-8", null)

        // Load a webpage
        //webView.loadUrl("https://www.google.com")

        // Set the WebView as the content view
        setContentView(webView)
    }
}