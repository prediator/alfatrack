package ua.pogodin.webapp.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class GetInfo {
	@WebMethod
	public String doSome(String str){
		return "str = " + str;
	}
}
