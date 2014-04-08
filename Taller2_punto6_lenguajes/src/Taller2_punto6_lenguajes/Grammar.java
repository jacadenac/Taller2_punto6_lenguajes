package Taller2_punto6_lenguajes;

import java.util.ArrayList;

public class Grammar {

	public enum Nonterminal {
		EXPR,
		PRIMARY,
		OP,
		INTEGER,
		LETTER,
	};
	
	private ArrayList<ArrayList<Nonterminal>> optionsToProduce;

	public Grammar() {
		this.optionsToProduce = new ArrayList<ArrayList<Nonterminal>>();
	}
	
	public  ArrayList<ArrayList<Nonterminal>> produce(Nonterminal nonterminal){
		this.optionsToProduce = new ArrayList<ArrayList<Nonterminal>>();
		ArrayList<Nonterminal> produced = new ArrayList<Nonterminal>();
		switch(nonterminal){
			case EXPR:
				produced.add(Nonterminal.OP);
				produced.add(Nonterminal.EXPR);
				produced.add(Nonterminal.EXPR);
				optionsToProduce.add(produced);
				produced = new ArrayList<Nonterminal>();
				produced.add(Nonterminal.PRIMARY);
				optionsToProduce.add(produced);
				break;
			case PRIMARY:
				produced.add(Nonterminal.INTEGER);
				optionsToProduce.add(produced);
				produced = new ArrayList<Nonterminal>();
				produced.add(Nonterminal.LETTER);
				optionsToProduce.add(produced);
				break;
			case OP:
				break;
			case INTEGER:
				break;
			case LETTER:
				break;
				
		}
		return optionsToProduce;
	}
	
	public Nonterminal startSymbol(){
		return Nonterminal.EXPR;
	}
	
	public boolean produceATerminal(Nonterminal nonterminal){
		if(nonterminal == Nonterminal.EXPR || nonterminal == Nonterminal.PRIMARY){
			return false;
		} else {
			return true;
		}
	}
	
}
