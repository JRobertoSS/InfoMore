package br.com.infomore.controle.web.vh.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import br.com.infomore.controle.web.vh.IViewHelper;
import br.com.infomore.controle.web.view.TipoMensagemView;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.Categoria;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.LimiteRaio;
import br.com.infomore.dominio.MeuLocal;
import br.com.infomore.dominio.Ponto;
import br.com.infomore.dominio.Usuario;

public class DetalhesMeuLocalViewHelper implements IViewHelper {

	@Override
	public EntidadeDominio getEntity(HttpServletRequest request) {

		try {
			StringBuilder sb = new StringBuilder();
			BufferedReader br = request.getReader();
			String str = new String();
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}

			String jsonString = sb.toString();

			HashMap<String, Object> limiteRaioMap = new Gson().fromJson(jsonString, HashMap.class);

			MeuLocal meuLocal = new MeuLocal();
			meuLocal.setDescricao((String) limiteRaioMap.get("descricao"));
			meuLocal.setNome((String) limiteRaioMap.get("nomeLocal"));
			meuLocal.setRaio((Double) limiteRaioMap.get("raio"));
			meuLocal.setLatitude((Double) limiteRaioMap.get("latitude"));
			meuLocal.setLongitude((Double) limiteRaioMap.get("longitude"));

			LinkedTreeMap<String, LinkedTreeMap<String, Double>> mapLimiteRaio = (LinkedTreeMap<String, LinkedTreeMap<String, Double>>) limiteRaioMap
					.get("limiteRaio");
			LinkedTreeMap<String, Double> mapaPontoNE = mapLimiteRaio.get("pontoNE");
			LinkedTreeMap<String, Double> mapaPontoSW = mapLimiteRaio.get("pontoSW");

			LimiteRaio limiteRaio = new LimiteRaio();

			limiteRaio.setPontoNE(new Ponto());
			limiteRaio.getPontoNE().setLatitude(mapaPontoNE.get("latitude"));
			limiteRaio.getPontoNE().setLongitude(mapaPontoNE.get("longitude"));

			limiteRaio.setPontoSW(new Ponto());
			limiteRaio.getPontoSW().setLatitude(mapaPontoSW.get("latitude"));
			limiteRaio.getPontoSW().setLongitude(mapaPontoSW.get("longitude"));

			meuLocal.setLimiteRaio(limiteRaio);

			meuLocal.setUsuario((Usuario) request.getSession().getAttribute("usuario"));

			request.getSession().setAttribute("meuLocal", meuLocal);

			return null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.getRequestDispatcher("view/detalhesMeuLocal.jsp").forward(request, response);

	}

}
