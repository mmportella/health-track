package br.com.fiap.healthtrack.controller.peso;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.model.beans.Peso;
import br.com.fiap.healthtrack.model.dao.PesoDAO;

@WebServlet("/peso")
public class PesoListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PesoListController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String idUser = (String) session.getAttribute("idUsuario");
		long idUsuario = Long.parseLong(idUser);
		
		PesoDAO dao = new PesoDAO();
		List<Peso> listaPeso = dao.getAll(idUsuario);
		
		request.setAttribute("listaPeso", listaPeso);
		request.getRequestDispatcher("pesos/pesos.jsp").forward(request, response);
		
	}

}
