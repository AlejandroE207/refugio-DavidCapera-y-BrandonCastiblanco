var tipo = document.getElementById("tipo");
document.getElementById("optToxo").style.display = 'none'; 
document.getElementById("optNivel").style.display = 'none'; 


tipo.addEventListener("change",function(){
    if(tipo.value=="perro" ){
        document.getElementById("optNivel").style.display = 'block';  
    }else{
        document.getElementById("optNivel").style.display = 'none'; 
    }
    if(tipo.value=="gato" ){
        document.getElementById("optToxo").style.display = 'block';  
    }else{
        document.getElementById("optToxo").style.display = 'none'; 
    }
    
})