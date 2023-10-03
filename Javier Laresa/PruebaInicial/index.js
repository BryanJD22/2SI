function validarFormulario() {
    var nombre = document.getElementById('nombre').value;
    var correo = document.getElementById('correo').value;
    var clave = document.getElementById('clave').value;

    // Validación básica: asegurarse de que los campos no estén vacíos
    if (nombre.trim() === '' || correo.trim() === '' || clave.trim() === '') {
        alert('Por favor, complete todos los campos.');
        return false;  // Evita que el formulario se envíe
    }

    // Aquí puedes agregar más validaciones según tus requisitos (por ejemplo, validación de correo electrónico, longitud de la clave, etc.)

    return true;  // Permite que el formulario se envíe
}