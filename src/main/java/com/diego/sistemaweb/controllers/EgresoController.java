package com.diego.sistemaweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.diego.sistemaweb.controllers.response.EgresoResponse;
import com.diego.sistemaweb.controllers.response.InfoRest;

import com.diego.sistemaweb.services.EgresoService;


import java.util.ArrayList;


@RestController
@RequestMapping("/api/Egreso")
public class EgresoController {

    @Autowired
    private EgresoService egresoService;


    @GetMapping("/descipcion")
    public EgresoResponse consulta(){
        egresoService.info("Inicio del método consulta()");   
        try{
            var egresoResponse=this.egresoService.consultar();                
            egresoResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return egresoResponse;
            }catch(Exception e1){
                var egresoResponse = new EgresoResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                egresoResponse.setInfoList(infoList);
                return egresoResponse;
            }
	}

}

