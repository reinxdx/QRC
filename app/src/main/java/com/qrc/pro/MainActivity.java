package com.qrc.pro;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

WebView web;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);

web = new WebView(this);
setContentView(web);

WebSettings s = web.getSettings();

s.setJavaScriptEnabled(true);
s.setDomStorageEnabled(true);
s.setAllowFileAccess(true);
s.setAllowContentAccess(true);
s.setDatabaseEnabled(true);
s.setLoadsImagesAutomatically(true);
s.setUseWideViewPort(true);
s.setLoadWithOverviewMode(true);
s.setCacheMode(WebSettings.LOAD_NO_CACHE);

web.clearCache(true);
web.clearHistory();

web.setWebViewClient(new WebViewClient());
web.setWebChromeClient(new WebChromeClient());

web.addJavascriptInterface(new Object(){

@android.webkit.JavascriptInterface
public void scanQR(){
web.loadUrl("javascript:onScanResult('Scanner Ready')");
}

}, "Android");

web.loadUrl("file:///android_asset/www/index.html");

}
}