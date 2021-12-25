package org.mahmoud.zeerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class ContactMe extends AppCompatActivity {
    Button contact;
    WebView webView;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_me);
        contact=findViewById(R.id.contact);
        webView=findViewById(R.id.aboutus);
        webView.loadUrl("https://www.ayoubschool.com/p/contact-us.html");
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setSupportZoom(true);
//        refresh
        swipeRefreshLayout =findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast toast=Toast.makeText(getApplicationContext(),"Refresh",Toast.LENGTH_LONG);
                toast.show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }
    public void backHome(View view){
        Intent backHome =new Intent(this,MainActivity.class);
        startActivity(backHome);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK &&webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}