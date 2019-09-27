package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.to.ParametrosTO;

@Component
public class GetTimeTokenExpiredCmd {

	@Autowired
	private GetParametrosCmd getParametrosCmd;
	

	public Integer getTimeExpieredToken() {
		ParametrosTO paramExpiredJWT = getParametrosCmd.getByCodigo("EXPIRED_JWT");
		
		if( Boolean.valueOf(paramExpiredJWT.getValor()) == Boolean.TRUE ) {
			
			ParametrosTO paramExpiredJWTTime = getParametrosCmd.getByCodigo("EXPIRED_JWT_TIME");
			Integer time = Integer.valueOf(paramExpiredJWTTime.getValor());
			
			return time;
		}
		
		return null;
	}
	
}
