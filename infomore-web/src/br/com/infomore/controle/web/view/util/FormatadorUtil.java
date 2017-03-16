package br.com.infomore.controle.web.view.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatadorUtil {
    public static String formataDateParaString(Date data) {
	if (data == null)
	    return null;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	return sdf.format(data);
    }

    public static Date formataStringParaDate(String data) {
	if (data == null)
	    return null;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date dataFormatada = null;
	try {
	    dataFormatada = sdf.parse(data);
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return dataFormatada;
    }
}
