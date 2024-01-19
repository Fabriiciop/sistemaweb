package com.diego.sistemaweb.services;

import com.diego.sistemaweb.controllers.response.SocioResponse;
import com.diego.sistemaweb.entitys.Socio;

public interface /*class*/ SocioService {
    public SocioResponse consultar();

    public SocioResponse buscarPorId(Long id);

    public SocioResponse crear(Socio socio);

    public SocioResponse modificar(Socio socio, Long id);

    public SocioResponse eliminar(Long id);

    public SocioResponse restarInversionConAportacion(Long id_socio, Float cantidadAportacion); 

    // Otras operaciones relacionadas con el socio
}