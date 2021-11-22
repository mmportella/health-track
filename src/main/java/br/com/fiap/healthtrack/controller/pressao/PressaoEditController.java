package br.com.fiap.healthtrack.controller.pressao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.model.dao.PressaoDAO;

@WebServlet("/pressao/editar")
public class PressaoEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PressaoEditController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response, long id) throws ServletException, IOException {

		PressaoDAO dao = new PressaoDAO();
		request.setAttribute("idPressao", id);
		request.setAttribute("data", dao.getById(id).getDataPressao());
		request.setAttribute("sistolica", dao.getById(id).getPressaoSistolica());
		request.setAttribute("diastolica", dao.getById(id).getPressaoDiastolica());
		request.getRequestDispatcher("../pressoes/editar.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long idPressao = Long.parseLong(request.getParameter("idPressao"));
		doGet(request,response,idPressao);
		
	}

}
