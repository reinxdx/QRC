function generate(){
let text=document.getElementById("text").value;

document.getElementById("qrcode").innerHTML="";

new QRCode(document.getElementById("qrcode"),{
text:text,
width:200,
height:200
});
}

function scan(){
Android.scanQR();
}

function onScanResult(data){
document.getElementById("result").innerHTML="Scanned: "+data;
}
