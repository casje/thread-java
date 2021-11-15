package br.com.labs.calculadora;

import java.util.concurrent.TimeUnit;

public class Fatorial {
	
	public int Calcular(int numero) throws InterruptedException
	{
		int resultado = numero;
		
		while(numero > 1)
		{
			TimeUnit.MILLISECONDS.sleep(500);

			resultado = resultado * (numero - 1);
			numero--;
		}
		
		System.out.println("Fatorial de " + numero + " é: " + resultado);
		
		return resultado;
	}

}
