package com.example.demo.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.demo.dto.VentasDto;
import com.example.demo.service.CargarArchivosService;
import com.example.demo.url.Url;
import com.example.demo.util.DatosNoEncontradosException;
import com.example.demo.util.ResponseEntityExceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cargar")
public class CargarArchivosRest {
	
	@Autowired
	private ResponseEntityExceptions responseExceptions;
	@Autowired
	CargarArchivosService service;
	
	//2.1 Guardar una lista
    @PostMapping(value = "/upload")
    public ResponseEntity<?>  readCSV(@RequestBody Url urlFile) {
        ResponseEntity<?> respuesta = null;
        try {
        File f=new File(urlFile.getUrlFile());
       
            Scanner lectura=new Scanner(f);
            List<VentasDto> listaArchivo = new ArrayList<>();
            boolean isONe=true;
            while(lectura.hasNextLine()) {   
                String linea = lectura.nextLine();
                String[] reader = linea.split("|");                        
                // LLENAR LISTA de la clase Dto           
                    if(!isONe) {
                        VentasDto v=new VentasDto();
                        v.setId(Integer.parseInt(reader[0]));
                        v.setFecha(reader[1]);
                        v.setEmpresasId(Integer.parseInt(reader[2]));
                        v.setFactura(Integer.parseInt(reader[3]));
                        v.setFechaVenta(reader[4]);
                        v.setFechaPago(reader[5]);
                        v.setImpaga(reader[6]);
                        v.setImpresa(reader[7]);
                        v.setFormaPago(reader[8]);
                        v.setTipoFactura(reader[9]);
                        v.setSubTotal(Double.parseDouble(reader[10]));
                        v.setSubTotalIva(Double.parseDouble(reader[11]));
                        v.setSubTotalCesc(Double.parseDouble(reader[12]));
                        v.setSubTotalDescuentos(Double.parseDouble(reader[13]));
                        v.setTotalaPagar(Double.parseDouble(reader[14]));
                        
                        System.out.println(v.toString());
                        listaArchivo.add(v);
                        respuesta = responseExceptions.createCustomizedResponse(null, 200,"0", "Success" );
                    }       
                    isONe= false;
            }
               
                System.out.print(service.guardarArchivo(listaArchivo));           
                        
        }catch(DatosNoEncontradosException a) {
            respuesta = responseExceptions.createCustomizedResponse(null, 409, a.getCod(), a.getMessage() );
        }catch(FileNotFoundException e) {
             e.printStackTrace();
        }catch(Exception exc) {
            respuesta = responseExceptions.createCustomizedResponse(null, 409,"409", "Error en el servicio" );
        }
      return respuesta;
    }

}
