package br.com.fiap.healthtrack.controller.peso;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.model.beans.Peso;
import br.com.fiap.healthtrack.model.dao.PesoDAO;

@WebServlet("/peso/adicionar")
public class PesoAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PesoAddController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idUser = (String) session.getAttribute("idUsuario");
		request.setAttribute("idUser", idUser);
		request.getRequestDispatcher("../pesos/novo-peso.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		try {
			
		String idUser = (String) session.getAttribute("idUsuario");
		long idUsuario = Long.parseLong(idUser);
		Peso objpeso = new Peso();
		String pesodot = request.getParameter("peso");
		pesodot = pesodot.replace(',', '.');
		float peso = Float.parseFloat(pesodot);
		objpeso.setPeso(peso);
		String data = request.getParameter("data");
		objpeso.setDataPeso(data);
		PesoDAO dao = new PesoDAO();
		dao.add(idUsuario, objpeso);
		
		} catch (Exception e) {
			request.setAttribute("erro", "erro");
			doGet(request,response);
		}
		
		response.sendRedirect("../peso");
		
	}

}
