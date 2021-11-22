package br.com.fiap.healthtrack.controller.pressao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.model.beans.Pressao;
import br.com.fiap.healthtrack.model.dao.PressaoDAO;

@WebServlet("/pressao")
public class PressaoListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PressaoListController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String idUser = (String) session.getAttribute("idUsuario");
		long idUsuario = Long.parseLong(idUser);
		
		PressaoDAO dao = new PressaoDAO();
		List<Pressao> listaPressao = dao.getAll(idUsuario);
		
		request.setAttribute("listaPressao", listaPressao);
		request.getRequestDispatcher("pressoes/pressoes.jsp").forward(request, response);
		
	}
	
}
