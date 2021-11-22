package br.com.fiap.healthtrack.controller.peso;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.model.beans.Peso;
import br.com.fiap.healthtrack.model.dao.PesoDAO;

@WebServlet("/peso/editar/gravar")
public class PesoEditGravarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PesoEditGravarController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Peso peso = new Peso();
			peso.setIdPeso(Long.parseLong(request.getParameter("idPeso")));
			peso.setDataPeso(request.getParameter("data"));
			
			String pesodot = request.getParameter("peso");
			pesodot = pesodot.replace(',', '.');
			float pesofloat = Float.parseFloat(pesodot);
			peso.setPeso(pesofloat);
		
			PesoDAO dao = new PesoDAO();
			dao.update(peso);
			
			
		} catch (Exception e) {
		}
		
		response.sendRedirect("../../peso");
		
	}

}
