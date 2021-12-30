package br.com.fiap.healthtrack.controller.atividade;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.model.beans.Atividade;
import br.com.fiap.healthtrack.model.dao.AtividadeDAO;

@WebServlet("/atividade/adicionar")
public class AtividadeAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AtividadeAddController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idUser = (String) session.getAttribute("idUsuario");
		request.setAttribute("idUser", idUser);
		request.getRequestDispatcher("../atividades/nova-atividade.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		try {
		String idUser = (String) session.getAttribute("idUsuario");
		long idUsuario = Long.parseLong(idUser);
		
		Atividade atividade = new Atividade();
		String categoria = request.getParameter("categoria");
		atividade.setCategoria(categoria);
		Short kcal = Short.parseShort(request.getParameter("kcal"));
		atividade.setKcal(kcal);
		String descricao = request.getParameter("descricao");
		atividade.setDescricao(descricao);
		String data = request.getParameter("data");
		atividade.setDataAtividade(data);
		
		AtividadeDAO dao = new AtividadeDAO();
		dao.add(idUsuario, atividade);
		} catch (Exception e) {
			request.setAttribute("erro", "erro");
			doGet(request,response);
		}
		
		response.sendRedirect("../atividade");
	}

}
