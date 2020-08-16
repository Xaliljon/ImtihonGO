package uz.peachdev.imtihongo.DTMuchun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import uz.peachdev.imtihongo.R;

public class Qabul extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qabul);
        webView = findViewById(R.id.webqabul);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://qabul.dtm.uz/");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        } else
        super.onBackPressed();
    }
}