// Generate QR Code
function generate(){
let text = document.getElementById("text").value;

if(!text){
alert("Enter text first");
return;
}

document.getElementById("qrcode").innerHTML="";

new QRCode(document.getElementById("qrcode"),{
text:text,
width:200,
height:200
});
}

// Call Android camera scanner
function scan(){
if(window.Android && Android.scanQR){
Android.scanQR();
}else{
alert("Scanner not available in browser mode");
}
}

// Receive scan result from Android
function onScanResult(data){
document.getElementById("result").innerHTML =
"Scanned: " + data;
}
