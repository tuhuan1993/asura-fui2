
function selectButton(group,id){
   var g = $("button[name='"+group+"']");
   for(var i=0;i<g.length; i++){
      g[i].className = "btn btn-default";
   }
   document.getElementById(id).className = "btn btn-default:active";
}

function getSelectedButton(group){
   var g = $("button[name='"+group+"']");
   for(var i=0;i<g.length; i++){
      if(g[i].className == "btn btn-default:active"){
         return g[i].id;
      }
   }
   
   return "";
}

function getSelectedRadioValue(group){
   var g = $("input[name='"+group+"']");
   for(var i=0;i<g.length; i++){
      if(g[i].checked){
         return g[i].alt;
      }
   }
   
   return "";
}

function getSelectedRadio(group){
   var g = $("input[name='"+group+"']");
   for(var i=0;i<g.length; i++){
      if(g[i].checked){
         return g[i].id;
      }
   }
   
   return "";
}