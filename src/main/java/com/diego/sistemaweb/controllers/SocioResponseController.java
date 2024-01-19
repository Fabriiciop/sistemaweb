package com.diego.sistemaweb.controllers;

import java.util.ArrayList;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;


import com.diego.sistemaweb.controllers.response.InfoRest;
import com.diego.sistemaweb.controllers.response.SocioResponse;
import com.diego.sistemaweb.entitys.Socio;
import com.diego.sistemaweb.services.SocioService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/v1")
public class SocioResponseController {

	@Autowired
	private SocioService socioService;
        private static final Logger log = LoggerFactory.getLogger(SocioResponseController.class);
	
	@GetMapping("/categorias")
	public ResponseEntity<SocioResponse> consulta(){
            log.info("Inicio del método consulta()");   
            try{
                var categoriaResponse=this.socioService.consultar();                
                categoriaResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
            }catch(Exception e1){
                var socioResponse = new SocioResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                socioResponse.setInfoList(infoList);
                return new ResponseEntity<>(socioResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
	}
        
        @GetMapping("/Socios/{id}")
	public ResponseEntity<SocioResponse> consultaPorId(@PathVariable Long id){
            log.info("Inicio del método consultaPorId()");            
            try{
                var socioResponse=this.socioService.buscarPorId(id);
                socioResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return new ResponseEntity<>(socioResponse, HttpStatus.OK);
            }catch(Exception e1){
                var socioResponse = new SocioResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                socioResponse.setInfoList(infoList);
                return new ResponseEntity<>(socioResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
	}
        
   
        
        
        
        @PostMapping("/socios")
	public ResponseEntity<SocioResponse> crear(@RequestBody Socio socio){
            log.info("Inicio del método crear(Categoria categoria)");            
            try{
                var socioResponse=this.socioService.crear(socio);
                socioResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return new ResponseEntity<>(socioResponse, HttpStatus.CREATED);
            }catch(Exception e1){                
                var socioResponse = new SocioResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                socioResponse.setInfoList(infoList);                
                return new ResponseEntity<>(socioResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
	
	@PutMapping("/categorias/{id}")
	public ResponseEntity<SocioResponse> actualizar(@RequestBody Socio socio, @PathVariable Long id){
            log.info("Inicio del método actualizar()");            
            try{
                var socioResponse=this.socioService.modificar(socio, id);
                socioResponse.getInfoList().add(new InfoRest(1,"Respuesta Ok",1));
                return new ResponseEntity<>(socioResponse, HttpStatus.OK);
            }catch(Exception e1){
                var categoriaResponse = new SocioResponse();            
                var infoList = new ArrayList<InfoRest>();
                infoList.add(new InfoRest(2,e1.getMessage(),0));
                categoriaResponse.setInfoList(infoList);
                return new ResponseEntity<>(categoriaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }	
	}
	@PostMapping("/socios/{id_socio}/restar-inversion")
    public ResponseEntity<SocioResponse> restarInversionConAportacion(
        @PathVariable Long id_socio,
        @RequestBody Float cantidadAportacion
    ) {
        log.info("Inicio del método restarInversionConAportacion()");
        try {
            var socioResponse = this.socioService.restarInversionConAportacion(id_socio, cantidadAportacion);
            socioResponse.getInfoList().add(new InfoRest(1, "Respuesta Ok", 1));
            return new ResponseEntity<>(socioResponse, HttpStatus.OK);
        } catch (Exception e1) {
            var socioResponse = new SocioResponse();
            var infoList = new ArrayList<InfoRest>();
            infoList.add(new InfoRest(2, e1.getMessage(), 0));
            socioResponse.setInfoList(infoList);
            return new ResponseEntity<>(socioResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Otros endpoints para operaciones con socios
}

