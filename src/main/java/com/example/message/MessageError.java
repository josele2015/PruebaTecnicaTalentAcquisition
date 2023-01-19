package com.example.message;

public class MessageError {
	private String message;
	private String debugMessage;
//	   private List<ApiSubError> subErrors;
	
	public MessageError( Exception ex) {
		   this.message = "Unexpected error";
	       if(ex==null) {
	    	   this.message = "";
		       this.debugMessage = "";		          
	       }else {

		       this.debugMessage = Trace(ex.getStackTrace()) ;
	       }
	}

	public MessageError(String message, Exception ex) {
		   this.message = message;
	       if(ex==null) {
	    	   this.message = "";
		       this.debugMessage = "";		          
	       }else {
	    	   
		       this.debugMessage = Trace(ex.getStackTrace()) ;
	       }
	}

	public String Trace(StackTraceElement[] StackTrace) {
		String Strace="";
		for(int i=0;i<StackTrace.length;i++) {
			Strace=Strace+StackTrace[i]+" \n ";
		}
		return Strace;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}
}
