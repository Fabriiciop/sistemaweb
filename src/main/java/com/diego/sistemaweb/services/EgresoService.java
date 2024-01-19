package com.diego.sistemaweb.services;


import org.springframework.stereotype.Service;

import com.diego.sistemaweb.controllers.response.EgresoResponse;
import com.diego.sistemaweb.entitys.Egreso;

@Service
public interface EgresoService {
    public EgresoResponse consultar();

    public EgresoResponse buscarPorId(Long id);

    public EgresoResponse crear(Egreso egreso);

    public EgresoResponse modificar(Egreso egreso, Long id);

    public EgresoResponse eliminar(Long id);

    public void info(String string);



    
}
