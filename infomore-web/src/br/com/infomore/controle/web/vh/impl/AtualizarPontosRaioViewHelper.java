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

import br.com.infomore.controle.web.vh.IViewHelper;
import br.com.infomore.core.aplicacao.Resultado;
import br.com.infomore.dominio.EntidadeDominio;
import br.com.infomore.dominio.LimiteRaio;
import br.com.infomore.dominio.Ponto;

public class AtualizarPontosRaioViewHelper implements IViewHelper {

    @Override
    public EntidadeDominio getEntity(HttpServletRequest request) {
	/*
	 * String latNE = request.getParameter("latNE"); String lngNE =
	 * request.getParameter("lngNE"); String latSW =
	 * request.getParameter("latSW"); String lngSW =
	 * request.getParameter("lngSW");
	 */

	try {
	    StringBuilder sb = new StringBuilder();
	    BufferedReader br = request.getReader();
	    String str = new String();
	    while ((str = br.readLine()) != null) {
		sb.append(str);
	    }

	    String jsonString = sb.toString();

	    HashMap<String, Double> limiteRaioMap = new Gson().fromJson(jsonString, HashMap.class);

	    LimiteRaio limiteRaio = new LimiteRaio();
	    limiteRaio.setPontoNE(new Ponto());
	    limiteRaio.setPontoSW(new Ponto());

	    limiteRaio.getPontoNE().setLatitude(limiteRaioMap.get("latNE"));
	    limiteRaio.getPontoNE().setLongitude(limiteRaioMap.get("lngNE"));

	    limiteRaio.getPontoSW().setLatitude(limiteRaioMap.get("latSW"));
	    limiteRaio.getPontoSW().setLongitude(limiteRaioMap.get("lngSW"));

	    return limiteRaio;

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return null;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {

	List<EntidadeDominio> listaPontos = resultado.getEntidades();
	Gson gson = new Gson();

	String json = gson.toJson(listaPontos);

	response.setContentType("application/json");
	PrintWriter writter = response.getWriter();
	writter.printf(json);
	writter.flush();
	writter.close();

    }

}
