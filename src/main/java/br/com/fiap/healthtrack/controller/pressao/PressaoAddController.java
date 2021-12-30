package br.com.fiap.healthtrack.controller.pressao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.model.beans.Pressao;
import br.com.fiap.healthtrack.model.dao.PressaoDAO;

@WebServlet("/pressao/adicionar")
public class PressaoAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PressaoAddController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idUser = (String) session.getAttribute("idUsuario");
		request.setAttribute("idUser", idUser);
		request.getRequestDispatcher("../pressoes/nova-pressao.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		try {
		String idUser = (String) session.getAttribute("idUsuario");
		long idUsuario = Long.parseLong(idUser);
		
		Pressao pressao = new Pressao();
		
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
		
		String data = request.getParameter("data");
		pressao.setDataPressao(data);
		
		PressaoDAO dao = new PressaoDAO();
		dao.add(idUsuario, pressao);
		} catch (Exception e) {
			request.setAttribute("erro", "erro");
			doGet(request,response);
		}
		
		response.sendRedirect("../pressao");
	}

}
