package Taller2_punto6_lenguajes;

public class Token {

	public enum TokenType {
		OP,
		INTEGER,
		LETTER,
		SPACE;
	};
	private TokenType type;
	private String value;
	
	public Token() {
		this.type = null;
		this.value = null;
	}
	
	public Token(TokenType type, String value) {
		this.value = value;
		this.type = type;
	}

	public TokenType getType() {
		return type;
	}

	public void setType(TokenType type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public void setToken (TokenType type, String value){
		this.value = value;
		this.type = type;
	}
	
}
