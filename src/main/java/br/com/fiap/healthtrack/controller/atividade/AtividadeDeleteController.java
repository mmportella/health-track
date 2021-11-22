package br.com.fiap.healthtrack.controller.atividade;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.model.dao.AtividadeDAO;

@WebServlet("/atividade/excluir")
public class AtividadeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AtividadeDeleteController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AtividadeDAO dao = new AtividadeDAO();
		long idAtividade = Long.parseLong(request.getParameter("idAtividade"));
		dao.delete(idAtividade);

		response.sendRedirect("../atividade");
		
	}

}
