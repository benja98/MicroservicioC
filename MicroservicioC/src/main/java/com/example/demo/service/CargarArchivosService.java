package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.CargarArchivoRepo;
import com.example.demo.commons.AppConstans;
import com.example.demo.dto.VentasDto;
import com.example.demo.model.Ventas;
import com.example.demo.util.DatosNoEncontradosException;
import com.example.demo.model.Empresas;


@Service
@Component
public class CargarArchivosService {
	
	@Autowired
	private Environment env;
	@Autowired
	CargarArchivoRepo repo;
	
	public String guardarArchivo(List<VentasDto> ventasDto) {
		
        // 1. creando un arreglo de persona para pasarle los datos de la lista  PersonaDto:
        List<Ventas> listaFacturas = new ArrayList<>();
   
   try {
        
       // 2. bucle forEach para recorrer la lista de la clase VentasDto:
       for (VentasDto i : ventasDto) {
                  // instancia de mi clase ventas para Setiarla.

			Ventas v = new Ventas();
			v.setId(i.getId());
			v.setFecha(i.getFecha());

			// mandando a llamar la clase para setiar objeto(LLAVE FORANEA)
			Empresas e = new Empresas();
			e.setId(i.getEmpresasId());
			v.setEmpresasId(e);
			v.setFactura(i.getFactura());
			v.setFechaVenta(i.getFechaVenta());
			v.setFechaPago(i.getFechaPago());
			v.setImpaga(i.getImpaga());
			v.setImpresa(i.getImpresa());
			v.setFormaPago(i.getFormaPago());
			v.setTipoFactura(i.getTipoFactura());
			v.setSubTotal(i.getSubTotal());
			v.setSubTotalIva(i.getSubTotalIva());
			v.setSubTotalCesc(i.getSubTotalCesc());
			v.setSubTotalDescuentos(i.getSubTotalDescuentos());
			v.setTotalaPagar(i.getTotalaPagar());

			listaFacturas.add(v);                           // agregandola a mi lista ventas.



           System.out.println("IMPRIMIENDO LO QUE SE A GUARDADO EN LA LISTA");
           System.out.println("ID:  " + v.getId());
           System.out.println("Empresa: " + v.getEmpresasId());
           System.out.println("numero de factura " + v.getFactura());
           System.out.println("Fecha de venta: " + v.getFechaVenta());
           System.out.println("Fecha de pago " + v.getFechaPago());
           System.out.println("Factura pagada " + v.getImpaga());
           System.out.println("Factura impresa " + v.getImpresa());
           System.out.println("Forma de pago " + v.getFormaPago());
           System.out.println("Tipo de factura " + v.getTipoFactura());
           System.out.println("Sub Total de venta " + v.getSubTotal());
           System.out.println("Sub Total iva " + v.getSubTotalIva());
           System.out.println("Sub Total de venta " + v.getSubTotal());
           System.out.println("Descuento " + v.getSubTotalDescuentos());
           System.out.println("Total a pagar " + v.getTotalaPagar());

       } 
   }catch (DatosNoEncontradosException a) {
       throw a;                                           // En esta linea Mandando la excepcion a la capa Rest.
   } catch (Exception exc) {
       // Haciendo uso de Logger y un throw new para mostrarlo en esta capa actual.
       throw new DatosNoEncontradosException(env.getProperty(AppConstans.codigoError),
                                 env.getProperty(AppConstans.mensajeError) + ", ho el otro servicio se a caido");
   }
   	return repo.guardarDatos(listaFacturas);
	}
}
