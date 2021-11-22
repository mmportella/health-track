package br.com.fiap.healthtrack.controller.pressao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.model.dao.PressaoDAO;

@WebServlet("/pressao/excluir")
public class PressaoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PressaoDeleteController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PressaoDAO dao = new PressaoDAO();
		long idPressao = Long.parseLong(request.getParameter("idPressao"));
		dao.delete(idPressao);

		response.sendRedirect("../pressao");
		
	}

}
