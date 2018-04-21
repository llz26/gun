
window.onload = function a () {
    var but=document.createElement("button");
    but.setAttribute("class","css_audio_btn");
    but.setAttribute("id","but");
    var span1=document.createElement("span");
    span1.setAttribute("class","css_btn_lbl");
    var txt1=document.createTextNode("►");
    span1.appendChild(txt1);
    but.appendChild(span1);
    var span2=document.createElement("span");
    span2.setAttribute("class","css_data1");
    var txt2=document.createTextNode("0");
    span2.appendChild(txt2);
    but.appendChild(span1);
    var span3=document.createElement("span");
    span3.setAttribute("class","css_data2");
    var script=document.createElement("script");
    var txt3=document.createTextNode("pinyinflash('a1.mp3');");
    script.appendChild(txt3);
    span3.appendChild(script);
    but.appendChild(span1);

    var par=document.getElementsByName ("mp3");
    par.appendChild(but);

}