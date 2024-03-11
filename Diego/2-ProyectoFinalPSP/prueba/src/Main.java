public class Main {

    public static void main(String[] args) {
        String mensajeOriginal = "Hola, esto es un mensaje de prueba.";

        System.out.println("Mensaje original: " + mensajeOriginal);

        String mensajeCifrado = cifrarMensaje(mensajeOriginal);
        System.out.println("Mensaje cifrado: " + mensajeCifrado);
    }

    public static String cifrarMensaje(String mensaje) {
        char[] abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] mensajeCifrado = new char[mensaje.length()];

        for (int i = 0; i < mensaje.length(); i++) {
            char caracter = mensaje.charAt(i);
            int indice = -1;

            // Verificar si el caracter está en mayúsculas
            if (Character.isUpperCase(caracter)) {
                indice = caracter - 'A';
                mensajeCifrado[i] = abecedario[(indice + 3) % 26];
            }
            // Verificar si el caracter está en minúsculas
            else if (Character.isLowerCase(caracter)) {
                indice = caracter - 'a';
                mensajeCifrado[i] = Character.toLowerCase(abecedario[(indice + 3) % 26]);
            }
            // Si no es una letra, mantener el mismo caracter
            else {
                mensajeCifrado[i] = caracter;
            }
        }

        return new String(mensajeCifrado);
    }
}
