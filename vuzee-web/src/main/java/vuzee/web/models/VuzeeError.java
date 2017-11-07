package vuzee.web.models;

import java.util.Map;

public class VuzeeError {

    public Integer status;
    public String error;
    public String message;
    public String timeStamp;
    public String trace;
	/**
	 * @param status
	 * @param error
	 * @param message
	 * @param timeStamp
	 * @param trace
	 */
	public VuzeeError(Integer status, String error, String message, String timeStamp, String trace) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
		this.timeStamp = timeStamp;
		this.trace = trace;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getTrace() {
		return trace;
	}
	public void setTrace(String trace) {
		this.trace = trace;
	}
   
	

}
