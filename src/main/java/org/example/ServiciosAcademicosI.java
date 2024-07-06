package org.example;

public interface ServiciosAcademicosI {
    void matricularEstudiante(Estudiante estudiante) throws EstudianteIncritoException;
    void agregarCurso(Curso curso) throws CursoExisteException;
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteIncritoException, CursoNoExisteException;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoException, CursoNoExisteException;
}

