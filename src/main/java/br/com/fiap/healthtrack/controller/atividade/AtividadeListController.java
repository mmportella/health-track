package br.com.fiap.healthtrack.controller.atividade;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.model.beans.Atividade;
import br.com.fiap.healthtrack.model.dao.AtividadeDAO;

@WebServlet("/atividade")
public class AtividadeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AtividadeListController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String idUser = (String) session.getAttribute("idUsuario");
		long idUsuario = Long.parseLong(idUser);
		
		AtividadeDAO dao = new AtividadeDAO();
		List <Atividade> listaAtividade = dao.getAll(idUsuario);
		
		request.setAttribute("idUser", idUser);
		request.setAttribute("listaAtividade", listaAtividade);
		request.getRequestDispatcher("atividades/atividades.jsp").forward(request, response);
		
	}

}
