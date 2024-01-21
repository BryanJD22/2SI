
public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("El profesor reparte el examen");
        System.out.println("El profesor espera las entregas");

        MisAlumnos alumno1 = new MisAlumnos("1");
        MisAlumnos alumno2 = new MisAlumnos("2");
        MisAlumnos alumno3 = new MisAlumnos("3");
        MisAlumnos alumno4 = new MisAlumnos("4");
        MisAlumnos alumno5 = new MisAlumnos("5");


        alumno1.run();

        Thread.sleep(1000);

        alumno2.run();

        alumno3.run();

        alumno4.run();

        alumno5.run();

        Thread.sleep(1000);


    }


}