package dds.frba.utn.edu.ar;

import static java.util.Set.of;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class IntegrationTest {

  private Materia sintaxis = new Materia("Sintaxis");
  private Materia sistemasOperativos = new Materia("Sistemas Operativos", of(sintaxis));
  private Materia redes = new Materia("Redes", of(sistemasOperativos));

  private Alumno alumnoIngresante = new Alumno("Pedro");
  private Alumno alumnoConSintaxisAprobada = new Alumno("Marcos", of(sintaxis));
  private Alumno alumnoConSintaxisYSistemasOperativosAprobada = new Alumno("Luis", of(sistemasOperativos, sintaxis));

  @Test
  void unIngresateSoloPuedeCursarMateriasSinCorrelaivas() {
    assertTrue(new Inscripcion(alumnoIngresante, of(sintaxis)).aprobada());
    assertFalse(new Inscripcion(alumnoIngresante, of(sintaxis, sistemasOperativos)).aprobada());
    assertFalse(new Inscripcion(alumnoIngresante, of(sintaxis, redes)).aprobada());
    assertFalse(new Inscripcion(alumnoIngresante, of(sistemasOperativos, redes)).aprobada());
  }

  @Test
  void unAlumnoConSintaxisAprobadaSoloPuedeCursarSistemasOperativosYSintaxis() {
    assertTrue(new Inscripcion(alumnoConSintaxisAprobada, of(sintaxis)).aprobada());
    assertTrue(new Inscripcion(alumnoConSintaxisAprobada, of(sintaxis, sistemasOperativos)).aprobada());
    assertFalse(new Inscripcion(alumnoConSintaxisAprobada, of(sintaxis, redes)).aprobada());
    assertFalse(new Inscripcion(alumnoConSintaxisAprobada, of(sistemasOperativos, redes)).aprobada());
  }

  @Test
  void unAlumnoConSintaxisYSistemasOperativosAprobadasCursarSintaxisSistemasOperativosYRedes() {
    assertTrue(new Inscripcion(alumnoConSintaxisYSistemasOperativosAprobada, of(sintaxis)).aprobada());
    assertTrue(new Inscripcion(alumnoConSintaxisYSistemasOperativosAprobada, of(sintaxis, sistemasOperativos)).aprobada());
    assertTrue(new Inscripcion(alumnoConSintaxisYSistemasOperativosAprobada, of(sintaxis, redes)).aprobada());
    assertTrue(new Inscripcion(alumnoConSintaxisYSistemasOperativosAprobada, of(sistemasOperativos, redes)).aprobada());
  }
}
