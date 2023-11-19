async function obtenerResultados(url){
    return await fetch(url).then(response =>response.json());
}

async function mostrarResultados(url){
    const resultados = await obtenerResultados(url);
    console.log(resultados);
    const contenedor = document.getElementById('galeria'); // Cambia 'contenedor' al ID de tu contenedor en HTML
    for (var i = 0; i < resultados.length; i++) {
        const item = document.createElement('div');
        item.classList.add('item');
        
        const imagen = document.createElement('img');
        imagen.src = "img/cafe1.jpg"; // Asigna la URL de la imagen según la propiedad 'img' de cada resultado
        item.appendChild(imagen);

        const info = document.createElement('div');
        info.classList.add('info');
        
        const nombre = document.createElement('h2');
        nombre.textContent = resultados[i].nombre; // Asigna el nombre según la propiedad 'nombre' de cada resultado
        info.appendChild(nombre);

        const descripcion = document.createElement('p');
        descripcion.textContent = resultados[i].desc; // Asigna la descripción según la propiedad 'descripcion' de cada resultado
        info.appendChild(descripcion);

        item.appendChild(info);

        contenedor.appendChild(item);
    }
    
    
}
mostrarResultados("controller?ACTION=PRODUCTOS&CASO=FIND_ALL");

/*async function obtenerResultadosFiltrados(){
    return await fetch ("controller?ACTION=PRODUCTOS&CASO=FILTER&FILTER=cafe1").then(response =>response.json())
 
}

async function mostrarResultadosFiltrados(){
    
    const resultados = await obtenerResultadosFiltrados();
    console.log(resultados);
    const contenedor = document.getElementById('galeria'); // Cambia 'contenedor' al ID de tu contenedor en HTML
    for (var i = 0; i < resultados.length; i++) {
        const item = document.createElement('div');
        item.classList.add('item');
        
        const imagen = document.createElement('img');
        imagen.src = "img/cafe1.jpg"; // Asigna la URL de la imagen según la propiedad 'img' de cada resultado
        item.appendChild(imagen);

        const info = document.createElement('div');
        info.classList.add('info');
        
        const nombre = document.createElement('h2');
        nombre.textContent = resultados[i].nombre; // Asigna el nombre según la propiedad 'nombre' de cada resultado
        info.appendChild(nombre);

        const descripcion = document.createElement('p');
        descripcion.textContent = resultados[i].desc; // Asigna la descripción según la propiedad 'descripcion' de cada resultado
        info.appendChild(descripcion);

        item.appendChild(info);

        contenedor.appendChild(item);
    }
    
    
}
*/



document.querySelector('#cafe1').addEventListener('click', (e) =>{
      galeria.innerHTML='';
      obtenerResultados("controller?ACTION=PRODUCTOS&CASO=FILTER&FILTER=cafe1")
      mostrarResultados("controller?ACTION=PRODUCTOS&CASO=FILTER&FILTER=cafe1")
      console.log(obtenerResultados("controller?ACTION=PRODUCTOS&CASO=FILTER&FILTER=cafe1"))
      
})


document.querySelector('#cafe2').addEventListener('click', (e) =>{
      galeria.innerHTML='';
      obtenerResultados("controller?ACTION=PRODUCTOS&CASO=FILTER&FILTER=cafe2")
      mostrarResultados("controller?ACTION=PRODUCTOS&CASO=FILTER&FILTER=cafe2")
      console.log(obtenerResultados("controller?ACTION=PRODUCTOS&CASO=FILTER&FILTER=cafe2"))
      
})
