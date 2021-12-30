package br.com.fiap.healthtrack.controller.perfil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/perfil/foto")
public class FotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FotoController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String idUser = (String) session.getAttribute("idUsuario");
		
		try {
			
		Part file = request.getPart("imagem");
		String fileName = idUser + ".jpeg";
		
		String uploadPath = "C:/Users/m.portella.filho/Desktop/health-track/src/main/webapp/assets/images/user/" + fileName;
		
		FileOutputStream fos = new FileOutputStream(uploadPath);
		InputStream is = file.getInputStream();
		
		byte[] data = new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("../perfil");
		
	}

}
