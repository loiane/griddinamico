Ext.onReady(function(){

	var columns = [];
	var sm = new Ext.grid.CheckboxSelectionModel();
	columns[0] = sm;
	var gridColModel = new Ext.grid.ColumnModel(columns);
	var index = 1;
	
	//cria as colunas
	var jsonstore = new Ext.data.Store({
		proxy: new Ext.data.HttpProxy(
			new Ext.data.Connection({
				url:'getColumnsJson.jsonAction'
			})
		),
		reader:new Ext.data.JsonReader({
			root:'rows',
			fields:['header','align','sortable','width','dataIndex']
		}),
		listeners: {
	    'load': function () {            
		jsonstore.each(function(r) {
			columns[index] = { header: r.data['header'],
							   align: r.data['align'], 
							   sortable: r.data['sortable'],
							   width: r.data['width'],
							   dataIndex: r.data['dataIndex']};
	        index++;
	      });
	      gridColModel.setConfig(columns);
	    }
	  }

	});
	
	jsonstore.load();
	
	//carrega os dados
	var data = new Ext.data.Store({
		proxy: new Ext.data.HttpProxy(
			new Ext.data.Connection({
				url:'getStoreFiedJson.jsonAction'
			})
		),
		reader:new Ext.data.JsonReader({})
	});

	var cm = gridColModel;


    // cria o grid
    var grid = new Ext.grid.GridPanel({
    	autoHeight:true,
		width:600,
		region: 'center',
		split: true,
		border:true,
		forceFit:true,
		store:data,
		sm: sm,
		cm:cm,
		title: 'Grid Dinâmico - Extjs',
		frame:true,
		bbar:new Ext.PagingToolbar({
			pageSize:10,
			store:data,
			displayInfo:true,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			emptyMsg:'sem dados'
		})
    });
    
    data.load({params: {meta: true, start: 0}});

    //div do grid
    grid.render('grid-dinamico');
});