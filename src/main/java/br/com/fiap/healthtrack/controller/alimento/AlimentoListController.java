package br.com.fiap.healthtrack.controller.alimento;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.model.beans.Alimento;
import br.com.fiap.healthtrack.model.dao.AlimentoDAO;

@WebServlet("/alimento")
public class AlimentoListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlimentoListController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String idUser = (String) session.getAttribute("idUsuario");
		long idUsuario = Long.parseLong(idUser);
		
		AlimentoDAO dao = new AlimentoDAO();
		List<Alimento> listaAlimento = dao.getAll(idUsuario);
		
		request.setAttribute("idUser", idUser);
		request.setAttribute("listaAlimento", listaAlimento);
		request.getRequestDispatcher("alimentos/alimentos.jsp").forward(request, response);
		
	}

}
