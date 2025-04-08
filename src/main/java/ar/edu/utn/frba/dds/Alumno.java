package ar.edu.utn.frba.dds;

import static java.util.Collections.EMPTY_SET;

import java.util.Collection;

public class Alumno {
  private String nombre;
  private Collection<Materia> materiasAprobadas;

  public Alumno(String nombre) {
    this.nombre = nombre;
    this.materiasAprobadas = EMPTY_SET;
  }

  public Alumno(String nombre, Collection<Materia> materiasAprobadas) {
    this.nombre = nombre;
    this.materiasAprobadas = materiasAprobadas;
  }

  public Collection<Materia> materiasAprobadas() {
    return materiasAprobadas;
  }
}
