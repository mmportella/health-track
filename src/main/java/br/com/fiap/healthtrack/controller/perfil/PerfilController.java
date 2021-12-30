package br.com.fiap.healthtrack.controller.perfil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.model.beans.Usuario;
import br.com.fiap.healthtrack.model.dao.UsuarioDAO;

@WebServlet("/perfil")
public class PerfilController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PerfilController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String idUser = (String) session.getAttribute("idUsuario");
		long idUsuario = Long.parseLong(idUser);
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.get(idUsuario);
		
		request.setAttribute("nome", usuario.getNomeUsuario());
		request.setAttribute("data", usuario.getDataNascimento());
		request.setAttribute("email", usuario.getEmail());
		request.setAttribute("altura", usuario.getAltura());
		
		String genero = usuario.getGenero();
		if (genero.equals("M")) {
			genero = "Masculino";
		} else {
			genero = "Feminino";
		}
		
		request.setAttribute("genero", genero);
		
		request.getRequestDispatcher("perfil/perfil.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario user = dao.login(email, senha);
		
		if (user.getIdUsuario() == 0) {
			doGet(request, response);
		} else {
			String novasenha = request.getParameter("novasenha");
			String novasenha2 = request.getParameter("novasenha2");
			if (novasenha.equals(novasenha2)) {
				
				String nome = request.getParameter("nome");
				String data = request.getParameter("data");
				String genero = request.getParameter("genero");
				short altura = Short.parseShort(request.getParameter("altura"));
				
				user.setNomeUsuario(nome);
				user.setDataNascimento(data);
				user.setGenero(genero);
				user.setAltura(altura);
				user.setEmail(email);
				
				if (novasenha != "") {
					user.setSenha(novasenha);
				}
				
				dao.update(user);
				
				
			} else {
				doGet(request, response);
			}
		}
		
		doGet(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
