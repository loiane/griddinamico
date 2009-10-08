package com.loiane.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.loiane.service.DadoService;

/**
 * Controller - Spring
 * 
 * @author Loiane Groner
 */
public class ContatoController extends MultiActionController  {

	private DadoService dadoService;
	
	public ModelAndView getStoreFiedJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//obtém o parâmetro de início
		String iniParam = request.getParameter("start");
		int inicio = (iniParam == null) ? 0 : Integer.parseInt(iniParam);
		
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", DadoService.TOTAL_REGISTROS);
		modelMap.put("rows", dadoService.geraDadosResultado(inicio));
		
		//só precisa dos metadados na primeira vez
		if (inicio == 0){
			modelMap.put("metaData", dadoService.geraMetaDados());
		}
		
		return new ModelAndView("jsonView", modelMap);
		
	}
	
	public ModelAndView getColumnsJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("rows", dadoService.geraColumnModel());
		
		return new ModelAndView("jsonView", modelMap);
		
	}

	/**
	 * Para uso do Spring - DI
	 * @param dadoService
	 */
	public void setDadoService(DadoService dadoService) {
		this.dadoService = dadoService;
	}

}
