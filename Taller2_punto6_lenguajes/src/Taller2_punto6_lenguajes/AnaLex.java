package Taller2_punto6_lenguajes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

import Taller2_punto6_lenguajes.Token.TokenType;

public class AnaLex {
	
	private String text;
	private Stack<Token> tokenStack;
	
	public AnaLex() {
		this.text = "";
		this.tokenStack = new Stack<Token>();
	}
	
	public AnaLex(String directory) {
		this.text = readFile(directory);
		this.tokenStack = new Stack<Token>();
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Stack<Token> getTokenStack() {
		return tokenStack;
	}

	public void setTokenStack(Stack<Token> tokenStack) {
		this.tokenStack = tokenStack;
	}
	
	public void identifyTokens(){
		String integerValue="";
		Stack<Token> tokenStackTemp = new Stack<Token>();
		
		for (int i = 0; i <this.text.length (); i++) {
			char c = this.text.charAt(i);
			Token token = new Token();
			if(c == ' ' || c == '|'){
				//System.out.println ("Espacio o Tabulación");
				continue;
			}else if(c == '*' || c == '+' || c == '-' || c == '/'){
				token.setToken(TokenType.OP, Character.toString(c));
				tokenStackTemp.push(token);
			}else if(c >= 'a' && c <= 'z'){
				token.setToken(TokenType.LETTER, ""+Character.toString(c));
				tokenStackTemp.push(token);
			}else if( (c >= '0' && c <= '9') ){
				integerValue = integerValue+c;			
				if( i+1 == this.text.length () || (this.text.charAt(i+1) < '0' || this.text.charAt(i+1) > '9')){
					token.setToken(TokenType.INTEGER, integerValue);
					tokenStackTemp.push(token);
					integerValue="";
				}else {
					continue;
				}
			}else {
				System.out.println ("Error de Léxico");
			} 
		} 
		while(!tokenStackTemp.isEmpty()){
			this.tokenStack.push(tokenStackTemp.pop());
		}
	}

	private String readFile(String directory) {
		String line = "";
		String text = "";
		
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    
	    try {
	         archivo = new File (directory);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         while((line=br.readLine())!=null){
	        	text = text + line;
	         }
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }finally{
	        try{                    
	            if( null != fr ){   
	               fr.close();     
	           }                  
	        }catch (Exception e2){ 
	            e2.printStackTrace();
	        }
	    }
	    return text;
	}

}
