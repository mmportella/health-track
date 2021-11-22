package br.com.fiap.healthtrack.controller.atividade;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.model.beans.Atividade;
import br.com.fiap.healthtrack.model.dao.AtividadeDAO;

@WebServlet("/atividade/editar/gravar")
public class AtividadeEditGravarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AtividadeEditGravarController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Atividade atv = new Atividade();
			atv.setIdAtividade(Long.parseLong(request.getParameter("idAtividade")));
			atv.setDataAtividade(request.getParameter("data"));
			atv.setKcal(Short.parseShort(request.getParameter("kcal")));
			atv.setCategoria(request.getParameter("categoria"));
			atv.setDescricao(request.getParameter("descricao"));
		
			AtividadeDAO dao = new AtividadeDAO();
			dao.update(atv);
		} catch (Exception e) {
		}
		
		response.sendRedirect("../../atividade");

	}

}
