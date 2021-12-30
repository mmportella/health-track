package br.com.fiap.healthtrack.controller.perfil;

import java.io.ByteArrayInputStream;
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

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.azure.storage.blob.specialized.BlockBlobClient;

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
			
			String fileName = idUser + ".jpeg";
		
			BlobContainerClient blobContainerClient = new BlobContainerClientBuilder()
			    .endpoint("https://healthtrackstorageacc.blob.core.windows.net/")
			    .sasToken("")
			    .containerName("perfil")
			    .buildClient();
			BlockBlobClient blockBlobClient = blobContainerClient.getBlobClient(fileName).getBlockBlobClient();
		
			Part file = request.getPart("imagem");
			InputStream is = file.getInputStream();
			byte[] dataSample = new byte[is.available()];
			is.read(dataSample);
		
			try (ByteArrayInputStream dataStream = new ByteArrayInputStream(dataSample)) {
			
				blockBlobClient.upload(dataStream, dataSample.length, true);
		    
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("../perfil");
		
	}

}
