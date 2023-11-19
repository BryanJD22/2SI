async function obtenerResultados(url){
    return await fetch (url).then(response => response.json())
}


async function register(url,url_register){
    const resultados = obtenerResultados(url);
    const NOMBRE = document.querySelector("")
    
    
}