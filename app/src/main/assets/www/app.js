function generate(){
let text=document.getElementById("text").value.trim();

if(text===""){
alert("Enter text first");
return;
}

document.getElementById("qrcode").innerHTML="";

new QRCode(document.getElementById("qrcode"),{
text:text,
width:220,
height:220
});
}

function scan(){
if(window.Android && Android.scanQR){
Android.scanQR();
}else{
document.getElementById("result").innerHTML="Scanner not available.";
}
}

function onScanResult(data){
document.getElementById("result").innerHTML="Scanned: "+data;
}