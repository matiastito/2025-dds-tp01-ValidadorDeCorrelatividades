package ar.edu.utn.frba.dds;

import java.util.Collection;

public class Inscripcion {
  private Alumno alumno;
  private Collection<Materia> materiasInscriptas;

  public Inscripcion(Alumno alumno, Collection<Materia> materiasInscriptas) {
    this.alumno = alumno;
    this.materiasInscriptas = materiasInscriptas;
  }

  public boolean aprobada() {
    return materiasInscriptas.stream()
        .allMatch(materia -> materia.puedeCursarla(alumno));
  }
}
