package com.diego.sistemaweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.diego.sistemaweb.controllers.response.InfoRest;
import com.diego.sistemaweb.controllers.response.IngresoResponse;

import com.diego.sistemaweb.services.IngresoService;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/ingresos")
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;

    @GetMapping("/descipcion")
    public IngresoResponse consulta(){
        ingresoService.info("Inicio del método consulta()");   
        try{
            var ingresoResponse=this.ingresoService.consultar();                
            ingresoResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return ingresoResponse;
            }catch(Exception e1){
                var ingresoResponse = new IngresoResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                ingresoResponse.setInfoList(infoList);
                return ingresoResponse;
            }
	}

 
}