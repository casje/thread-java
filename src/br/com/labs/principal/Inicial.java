package br.com.labs.principal;

import java.util.concurrent.CountDownLatch;

import br.com.labs.calculadora.Fatorial;
import br.com.labs.calculadora.NumeroPerfeito;
import br.com.labs.calculadora.NumeroPrimo;
import br.com.labs.paralela.FatorialThread;
import br.com.labs.paralela.NumeroPerfeitoThread;
import br.com.labs.paralela.NumeroPrimoThread;

public class Inicial {
	
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("---------------------------------------------\n"
				         + "--- Maneira Sequencial\n"
				         + "---------------------------------------------\n");
		Sequencial(6);
		
		
		System.out.println("\n\n---------------------------------------------\n"
		                 + "--- Maneira Paralela\n"
		                 + "---------------------------------------------\n");
		Paralela(6);
	}
	
	public static void Sequencial(int numero) throws InterruptedException
	{
		final long inicioSequencial = System.currentTimeMillis();
		System.out.println("Programa para o lab - sequencial");
		
		Fatorial objFatorial = new Fatorial();
		NumeroPrimo objNumeroPrimo = new NumeroPrimo();
		NumeroPerfeito objNumeroPerfeito = new NumeroPerfeito();
		
		
		objFatorial.Calcular(numero);		
		objNumeroPrimo.VerificarSeNumeroEhPrimo(numero);
		objNumeroPerfeito.VerificarSeNumeroEhPerfeito(numero);
		
		final long finalSequencial = System.currentTimeMillis() - inicioSequencial;
		
		System.out.println("Finalizou o programa sequencial em " + finalSequencial + " milissegundos");
	}
	
	public static void Paralela(int numero) throws InterruptedException
	{
		final long inicioSequencial = System.currentTimeMillis();
		System.out.println("Programa para o lab - paralelo");
		
		CountDownLatch latch = new CountDownLatch(3);
		
		Runnable fatorial = new FatorialThread(latch, numero);
		Runnable numeroPrimo = new NumeroPrimoThread(latch, numero);
		Runnable numeroPerfeito = new NumeroPerfeitoThread(latch, numero);
		
		Thread tarefaFatorial = new Thread(fatorial);
		Thread tarefaNumeroPrimo = new Thread(numeroPrimo);
		Thread tarefaNumeroPerfeito = new Thread(numeroPerfeito);
		
		tarefaFatorial.start();
		tarefaNumeroPrimo.start();
		tarefaNumeroPerfeito.start();
		
		latch.await();
		
		final long finalParalela = System.currentTimeMillis() - inicioSequencial;
		
		System.out.println("Finalizou o programa paralelo em " + finalParalela + " milissegundos");
	}

}
