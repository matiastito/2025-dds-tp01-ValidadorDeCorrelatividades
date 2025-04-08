import static java.util.Set.of;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import dds.frba.utn.edu.ar.Alumno;
import dds.frba.utn.edu.ar.Inscripcion;
import dds.frba.utn.edu.ar.Materia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class IntegrationTest {

  private Materia sitaxis = new Materia("Sintaxis");
  private Materia sistemasOperativos = new Materia("Sistemas Operativos", of(sitaxis));
  private Alumno marcos = new Alumno("Marcos", of(sitaxis));
  private Alumno pedro = new Alumno("Pedro");

  @BeforeEach
  void init() {
  }

  @Test
  void puedoCursarMeteriaSinCorrelatividades() {
    assertTrue(new Inscripcion(marcos, of(sistemasOperativos)).aprobada());
    assertFalse(new Inscripcion(pedro, of(sistemasOperativos)).aprobada());
  }
}
