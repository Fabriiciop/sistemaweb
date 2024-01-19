package com.diego.sistemaweb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.diego.sistemaweb.controllers.response.InfoRest;
import com.diego.sistemaweb.controllers.response.IngresoResponse;

import com.diego.sistemaweb.entitys.Ingreso;

import com.diego.sistemaweb.repositories.IngresoRepository;


public class IngresoServicelmpl implements IngresoService{
    @Autowired
    private IngresoRepository ingresoRepository;


    
    @Override
    @Transactional(readOnly = true)
    public IngresoResponse consultar() {
        var ingresoResponse= new IngresoResponse();        
        var data = (List<Ingreso>) this.ingresoRepository.findAll();
        var infoList = new ArrayList<InfoRest>();
        ingresoResponse.setData(data);
        ingresoResponse.setInfoList(infoList);
        return ingresoResponse;
    }
    
    @Override
    @Transactional(readOnly = true)
    public IngresoResponse buscarPorId(Long id) {
        var ingresoResponse= new IngresoResponse();        
        var data = new ArrayList<Ingreso>();
        var infoList = new ArrayList<InfoRest>();
        var ingresoBuscada = this.ingresoRepository.findById(id);
        if(ingresoBuscada.isPresent()){
            data.add(ingresoBuscada.get());
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        ingresoResponse.setData(data);
        ingresoResponse.setInfoList(infoList);
        return ingresoResponse;
    }

    @Override
    @Transactional
    public IngresoResponse crear(Ingreso ingreso) {
        var ingresoResponse= new IngresoResponse(); 
        var data = new ArrayList<Ingreso>();
        var infoList = new ArrayList<InfoRest>();
        data.add(this.ingresoRepository.save(ingreso));
        ingresoResponse.setData(data);
        ingresoResponse.setInfoList(infoList);
        return ingresoResponse;
    }

    @Override
    @Transactional
    public IngresoResponse modificar(Ingreso ingreso, Long id) {

        var ingresoResponse= new IngresoResponse();        
        var data = new ArrayList<Ingreso>();
        var infoList = new ArrayList<InfoRest>();
        var ingresoBuscada = this.ingresoRepository.findById(id);
        if(ingresoBuscada.isPresent()){
            ingresoBuscada.get().setDescripcion(ingreso.getDescripcion());
            data.add(this.ingresoRepository.save(ingresoBuscada.get()));
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        ingresoResponse.setData(data);
        ingresoResponse.setInfoList(infoList);
        return ingresoResponse;  
    }

    @Override
    @Transactional
    public IngresoResponse eliminar(Long id) {
        var ingresoResponse= new IngresoResponse();        
        var data = new ArrayList<Ingreso>();
        var infoList = new ArrayList<InfoRest>();
        var socioBuscada = this.ingresoRepository.findById(id);
        if(socioBuscada.isPresent()){
            this.ingresoRepository.deleteById(id);
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        ingresoResponse.setData(data);
        ingresoResponse.setInfoList(infoList);
        return ingresoResponse;  
    }

    @Override
    public void info(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'info'");
    }







}
