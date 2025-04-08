package ar.edu.utn.frba.dds;

import static java.util.Collections.EMPTY_SET;

import java.util.Collection;

public class Materia {
  private final String nombre;
  private final Collection<Materia> correlativas;

  public Materia(String nombre) {
    this.nombre = nombre;
    this.correlativas = EMPTY_SET;
  }

  public Materia(String nombre, Collection<Materia> correlativas) {
    this.nombre = nombre;
    this.correlativas = correlativas;
  }

  public boolean puedeCursarla(Alumno alumno) {
    return alumno.materiasAprobadas().containsAll(correlativas);
  }
}
