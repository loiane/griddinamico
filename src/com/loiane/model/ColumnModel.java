package com.loiane.model;

/**
 * Define as configurações de uma coluna do grid.
 * Para saber mais e outras opções de configurações, visite:
 * http://extjs.com/deploy/ext/docs/output/Ext.grid.ColumnModel.html
 * e olhe a seção Config Option
 * 
 * @author Loiane Groner
 * @see http://extjs.com/deploy/ext/docs/output/Ext.grid.ColumnModel.html
 */
public class ColumnModel {
	
	/*
	 * Uso:
	 * var colModel = new Ext.grid.ColumnModel([
	 * {header: "Ticker", width: 60, sortable: true},
	 * {header: "Company Name", width: 150, sortable: true},
	 * {header: "Market Cap.", width: 100, sortable: true},
	 * {header: "$ Sales", width: 100, sortable: true},
	 * {header: "Employees", width: 100, sortable: true}
 	 * ]);
	 */
	
	/**
	 * (Opcional) Seta o alinhamento - CSS das colunas e dados
	 * no grid.
	 * Por padrão, é indefinido.
	 * Opções:
	 * <li>center</li> - centro
	 * <li>left</li> - esquerda
	 * <li>right</li> - direita
	 */
	private String align;
	
	/**
	 * Nome do campo na definição do Ext.data.Record do Ext.data.Store.
	 * Utilizado para fazer o 'casamento' das configurações
	 */
	private String dataIndex;
	
	/**
	 * Texto que aparece no cabeçalho do grid
	 */
	private String header;
	
	/**
	 * Define se a coluna poderá ser ordenada.
	 * true se a ordenação é permitida, false para o contrário.
	 */
	private String sortable;
	
	/**
	 * Tamanho inicial da largura da coluna (em pixels).
	 * Exemplo proibido: width:"50%"
	 * Exemplo permitido: width:"50"
	 */
	private int width;
	

	/**
	 * Construtor com parâmetros
	 * @param align
	 * @param dataIndex
	 * @param header
	 * @param sortable
	 * @param width
	 */
	public ColumnModel(String align, String dataIndex, String header,
			String sortable, int width) {
		super();
		this.align = align;
		this.dataIndex = dataIndex;
		this.header = header;
		this.sortable = sortable;
		this.width = width;
	}
	
	
	/**
	 * Construtor padrão
	 */
	public ColumnModel() {
		super();
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getDataIndex() {
		return dataIndex;
	}

	public void setDataIndex(String dataIndex) {
		this.dataIndex = dataIndex;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getSortable() {
		return sortable;
	}

	public void setSortable(String sortable) {
		this.sortable = sortable;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
}
