package org.example;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();
    private HashMap<Integer, ArrayList<Estudiante>> estudiantesPorCurso = new HashMap<>();

    @Override
    public void matricularEstudiante(Estudiante estudiante) throws EstudianteIncritoException {
        if (estudiantes.contains(estudiante)) {
            throw new EstudianteIncritoException("El estudiante ya está matriculado.");
        }
        estudiantes.add(estudiante);
    }

    @Override
    public void agregarCurso(Curso curso) throws CursoExisteException {
        for (Curso c : cursos) {
            if (c.getId() == curso.getId()) {
                throw new CursoExisteException("El curso ya existe.");
            }
        }
        cursos.add(curso);
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteIncritoException, CursoNoExisteException {
        Curso curso = null;
        for (Curso c : cursos) {
            if (c.getId() == idCurso) {
                curso = c;
                break;
            }
        }
        if (curso == null) {
            throw new CursoNoExisteException("El curso no existe.");
        }

        ArrayList<Estudiante> inscritos = estudiantesPorCurso.getOrDefault(idCurso, new ArrayList<>());
        if (inscritos.contains(estudiante)) {
            throw new EstudianteIncritoException("El estudiante ya está inscrito en este curso.");
        }
        inscritos.add(estudiante);
        estudiantesPorCurso.put(idCurso, inscritos);
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoException, CursoNoExisteException {
        if (!estudiantesPorCurso.containsKey(idCurso)) {
            throw new CursoNoExisteException("El curso no existe.");
        }

        ArrayList<Estudiante> inscritos = estudiantesPorCurso.get(idCurso);
        Estudiante estudiante = null;
        for (Estudiante e : inscritos) {
            if (e.getId() == idEstudiante) {
                estudiante = e;
                break;
            }
        }

        if (estudiante == null) {
            throw new EstudianteNoInscritoException("El estudiante no está inscrito en este curso.");
        }

        inscritos.remove(estudiante);
        if (inscritos.isEmpty()) {
            estudiantesPorCurso.remove(idCurso);
        } else {
            estudiantesPorCurso.put(idCurso, inscritos);
        }
    }
}