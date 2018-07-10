package view;


import common.dominios.Cuenta;

import java.util.EventObject;

public class RequestAccountEvent extends EventObject{
	private Cuenta cuenta;
	
	public RequestAccountEvent(Object source){
		super(source);
	}
	
	public RequestAccountEvent(Object source, Cuenta cuenta){
		super(source);
		this.cuenta = cuenta;
	}	
	
	public Cuenta getCuenta(){
		return cuenta;
	}
	
	public String toString(){
		return cuenta.toString();
	}
}
