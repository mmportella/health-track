package br.com.fiap.healthtrack.controller.pressao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.model.beans.Pressao;
import br.com.fiap.healthtrack.model.dao.PressaoDAO;

@WebServlet("/pressao/editar/gravar")
public class PressaoEditGravarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PressaoEditGravarController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Pressao pressao = new Pressao();
			
			pressao.setIdPressao(Long.parseLong(request.getParameter("idPressao")));
			pressao.setDataPressao(request.getParameter("data"));
			
			short sistolica = Short.parseShort(request.getParameter("sistolica"));
			if (sistolica < 25) {
				sistolica = (short) (sistolica * 10); // Caso a pessoa não forneça a pressão em mmHg
			}
			pressao.setPressaoSistolica(sistolica);
			
			short diastolica = Short.parseShort(request.getParameter("diastolica"));
			if (diastolica < 25) {
				diastolica = (short) (diastolica * 10); // Caso a pessoa não forneça a pressão em mmHg
			}
			pressao.setPressaoDiastolica(diastolica);
			
			PressaoDAO dao = new PressaoDAO();
			dao.update(pressao);
			
		} catch (Exception e) {
		}
		
		response.sendRedirect("../../pressao");
		
	}

}
