package Taller2_punto6_lenguajes;

import java.util.Stack;

import Taller2_punto6_lenguajes.Grammar.Nonterminal;

public class main {

	public static void main(String[] args) {
		
		System.out.println( "Nombres: \t" +
							"Esteban Parra Rodriguez\n\t\t" +
							"Juan David Alejandro Cadena Cedano\n\t\t" + 
							"Juan Sebastian Hernandez Serrato\n\t\t" +
							"Daniel Buitrago C�ceres\n\t\t" +
							"Brian Alexander Navarrete" +
							"\n");
		System.out.println("\t\t\tTALLER 2 - PUNTO 6\n");
		
		AnaLex anaLex = new AnaLex("example/programa1.txt");
		anaLex.identifyTokens();
		System.out.println("Texto le�do: \n "+ anaLex.getText());
		System.out.println("\nPila de Tokens: \n");
		Stack<Token> stackTokens = anaLex.getTokenStack();
		for(int i=stackTokens.size()-1;i>=0;i--){
			System.out.println(" <"+stackTokens.get(i).getType().toString()+", "+stackTokens.get(i).getValue()+">");
		}
		
		System.out.println("\nAn�lisis Sintactico: \n");
		AnaSint anaSint = new AnaSint(stackTokens);
		boolean rightExpression = anaSint.parse(Nonterminal.EXPR);
		if(rightExpression){
			System.out.println("\nLA EXPRESI�N ES CORRECTA!!");
		} else {
			System.out.println("\nLA EXPRESI�N ES INCORRECTA!!");
		}
		
	}

}



