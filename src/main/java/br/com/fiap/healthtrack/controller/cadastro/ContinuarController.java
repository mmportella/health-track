package br.com.fiap.healthtrack.controller.cadastro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.healthtrack.model.beans.Usuario;
import br.com.fiap.healthtrack.model.dao.UsuarioDAO;

@WebServlet("/cadastro/continuar")
public class ContinuarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContinuarController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setNomeUsuario(request.getParameter("nome"));
		usuario.setDataNascimento(request.getParameter("data"));
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setAltura(Short.parseShort(request.getParameter("altura")));
		usuario.setGenero(request.getParameter("genero"));
		
		UsuarioDAO dao = new UsuarioDAO();
		int c = dao.add(usuario);
		
		if (c == 1) {
			response.sendRedirect("../index.jsp");
		}
		
	}

}
