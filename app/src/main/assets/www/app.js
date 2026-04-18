function generate(){
let t=document.getElementById("text").value;
document.getElementById("qrcode").innerHTML =
"<div style='padding:20px;color:#00ffff'>QR: "+t+"</div>";
}

function scan(){
if(window.Android){
Android.scanQR();
}else{
document.getElementById("result").innerHTML="Scanner unavailable";
}
}

function onScanResult(data){
document.getElementById("result").innerHTML="Scanned: "+data;
}