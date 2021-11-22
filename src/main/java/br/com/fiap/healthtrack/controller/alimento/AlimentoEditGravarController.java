package br.com.fiap.healthtrack.controller.alimento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.model.beans.Alimento;
import br.com.fiap.healthtrack.model.dao.AlimentoDAO;

@WebServlet("/alimento/editar/gravar")
public class AlimentoEditGravarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlimentoEditGravarController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Alimento alimento = new Alimento();
			alimento.setIdAlimento(Long.parseLong(request.getParameter("idAlimento")));
			alimento.setDataAlimento(request.getParameter("data"));
			alimento.setKcal(Short.parseShort(request.getParameter("kcal")));
			alimento.setCategoria(request.getParameter("categoria"));
			alimento.setDescricao(request.getParameter("descricao"));
			
			AlimentoDAO dao = new AlimentoDAO();
			dao.update(alimento);
		} catch (Exception e) {
		}
			
		response.sendRedirect("../../alimento");
		
	}

}
