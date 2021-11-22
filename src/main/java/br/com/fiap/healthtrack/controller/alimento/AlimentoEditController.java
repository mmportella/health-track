package br.com.fiap.healthtrack.controller.alimento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.model.dao.AlimentoDAO;

@WebServlet("/alimento/editar")
public class AlimentoEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlimentoEditController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response, long id) throws ServletException, IOException {
		AlimentoDAO dao = new AlimentoDAO();
		request.setAttribute("idAlimento", id);
		request.setAttribute("kcal", dao.getById(id).getKcal());
		request.setAttribute("descricao", dao.getById(id).getDescricao());
		String data = dao.getById(id).getDataAlimento() + "T" + dao.getById(id).getHoraAlimento();
		request.setAttribute("data", data);
		request.getRequestDispatcher("../alimentos/editar.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long idAlimento = Long.parseLong(request.getParameter("idAlimento"));
		doGet(request,response,idAlimento);
		
	}

}
