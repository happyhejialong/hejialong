(function(window,mini,jkUtils){
	mini.parse();
	var ordersGrid=mini.get('ordersGrid');
	var verifyBtn=mini.get('verifyBtn');
	var splitBtn=mini.get('splitBtn');
	var mergeBtn=mini.get('mergeBtn');
	ordersGrid.setAjaxOptions({
		dataFilter:function(jsonStr){
			var json1=mini.clone(jsonStr);
			var json=JSON.parse(json1);
			var result={
				'total':500,
				'data':json.result.data
			};
			return JSON.stringify(result);
		}
	});
	var temp={};
	temp.tradeOrder={};
	temp.tradeOrder.tradeStatus=1;
	ordersGrid.set({
	    url:'/trade/list',
		type:'post',
	});
	ordersGrid.load({jsonStr:JSON.stringify(temp)});

	verifyBtn.on('click',function(){
		var rows=ordersGrid.getSelecteds();
		if(rows==null || rows.length==0){
			alert('请勾选后在进行审核');
			return;
		}
		var ids=[];
		for(var i=0;i<rows.length;i++){
			delete rows[i]._id;
			ids[i]=rows[i].id;
		}
		$.ajax({
			url:'/trade/verify?ids='+ids,
			type:'get',
		}).done(result=>{
			if(result.code=='200'){
				mini.showTips({'content':'审核成功','x':'center','y':'center',state:"success"});
				ordersGrid.load({jsonStr:JSON.stringify(temp)});
			}
		}).fail(error=>{
			alert(JSON.stringify(error));
			mini.showTips({'content':'审核失败','x':'center','y':'center',state:"fail"});
		});
	});

	mergeBtn.on('click',function(){
			var rows=ordersGrid.getSelecteds();
			var ids=[];
			for(var i=0;i<2;i++){
				delete rows[i]._id;
				ids[i]=rows[i].id;
			}
			$.ajax({
					url:'/trade/merge?ids='+ids,
					type:'get',
			}).done(result=>{
					if(result.code=='200'){
						mini.showTips({'content':'合并成功','x':'center','y':'center',state:"success"});
						ordersGrid.load({jsonStr:JSON.stringify(temp)});
					}else{
						mini.alert(JSON.stringify(result.msg));
						mini.showTips({'content':'合并失败','x':'center','y':'center',state:"fail"});
					}
			}).fail(error=>{
				mini.alert(JSON.stringify(error));
			});
	});

	splitBtn.on('click',function(){
		var row=ordersGrid.getSelecteds();
		if(row==null || row.length<1){
			alert('请勾选订单后操作');
		}
		row=row[0];
		orderInfoLocation(row.tradeId);
	});
	function orderInfoLocation(data) {
		inputFrame = mini.open({
			targetWindow: window,
			url: '/oms/split_order.html',
			width: "100%",
			height: "100%",
			allowResize: false,
			showHeader: false,
			showModal: true,
			onload: function() {
				var iframe = this.getIFrameEl();

				iframe.contentWindow.editPage.setData(data);
			},
			ondestroy: function(message) {
				if(message == "ok"){
					//mini.showTips({content:"保存成功",state:"success",x:"center",y:"center"})
					ordersGrid.load({jsonStr:JSON.stringify(temp)});
				}
			}
		});
}
})(window,mini,jkUtils)
