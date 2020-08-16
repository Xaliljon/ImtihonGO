package uz.peachdev.imtihongo.DTMuchun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import uz.peachdev.imtihongo.R;

public class Abitur extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abitur);
        webView = findViewById(R.id.webabitur);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://abitur.dtm.uz");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}