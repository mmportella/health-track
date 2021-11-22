package br.com.fiap.healthtrack.controller.alimento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.model.dao.AlimentoDAO;

@WebServlet("/alimento/excluir")
public class AlimentoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlimentoDeleteController() {
        super();
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AlimentoDAO dao = new AlimentoDAO();
		long idAlimento = Long.parseLong(request.getParameter("idAlimento"));
		dao.delete(idAlimento);

		response.sendRedirect("../alimento");
		
	}

}
