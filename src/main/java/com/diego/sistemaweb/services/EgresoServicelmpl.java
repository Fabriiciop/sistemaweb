package com.diego.sistemaweb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.diego.sistemaweb.controllers.response.EgresoResponse;
import com.diego.sistemaweb.controllers.response.InfoRest;

import com.diego.sistemaweb.entitys.Egreso;

import com.diego.sistemaweb.repositories.EgresoRepository;


import jakarta.transaction.Transactional;

public class EgresoServicelmpl implements EgresoService{
    @Autowired
    private EgresoRepository egresoRepository;


    
    @Override

    public EgresoResponse consultar() {
        var egresoResponse= new EgresoResponse();        
        var data = (List<Egreso>) this.egresoRepository.findAll();
        var infoList = new ArrayList<InfoRest>();
        egresoResponse.setData(data);
        egresoResponse.setInfoList(infoList);
        return egresoResponse;
    }
    
    @Override
    @Transactional
    public EgresoResponse buscarPorId(Long id) {
        var egresoResponse= new EgresoResponse();        
        var data = new ArrayList<Egreso>();
        var infoList = new ArrayList<InfoRest>();
        var egresoBuscada = this.egresoRepository.findById(id);
        if(egresoBuscada.isPresent()){
            data.add(egresoBuscada.get());
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        egresoResponse.setData(data);
        egresoResponse.setInfoList(infoList);
        return egresoResponse;
    }

    @Override
    @Transactional
    public EgresoResponse crear(Egreso egreso) {
        var egresoResponse= new EgresoResponse(); 
        var data = new ArrayList<Egreso>();
        var infoList = new ArrayList<InfoRest>();
        data.add(this.egresoRepository.save(egreso));
        egresoResponse.setData(data);
        egresoResponse.setInfoList(infoList);
        return egresoResponse;
    }

    @Override
    @Transactional
    public EgresoResponse modificar(Egreso egreso, Long id) {

        var egresoResponse= new EgresoResponse();        
        var data = new ArrayList<Egreso>();
        var infoList = new ArrayList<InfoRest>();
        var egresoBuscada = this.egresoRepository.findById(id);
        if(egresoBuscada.isPresent()){
            egresoBuscada.get().setDescripcion(egreso.getDescripcion());
            data.add(this.egresoRepository.save(egresoBuscada.get()));
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        egresoResponse.setData(data);
        egresoResponse.setInfoList(infoList);
        return egresoResponse;  
    }

    @Override
    @Transactional
    public EgresoResponse eliminar(Long id) {
        var egresoResponse= new EgresoResponse();        
        var data = new ArrayList<Egreso>();
        var infoList = new ArrayList<InfoRest>();
        var socioBuscada = this.egresoRepository.findById(id);
        if(socioBuscada.isPresent()){
            this.egresoRepository.deleteById(id);
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        egresoResponse.setData(data);
        egresoResponse.setInfoList(infoList);
        return egresoResponse;  
    }

    @Override
    public void info(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'info'");
    }













}
