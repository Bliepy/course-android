package bliepy.com.android_level_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import bliepy.com.android_level_3.models.PortalModel;

public class WebviewActivity extends AppCompatActivity {

    private PortalModel model;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        setTitle("StudentPortal");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        model = (PortalModel) intent.getSerializableExtra("portal");

        webview = findViewById(R.id.webbrowser);
        webview.loadUrl(model.getUrl());
        webview.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.getSettings().setLoadsImagesAutomatically(true);
                view.getSettings().setJavaScriptEnabled(true);
                view.setScrollBarStyle(view.SCROLLBARS_INSIDE_OVERLAY);
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
