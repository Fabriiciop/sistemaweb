package com.diego.sistemaweb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import com.diego.sistemaweb.services.SocioService;
import com.diego.sistemaweb.controllers.response.InfoRest;
import com.diego.sistemaweb.controllers.response.SocioResponse;
import com.diego.sistemaweb.entitys.Socio;
import com.diego.sistemaweb.repositories.SocioRepository;

import org.springframework.transaction.annotation.Transactional;
// @Service
public class SocioServicelmpl implements SocioService{
    @Autowired
    private SocioRepository socioRepository;

    
    @Override
    @Transactional(readOnly = true)
    public SocioResponse consultar() {
        var socioResponse= new SocioResponse();        
        var data = (List<Socio>) this.socioRepository.findAll();
        var infoList = new ArrayList<InfoRest>();
        socioResponse.setData(data);
        socioResponse.setInfoList(infoList);
        return socioResponse;
    }
    
    @Override
    @Transactional(readOnly = true)
    public SocioResponse buscarPorId(Long id) {
        var socioResponse= new SocioResponse();        
        var data = new ArrayList<Socio>();
        var infoList = new ArrayList<InfoRest>();
        var socioBuscada = this.socioRepository.findById(id);
        if(socioBuscada.isPresent()){
            data.add(socioBuscada.get());
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        socioResponse.setData(data);
        socioResponse.setInfoList(infoList);
        return socioResponse;
    }

    // @Override
    @Transactional
    public SocioResponse crear(Socio socio) {
        var socioResponse = new SocioResponse();
        var data = new ArrayList<Socio>();
        var infoList = new ArrayList<InfoRest>();

        try {
            // Intenta guardar el socio
            Socio socioGuardado = this.socioRepository.save(socio);
            data.add(socioGuardado);
            socioResponse.setData(data);
            infoList.add(new InfoRest(1, "Socio creado exitosamente", 1));
        } catch (Exception e) {
            // Captura excepciones y agrega un mensaje a infoList en caso de error
            infoList.add(new InfoRest(2, "Error al crear el socio: " + e.getMessage(), 0));
        }

        socioResponse.setInfoList(infoList);
        return socioResponse;
    }

    @Override
    @Transactional
    public SocioResponse modificar(Socio socio, Long id) {
        var socioResponse = new SocioResponse();        
        var data = new ArrayList<Socio>();
        var infoList = new ArrayList<InfoRest>();
        var socioBuscada = this.socioRepository.findById(id);
        if (socioBuscada.isPresent()) {
            socioBuscada.get().setNombre(socio.getNombre());
            socioBuscada.get().setDescripcion(socio.getDescripcion());
            data.add(this.socioRepository.save(socioBuscada.get()));
        } else {
            infoList.add(new InfoRest(1, "Socio no encontrado", 1));
        }
        socioResponse.setData(data);
        socioResponse.setInfoList(infoList);  // Asegúrate de establecer infoList en socioResponse
        return socioResponse; 
    }

    @Override
    @Transactional
    public SocioResponse eliminar(Long id) {
        var socioResponse = new SocioResponse();
        var data = new ArrayList<Socio>();
        var infoList = new ArrayList<InfoRest>();
        
        var socioBuscada = this.socioRepository.findById(id);
        if (socioBuscada.isPresent()) {
            this.socioRepository.deleteById(id);
            data.add(socioBuscada.get());
        } else {
            infoList.add(new InfoRest(1, "Socio no encontrado", 1));
            socioResponse.setInfoList(infoList);
        }
        
        socioResponse.setData(data);
        socioResponse.setInfoList(infoList);
        return socioResponse; 
    }
        @Override
    @Transactional
    public SocioResponse restarInversionConAportacion(Long id_socio, Float cantidadAportacion) {
        SocioResponse socioResponse = new SocioResponse();
        List<Socio> data = new ArrayList<>();
        List<InfoRest> infoList = new ArrayList<>();

        Socio socio = socioRepository.findById(id_socio).orElse(null);

        if (socio == null) {
            infoList.add(new InfoRest(1, "Socio no encontrado", 1));
        } else {
            // Restar la cantidad de aportación de la inversión total
            float nuevaInversion = socio.getInversionTotal() - cantidadAportacion;
            socio.setInversionTotal(nuevaInversion);
            // Guardar el socio actualizado
            socioRepository.save(socio);
            data.add(socio);
        }

        socioResponse.setData(data);
        socioResponse.setInfoList(infoList);

        return socioResponse;
    }


}
