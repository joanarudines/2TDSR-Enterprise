package br.com.fiap.main;

import java.rmi.Naming;

import br.com.fiap.bo.OperacaoBO;

public class RMIClient {

	public static void main(String[] args) throws Exception {
		//Recuperar o objeto para acessar os 
		//métodos remotos (projeto 12)
		
		OperacaoBO bo = (OperacaoBO) 
				Naming.lookup("rmi://localhost:1234/banco");
		
		int fatorial = bo.fatorial(6);
		System.out.println("Fatorial: " + fatorial);
		
		double raiz = bo.raiz(9);
		System.out.println("Raiz: " + raiz);
		
	}
	
}
