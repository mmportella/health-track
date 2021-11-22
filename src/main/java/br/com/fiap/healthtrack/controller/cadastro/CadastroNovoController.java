package br.com.fiap.healthtrack.controller.cadastro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastro/novo")
public class CadastroNovoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroNovoController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String data = request.getParameter("data");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		request.setAttribute("nome", nome);
		request.setAttribute("data", data);
		request.setAttribute("email", email);
		request.setAttribute("senha", senha);
		request.getRequestDispatcher("completar-cadastro.jsp").forward(request, response);
	}

}
