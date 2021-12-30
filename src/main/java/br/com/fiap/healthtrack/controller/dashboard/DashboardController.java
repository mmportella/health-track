package br.com.fiap.healthtrack.controller.dashboard;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.healthtrack.model.beans.Peso;
import br.com.fiap.healthtrack.model.beans.Usuario;
import br.com.fiap.healthtrack.model.dao.PesoDAO;
import br.com.fiap.healthtrack.model.dao.PressaoDAO;
import br.com.fiap.healthtrack.model.dao.UsuarioDAO;

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DashboardController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String idUser = (String) session.getAttribute("idUsuario");
		long idUsuario = Long.parseLong(idUser);
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.get(idUsuario);
		
		// Dados
		String nomeUsuario = usuario.getNomeUsuario();
		
		String dob = usuario.getDataNascimento();
		byte idade = (byte) Period.between(LocalDate.parse(dob), LocalDate.now()).getYears();
		
		int dia = LocalDate.now().getDayOfMonth();
		int mes = LocalDate.now().getMonthValue();
		int ano = LocalDate.now().getYear();
		String stringHoje = dia + "/" + mes + "/" + ano;
		String hoje = stringHoje;
		
		float alt = usuario.getAltura() / 100.0f;
		String altura = String.format("%.2f", alt);
		
		request.setAttribute("idUser", idUser);
		request.setAttribute("nomeUsuario", nomeUsuario);
		request.setAttribute("idade", idade);
		request.setAttribute("hoje", hoje);
		request.setAttribute("altura", altura);
		
		// IMC
		PesoDAO daopeso = new PesoDAO();
		float imcf = daopeso.getLast(idUsuario) / (alt * alt);
		String imc = String.format("%.2f", imcf);
		String imcStatus = "IMC Normal";
		if (imcf < 18.5f & imcf > 0) {
			imcStatus = "IMC Baixo";
		} else if (imcf >= 18.5f & imcf <= 29.9f) {
			imcStatus = "IMC Normal";
		} else if (imcf == 0) {
			imcStatus = "Sem registro de peso";
		} else {
			imcStatus = "IMC Alto";
		}
		request.setAttribute("imc", imc);
		request.setAttribute("imcStatus", imcStatus);
		
		// Pressao
		PressaoDAO daopressao = new PressaoDAO();
		short sistolica = daopressao.getLastSistolica(idUsuario);
		short diastolica = daopressao.getLastDiastolica(idUsuario);
		
		String pressaoStatus = "Press„o Normal";
		if (sistolica >= 140 || diastolica >= 90) {
			pressaoStatus = "Press„o Alta";
		} else if (sistolica < 90 & sistolica > 0 || diastolica < 60 & diastolica > 0) {
			pressaoStatus = "Press„o Baixa";
		} else if(sistolica == 0 | diastolica == 0) {
			pressaoStatus = "Sem registro de press„o";
		} else {
			pressaoStatus = "Press„o Normal";
		}
		
		request.setAttribute("sistolica", sistolica);
		request.setAttribute("diastolica", diastolica);
		request.setAttribute("pressaoStatus", pressaoStatus);
		
		
		// Gr√°fico
		List<Peso> pesografico = daopeso.getLastSeven(idUsuario);
		
		try {
		String data0 = pesografico.get(0).getDataPeso();
		request.setAttribute("data0", data0);
		String data1 = pesografico.get(1).getDataPeso();
		request.setAttribute("data1", data1);
		String data2 = pesografico.get(2).getDataPeso();
		request.setAttribute("data2", data2);
		String data3 = pesografico.get(3).getDataPeso();
		request.setAttribute("data3", data3);
		String data4 = pesografico.get(4).getDataPeso();
		request.setAttribute("data4", data4);
		String data5 = pesografico.get(5).getDataPeso();
		request.setAttribute("data5", data5);
		String data6 = pesografico.get(6).getDataPeso();
		request.setAttribute("data6", data6);
		float peso0 = pesografico.get(0).getPeso();
		request.setAttribute("peso0", peso0);
		float peso1 = pesografico.get(1).getPeso();
		request.setAttribute("peso1", peso1);
		float peso2 = pesografico.get(2).getPeso();
		request.setAttribute("peso2", peso2);
		float peso3 = pesografico.get(3).getPeso();
		request.setAttribute("peso3", peso3);
		float peso4 = pesografico.get(4).getPeso();
		request.setAttribute("peso4", peso4);
		float peso5 = pesografico.get(5).getPeso();
		request.setAttribute("peso5", peso5);
		float peso6 = pesografico.get(6).getPeso();
		request.setAttribute("peso6", peso6);
		} catch (Exception e) {
			request.setAttribute("data0", hoje);
			request.setAttribute("data1", hoje);
			request.setAttribute("data2", hoje);
			request.setAttribute("data3", hoje);
			request.setAttribute("data4", hoje);
			request.setAttribute("data5", hoje);
			request.setAttribute("data6", hoje);
			request.setAttribute("peso0", 0);
			request.setAttribute("peso1", 0);
			request.setAttribute("peso2", 0);
			request.setAttribute("peso3", 0);
			request.setAttribute("peso4", 0);
			request.setAttribute("peso5", 0);
			request.setAttribute("peso6", 0);
		}
		
		request.getRequestDispatcher("dashboard/dashboard.jsp").forward(request, response);
	}


}
