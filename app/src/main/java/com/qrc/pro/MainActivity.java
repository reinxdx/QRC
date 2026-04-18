package com.qrc.pro;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity extends Activity {

WebView w;

@Override
protected void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);

w = new WebView(this);

WebSettings s = w.getSettings();
s.setJavaScriptEnabled(true);
s.setDomStorageEnabled(true);

// JS bridge
w.addJavascriptInterface(new Object(){
@android.webkit.JavascriptInterface
public void scanQR(){
ScanOptions options = new ScanOptions();
options.setPrompt("Scan QR Code");
options.setBeepEnabled(true);
options.setOrientationLocked(true);
scanLauncher.launch(options);
}
},"Android");

w.loadUrl("file:///android_asset/www/splash.html");

setContentView(w);
}

private final androidx.activity.result.ActivityResultLauncher<ScanOptions> scanLauncher =
registerForActivityResult(new ScanContract(), result -> {
if(result.getContents()!=null){
w.loadUrl("javascript:onScanResult('" + result.getContents() + "')");
}
});
}
