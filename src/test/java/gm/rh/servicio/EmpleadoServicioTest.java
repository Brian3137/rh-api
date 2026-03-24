package gm.rh.servicio;

import gm.rh.modelo.Empleado;
import gm.rh.repositorio.EmpleadoRepositorio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class EmpleadoServicioTest {

    @Mock
    private EmpleadoRepositorio empleadoRepositorio;

    @InjectMocks
    private EmpleadoServicio empleadoServicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInicial() {
        System.out.println("Test Empleado listo");
    }
    @Test
    void guardarEmpleado_ok() {

        // 1. Crear objeto
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(1);
        empleado.setNombre("Brian");
        empleado.setDepartamento("Sistemas");
        empleado.setSueldo(1000.0);

        // 2. Simular save
        when(empleadoRepositorio.save(any(Empleado.class))).thenReturn(empleado);

        // 3. Ejecutar
        Empleado resultado = empleadoServicio.guardarEmpleado(empleado);

        // 4. Verificar
        assertNotNull(resultado);
        assertEquals("Brian", resultado.getNombre());

        verify(empleadoRepositorio).save(empleado);
    }
    @Test
    void eliminarEmpleado_ok() {

        // 1. Crear empleado
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(1);
        empleado.setNombre("Brian");

        // 2. Ejecutar
        empleadoServicio.eliminarEmpleado(empleado);

        // 3. Verificar
        verify(empleadoRepositorio).delete(empleado);
    }
}