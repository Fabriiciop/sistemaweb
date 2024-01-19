package com.diego.sistemaweb.controllers.response;

import java.util.ArrayList;
import java.util.List;

import com.diego.sistemaweb.entitys.Socio;

public class SocioResponse extends ResponseRest<Socio> {

    public SocioResponse() {
        setInfoRestList(new ArrayList<>());
    }
    public List<InfoRest> getInfoRestList() {
        return super.getInfoList();
    }

    public void setInfoRestList(List<InfoRest> infoList) {
        super.setInfoList(infoList);
    }
}
