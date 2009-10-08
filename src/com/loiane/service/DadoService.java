package com.loiane.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.loiane.model.ColumnModel;
import com.loiane.model.StoreField;

/**
 * Gera dados aleatórios para preencher o grid dinamicamente
 * 
 * @author Loiane Groner
 */
public class DadoService {
	
	//limite de dados por página
	public static int LIMITE = 10;
	
	//número de colunas a serem geradas
	public static int NUMERO_COLUNAS = 3;
	
	//número de registros a serem gerados
	public static int TOTAL_REGISTROS = 100;
	
	/**
	 * Gera as colunas que serão usadas na configuração dinâmica
	 * do grid
	 * @return lista de ColumnModel
	 */
	public List<ColumnModel> geraColumnModel(){
		
		List<ColumnModel> colunas = new ArrayList<ColumnModel>(NUMERO_COLUNAS);
		
		for (int i=0 ;i<NUMERO_COLUNAS; i++){
			ColumnModel column = new ColumnModel();
			
			column.setDataIndex("coluna"+i);
			column.setHeader("COLUNA " + i);
			column.setWidth(200);
			column.setAlign("center");
			column.setSortable("true");
			
			colunas.add(column);
		}
		
		return colunas;
	}
	
	/**
	 * Gera os campos que serão usados para configurar dinamicamente
	 * o data Store
	 * @return lista de StoreField
	 */
	public List<StoreField> geraCamposStoreFiel(){
		
		List<StoreField> campos = new ArrayList<StoreField>(NUMERO_COLUNAS);
		
		for (int i=0 ;i<NUMERO_COLUNAS; i++){
			StoreField field = new StoreField();
			
			//precisa ser o mesmo que o dataIndex do ColumnModel
			field.setName("coluna"+i); 
			
			campos.add(field);
		}
		
		return campos;
	}
	
	/**
	 * Gera os resultados que irão preencher o grid
	 * @return lista de Resultados
	 */
	public List<HashMap<String, String>> geraDadosResultado(int inicio){
		
		ArrayList<HashMap<String, String>> dados;
		dados = new ArrayList<HashMap<String,String>>(LIMITE);
		
		for (int j=inicio; j<(inicio+LIMITE) && (j<TOTAL_REGISTROS); j++){
			HashMap<String, String> dado = new HashMap<String, String>(LIMITE);
			
			for (int i=0 ;i<NUMERO_COLUNAS; i++){
				//a chave deve ser a mesma do dataIndex do ColumnModel
				dado.put(("coluna"+i), "dado "+j);
			}
			dados.add(dado);
		}
		
		return dados;
	}
	
	/**
	 * Gera os metadados para configuração dinâmica do data Store
	 * @return mapa com os metadados
	 */
	public Map<String,Object> geraMetaDados(){
		Map<String,Object> metaDados = new HashMap<String,Object>(3);
		metaDados.put("root", "rows");
		metaDados.put("totalProperty", "total");
		metaDados.put("fields", geraCamposStoreFiel());
		
		return metaDados;
	}
}
