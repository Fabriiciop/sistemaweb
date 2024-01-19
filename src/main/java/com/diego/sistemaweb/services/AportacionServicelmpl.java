package com.diego.sistemaweb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.diego.sistemaweb.controllers.response.AportacionResponse;
import com.diego.sistemaweb.controllers.response.InfoRest;
import com.diego.sistemaweb.entitys.Aportacion;
import com.diego.sistemaweb.repositories.AportacionRepository;

public class AportacionServicelmpl implements AportacionService{

    @Autowired
    private AportacionRepository aportacionRepository;

    
    @Override
    @Transactional(readOnly = true)
    public AportacionResponse consultar() {
        var aportacionResponse= new AportacionResponse();        
        var data = (List<Aportacion>) this.aportacionRepository.findAll();
        var infoList = new ArrayList<InfoRest>();
        aportacionResponse.setData(data);
        aportacionResponse.setInfoList(infoList);
        return aportacionResponse;
    }
    
    @Override
    @Transactional(readOnly = true)
    public AportacionResponse buscarPorId(Long id) {
        var aportacionResponse= new AportacionResponse();        
        var data = new ArrayList<Aportacion>();
        var infoList = new ArrayList<InfoRest>();
        var aportacionBuscada = this.aportacionRepository.findById(id);
        if(aportacionBuscada.isPresent()){
            data.add(aportacionBuscada.get());
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        aportacionResponse.setData(data);
        aportacionResponse.setInfoList(infoList);
        return aportacionResponse;
    }

    // @Override
    @Transactional
    public AportacionResponse crear(Aportacion aportacion) {
        var aportacionResponse= new AportacionResponse(); 
        var data = new ArrayList<Aportacion>();
        var infoList = new ArrayList<InfoRest>();
        data.add(this.aportacionRepository.save(aportacion));
        aportacionResponse.setData(data);
        aportacionResponse.setInfoList(infoList);
        return aportacionResponse;
    }

    @Override
    @Transactional
    public AportacionResponse modificar(Aportacion aportacion, Long id) {
        var aportacionResponse= new AportacionResponse();        
        var data = new ArrayList<Aportacion>();
        var infoList = new ArrayList<InfoRest>();
        var aportacionBuscada = this.aportacionRepository.findById(id);
        if(aportacionBuscada.isPresent()){
            aportacionBuscada.get().setCantidadAport(aportacion.getCantidadAport());
            aportacionBuscada.get().setSocio(aportacion.getSocio());
            aportacionBuscada.get().setMovimiento(aportacion.getMovimiento());
            data.add(this.aportacionRepository.save(aportacionBuscada.get()));
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        aportacionResponse.setData(data);
        aportacionResponse.setInfoList(infoList);
        return aportacionResponse;  
    }

    @Override
    @Transactional
    public AportacionResponse eliminar(Long id) {
        var aportacionResponse= new AportacionResponse();        
        var data = new ArrayList<Aportacion>();
        var infoList = new ArrayList<InfoRest>();
        var aportacionBuscada = this.aportacionRepository.findById(id);
        if(aportacionBuscada.isPresent()){
            this.aportacionRepository.deleteById(id);
        }else{
            infoList.add(new InfoRest(1,"Categoria no encontrada",1));
        }
        aportacionResponse.setData(data);
        aportacionResponse.setInfoList(infoList);
        return aportacionResponse;  
    }


    
}
