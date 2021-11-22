package br.com.fiap.healthtrack.controller.alimento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.model.beans.Alimento;
import br.com.fiap.healthtrack.model.dao.AlimentoDAO;

@WebServlet("/alimento/adicionar")
public class AlimentoAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlimentoAddController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("../alimentos/novo-alimento.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		try {
		String idUser = (String) session.getAttribute("idUsuario");
		long idUsuario = Long.parseLong(idUser);
		
		Alimento alimento = new Alimento();
		String categoria = request.getParameter("categoria");
		alimento.setCategoria(categoria);
		short kcal = Short.parseShort(request.getParameter("kcal"));
		alimento.setKcal(kcal);
		String descricao = request.getParameter("descricao");
		alimento.setDescricao(descricao);
		String data = request.getParameter("data");
		alimento.setDataAlimento(data);
		
		AlimentoDAO dao = new AlimentoDAO();
		dao.add(idUsuario, alimento);
		} catch (Exception e) {
			request.setAttribute("erro", "erro");
			doGet(request,response);
		}
		
		response.sendRedirect("../alimento");
	}

}
