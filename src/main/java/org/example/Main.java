package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            GestorAcademico gestor = new GestorAcademico();

            // agrega Estudiantes
            Estudiante estudiante1 = new Estudiante(1, "Edwin", "Pérez", "2006-12-05", Estudiante.Estado.MATRICULADO);
            Estudiante estudiante2 = new Estudiante(2, "Julian", "Coc", "2006-15-10", Estudiante.Estado.MATRICULADO);

            // Crea cursos
            Curso curso1 = new Curso(1, "Educación Fisica", "Futbol", 95, "4");
            Curso curso2 = new Curso(2, "Computacion", "Programación En Java", 90, "4");

            // Matricula para estudiantes
            gestor.matricularEstudiante(estudiante1);
            System.out.println("Estudiante matriculado: " + estudiante1.getNombre() + " " + estudiante1.getApellido());
            gestor.matricularEstudiante(estudiante2);
            System.out.println("\n Estudiante matriculado: " + estudiante2.getNombre() + " " + estudiante2.getApellido());

            // Añadir uno o mas cursos
            gestor.agregarCurso(curso1);
            System.out.println("Curso agregado: " + curso1.getNombre() + " - " + curso1.getDescripcion());
            gestor.agregarCurso(curso2);
            System.out.println("\n Curso agregado: " + curso2.getNombre() + " - " + curso2.getDescripcion());

            // Inscribir estudiantes y asignarles su curso
            gestor.inscribirEstudianteCurso(estudiante1, 1);
            System.out.println("Estudiante " + estudiante1.getNombre() + " inscrito en el curso: " + curso1.getNombre());
            gestor.inscribirEstudianteCurso(estudiante2, 2);
            System.out.println("\n Estudiante " + estudiante2.getNombre() + " inscrito en el curso: " + curso2.getNombre());

            // Eliminar de la inscripcion al estudiante seleccionado
            gestor.desinscribirEstudianteCurso(1, 1);
            System.out.println("\n Estudiante " + estudiante1.getNombre() + " desinscrito del curso: " + curso1.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}