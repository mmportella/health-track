package br.com.fiap.healthtrack.controller.atividade;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.model.dao.AtividadeDAO;

@WebServlet("/atividade/editar")
public class AtividadeEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AtividadeEditController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response, long id) throws ServletException, IOException {
		AtividadeDAO dao = new AtividadeDAO();
		request.setAttribute("idAtividade", id);
		request.setAttribute("kcal", dao.getById(id).getKcal());
		request.setAttribute("descricao", dao.getById(id).getDescricao());
		String data = dao.getById(id).getDataAtividade() + "T" + dao.getById(id).getHoraAtividade();
		request.setAttribute("data", data);
		request.getRequestDispatcher("../atividades/editar.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long idAtividade = Long.parseLong(request.getParameter("idAtividade"));
		doGet(request,response,idAtividade);
		
	}

}
