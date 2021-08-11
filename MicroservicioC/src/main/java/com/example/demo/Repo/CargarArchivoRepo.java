package com.example.demo.Repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.model.Empresas;
import com.example.demo.model.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.VentasRepository;
import com.example.demo.commons.AppConstans;
import com.example.demo.util.DatosNoEncontradosException;

@Component
public class CargarArchivoRepo {
	
	// inyeccion
	@Autowired
	VentasRepository repo;
	@Autowired
	private Environment env;
	
	  public String guardarDatos(List<Ventas> listaFacturas) {
       
        List<Ventas> v = new ArrayList<>();
       
        try {
           
            if(listaFacturas !=null) {
            	repo.saveAll(listaFacturas).forEach(v::add);
            }else {
                throw new DatosNoEncontradosException(env.getProperty(AppConstans.codigoErrorConflicto),
                                          env.getProperty(AppConstans.codigoErrorConflictoGuardar));
            }
        }catch(DatosNoEncontradosException e) {
            throw e;
        }catch (Exception e) {
           
            e.printStackTrace();

            throw new DatosNoEncontradosException(env.getProperty(AppConstans.codigoErrorConflicto),
                                      env.getProperty(AppConstans.codigoErrorConflictoGuardar));
           
        }
       
        return "venta guardada" + v.stream().map(u -> u.getId()).collect((Collectors.toList()));
    }
}
