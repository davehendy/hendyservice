package uk.me.hendy.hendyservice.message;

public enum Message {
	
	NO_MENU("Menu not found");
	
	String message;
	
	Message(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
		
	}
}
