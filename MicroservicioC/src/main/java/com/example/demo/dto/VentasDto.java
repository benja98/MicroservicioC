package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date; 

public class VentasDto implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	//Variables:
	private int id; 
    private String fecha; 
    private int empresasId; 
    private int factura; 
    private String fechaVenta;  
    private String fechaPago; 
    private String impaga; 
    private String impresa; 
    private String formaPago; 
    private String tipoFactura; 
    private Double subTotal; 
    private Double subTotalIva; 
    private Double subTotalCesc; 
    private Double subTotalDescuentos; 
    private Double totalaPagar;
    
    //constructores:
	public VentasDto(int id, String fecha, int empresasId, int factura, String fechaVenta, String fechaPago, String impaga,
			String impresa, String formaPago, String tipoFactura, Double subTotal, Double subTotalIva,
			Double subTotalCesc, Double subTotalDescuentos, Double totalaPagar) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.empresasId = empresasId;
		this.factura = factura;
		this.fechaVenta = fechaVenta;
		this.fechaPago = fechaPago;
		this.impaga = impaga;
		this.impresa = impresa;
		this.formaPago = formaPago;
		this.tipoFactura = tipoFactura;
		this.subTotal = subTotal;
		this.subTotalIva = subTotalIva;
		this.subTotalCesc = subTotalCesc;
		this.subTotalDescuentos = subTotalDescuentos;
		this.totalaPagar = totalaPagar;
	}
	public VentasDto() {
		super();
	}
	
	//Get y set:
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getEmpresasId() {
		return empresasId;
	}
	public void setEmpresasId(int empresasId) {
		this.empresasId = empresasId;
	}
	public int getFactura() {
		return factura;
	}
	public void setFactura(int factura) {
		this.factura = factura;
	}
	public String getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getImpaga() {
		return impaga;
	}
	public void setImpaga(String impaga) {
		this.impaga = impaga;
	}
	public String getImpresa() {
		return impresa;
	}
	public void setImpresa(String impresa) {
		this.impresa = impresa;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public String getTipoFactura() {
		return tipoFactura;
	}
	public void setTipoFactura(String tipoFactura) {
		this.tipoFactura = tipoFactura;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public Double getSubTotalIva() {
		return subTotalIva;
	}
	public void setSubTotalIva(Double subTotalIva) {
		this.subTotalIva = subTotalIva;
	}
	public Double getSubTotalCesc() {
		return subTotalCesc;
	}
	public void setSubTotalCesc(Double subTotalCesc) {
		this.subTotalCesc = subTotalCesc;
	}
	public Double getSubTotalDescuentos() {
		return subTotalDescuentos;
	}
	public void setSubTotalDescuentos(Double subTotalDescuentos) {
		this.subTotalDescuentos = subTotalDescuentos;
	}
	public Double getTotalaPagar() {
		return totalaPagar;
	}
	public void setTotalaPagar(Double totalaPagar) {
		this.totalaPagar = totalaPagar;
	}
    
    
    


}
