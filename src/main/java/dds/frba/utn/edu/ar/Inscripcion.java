package dds.frba.utn.edu.ar;

import static java.lang.Boolean.TRUE;

import java.util.Collection;
import java.util.Collections;

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
