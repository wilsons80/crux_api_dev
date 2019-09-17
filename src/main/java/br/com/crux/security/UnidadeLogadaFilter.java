package br.com.crux.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.crux.cmd.CarregarUnidadeLogadaCmd;
import br.com.crux.cmd.GetUsuarioLogadoCmd;
import br.com.crux.cmd.SaveUsuarioLogadoCmd;
import br.com.crux.service.exception.ApiError;
import br.com.crux.to.AcessoUnidadeTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class UnidadeLogadaFilter implements Filter {
	

	@Autowired private CarregarUnidadeLogadaCmd carregarUnidadeLogadaCmd;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private SaveUsuarioLogadoCmd saveUsuarioLogadoCmd;
	
	public UnidadeLogadaFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		try {
			
			if(req.getRequestURI().contains("/unidade/logada/")) {
				String unidadeLogada = req.getRequestURI().replaceAll("/unidade/logada/", "");
				
				Authentication auth = getUsuarioLogadoCmd.getAuthentication();
				saveUsuarioLogadoCmd.save(auth);
				
				AcessoUnidadeTO unidadeLogadaTO = carregarUnidadeLogadaCmd.carregarUnidadeLogada(Long.valueOf(unidadeLogada));
				UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
				usuarioLogado.setUnidadeLogada(unidadeLogadaTO);
			}
			
		} catch (Exception e) {
			ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), new Date());
			PrintWriter writer = res.getWriter();
			
			ObjectMapper mapper = new ObjectMapper();
			String apiErrorString = mapper.writeValueAsString(apiError);
			
			writer.write(apiErrorString);
			
			res.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			res.setStatus(HttpStatus.BAD_REQUEST.value());
			
			return;
		}
		
		
		chain.doFilter(request, res);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//WebApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig.getServletContext());
		//this.usuarioLogadoHolder = appContext.getBean(UsuarioLogadoHolder.class);
	}

}
