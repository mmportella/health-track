package br.com.fiap.healthtrack.controller.peso;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.model.dao.PesoDAO;

@WebServlet("/peso/excluir")
public class PesoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PesoDeleteController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PesoDAO dao = new PesoDAO();
		long idPeso = Long.parseLong(request.getParameter("idPeso"));
		dao.delete(idPeso);

		response.sendRedirect("../peso");
		
	}

}
