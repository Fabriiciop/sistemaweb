package com.diego.sistemaweb.services;


import org.springframework.stereotype.Service;

import com.diego.sistemaweb.controllers.response.AportacionResponse;
import com.diego.sistemaweb.entitys.Aportacion;

@Service
public interface /*class*/ AportacionService {
    public AportacionResponse consultar();

    public AportacionResponse buscarPorId(Long id);

    public AportacionResponse crear(Aportacion aportacion);

    public AportacionResponse modificar(Aportacion aportacion, Long id);

    public AportacionResponse eliminar(Long id);




    // Otras operaciones relacionadas con el socio
}