package com.diego.sistemaweb;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.diego.sistemaweb.controllers.response.SocioResponse;
import com.diego.sistemaweb.entitys.Socio;
import com.diego.sistemaweb.repositories.SocioRepository;
import com.diego.sistemaweb.services.SocioServicelmpl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class SocioServicelmplTest {

    @Mock
    private SocioRepository socioRepository;

    @InjectMocks
    private SocioServicelmpl socioService;

    @Test
    void testConsultar() {
        // Configuración de comportamiento simulado
        when(socioRepository.findAll()).thenReturn(List.of(new Socio(null, null, null, null, 0, 0, 0, 0/* datos de prueba */)));

        // Llamada al método bajo prueba
        SocioResponse socioResponse = socioService.consultar();

        // Verificación de resultados utilizando assertions de JUnit
        assertNotNull(socioResponse);
        // Agrega más aserciones según tus necesidades
    }
    @Test
    void testCrear() {
        // Datos de prueba
        Long id = 1L;
        String nombre = "Ejemplo";
        String descripcion = "Descripción de prueba";
        float inversionTotal = 1000.0f;
        Socio socioRequest = new Socio(id, nombre, descripcion, descripcion, inversionTotal, inversionTotal, inversionTotal, inversionTotal);

        // Configuración de comportamiento simulado del repositorio
        when(socioRepository.save(any(Socio.class))).thenReturn(socioRequest);

        // Llamada al método bajo prueba
        SocioResponse socioResponse = socioService.crear(socioRequest);

        // Verificación de resultados utilizando assertions de JUnit
        assertNotNull(socioResponse.getInfoList());

        // Imprimir la lista de información para la depuración
        System.out.println("InfoList: " + socioResponse.getInfoList());

        // Asegurarse de que la lista de información no sea nula y contenga mensajes
        assertFalse(socioResponse.getInfoList().isEmpty(), "La lista de información no debe estar vacía");
        assertFalse(socioResponse.getData().isEmpty(), "La lista de datos no debe estar vacía");

        // Verificación de que el método save del repositorio fue invocado con el socioRequest
        verify(socioRepository, times(1)).save(eq(socioRequest));
    }
    @Test
    void testModificar() {
        // Datos de prueba
        Long id = 1L;
        String nuevoNombre = "NuevoNombre";
        String nuevaDescripcion = "NuevaDescripción";
        Socio socioModificado = new Socio(id, nuevoNombre, nuevaDescripcion, nuevaDescripcion, 1000.0f, 1000.0f, 1000.0f, 1000.0f);

        // Configuración de comportamiento simulado del repositorio
        when(socioRepository.findById(eq(id))).thenReturn(Optional.of(new Socio(id, nuevaDescripcion, nuevaDescripcion, nuevaDescripcion, id, id, id, id/* Datos actuales del socio */)));
        when(socioRepository.save(any(Socio.class))).thenReturn(socioModificado);

        // Llamada al método bajo prueba
        SocioResponse socioResponse = socioService.modificar(socioModificado, id);

        // Verificación de resultados utilizando assertions de JUnit
        System.out.println("InfoList después de modificar: " + socioResponse.getInfoRestList());
        assertFalse(socioResponse.getInfoRestList().isEmpty());
        assertNotNull(socioResponse);
        assertFalse(socioResponse.getInfoList().isEmpty());
        System.out.println("InfoList después de modificar: " + socioResponse.getInfoRestList());
        assertFalse(socioResponse.getInfoRestList().isEmpty());

        // Verificación de que el método findById y save del repositorio fueron invocados
        verify(socioRepository, times(1)).findById(eq(id));
        verify(socioRepository, times(1)).save(eq(socioModificado));
    }
    @Test
    void testEliminar() {
        // Datos de prueba
        Long id = 1L;

        // Configuración de comportamiento simulado del repositorio
        when(socioRepository.findById(eq(id))).thenReturn(Optional.of(new Socio(id, null, null, null, id, id, id, id/* Datos actuales del socio */)));

        // Llamada al método bajo prueba
        SocioResponse socioResponse = socioService.eliminar(id);

        // Verificación de resultados utilizando assertions de JUnit
        assertNotNull(socioResponse);
        assertFalse(socioResponse.getInfoList().isEmpty());

        // Verificación de que el método findById y deleteById del repositorio fueron invocados
        verify(socioRepository, times(1)).findById(eq(id));
        verify(socioRepository, times(1)).deleteById(eq(id));
    }
    
}