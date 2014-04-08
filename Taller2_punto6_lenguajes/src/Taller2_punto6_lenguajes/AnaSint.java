package Taller2_punto6_lenguajes;

import java.util.ArrayList;
import java.util.Stack;

import Taller2_punto6_lenguajes.Grammar.Nonterminal;

public class AnaSint {

	private Stack<Token> tokens;
	Grammar grammar;

	public AnaSint(Stack<Token> tokens) {
		this.tokens = new Stack<Token>();
		this.tokens = tokens;
		this.grammar = new Grammar();
	}
	
	public boolean parse(Nonterminal startSymbol){
		boolean right=false;

		if(!tokens.isEmpty()){	
			ArrayList<ArrayList<Nonterminal>> optionsToProduce = new ArrayList<ArrayList<Nonterminal>>();
			optionsToProduce = this.grammar.produce(startSymbol);
			
			System.out.println(" ----------------------------------------------------------- ");
			System.out.println(" START SYMBOL = " + startSymbol.toString() );
			System.out.print(" optionsToProduce = ");
			int contador = 1;

			for(ArrayList<Nonterminal> produced: optionsToProduce){
				if(tokens.isEmpty()){
					right = false;
				}else {				
					System.out.println(" Opción"+ contador);
					System.out.print(" Produce: ");
					for(Nonterminal nonterminal: produced){					
							System.out.print(nonterminal.toString()+ ", ");
					}
					System.out.print("\n");
					
					for(Nonterminal nonterminal: produced){
						if(grammar.produceATerminal(nonterminal)){
							if(tokens.lastElement().getType().toString() == nonterminal.toString()){
								System.out.println(" Elem_Pila: " + tokens.lastElement().getType().toString() + " == Elem_Tree: " + nonterminal.toString() );
								System.out.println(" ¡¡Se eliminó un elemento de la pila!!");
								tokens.pop();
							}
							else {
								System.out.println(" Elem_Pila: " + tokens.lastElement().getType().toString() + " != Elem_Tree: " + nonterminal.toString() );
								//return false;
								break;
							}
						} else {
							right = parse(nonterminal);
						}
					}
					contador++;
				}
				
			}
			if (tokens.isEmpty()){
				return true;
			}
		} else {
			right = true;
		}
		return right;
	}

}
