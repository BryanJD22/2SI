const promesaDeDatos = new Promise(function (resolve, reject) {
  // Imagina que estamos cargando datos de internet aquí
  if (true) {
    resolve('datos'); // La promesa se cumple, y entregamos los datos
  } else {
    reject('Error'); // La promesa falla, y reportamos un error
  }
});

async function cargarYMostrarDatos() {
  try {
    const datos = await promesaDeDatos; // Espera aquí hasta que la promesa se cumpla y tengamos datos
    console.log(datos); // Ahora los usamos
  } catch (error) {
    console.error(error); // Si hay un error, lo manejo aquí
  }
}

cargarYMostrarDatos();
