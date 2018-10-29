package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import entity.UsuarioEmpresa;

public class logadoEmpresa implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//tem q fazer a ligação desse emp com oq esta no UsuarioMBean pois o mesmo ja esta preenchido 
		
		UsuarioEmpresa emp=null;
		
		if(emp == null) {
			
			
		}
		
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	
	// olha a foto q tem no seu celular!
	
	
}






















