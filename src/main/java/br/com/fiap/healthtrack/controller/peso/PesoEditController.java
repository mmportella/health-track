package br.com.fiap.healthtrack.controller.peso;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.model.dao.PesoDAO;

@WebServlet("/peso/editar")
public class PesoEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PesoEditController() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response, long id) throws ServletException, IOException {
    	HttpSession session = request.getSession();
		String idUser = (String) session.getAttribute("idUsuario");
		request.setAttribute("idUser", idUser);
		PesoDAO dao = new PesoDAO();
		request.setAttribute("idPeso", id);
		request.setAttribute("data", dao.getById(id).getDataPeso());
		request.setAttribute("peso", dao.getById(id).getPeso());
		request.getRequestDispatcher("../pesos/editar.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long idPeso = Long.parseLong(request.getParameter("idPeso"));
		doGet(request,response,idPeso);
		
	}

}
