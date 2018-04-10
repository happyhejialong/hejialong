(function(window,mini,jkUtils){
	mini.parse();
	var okBtn=mini.get('okBtn');
	var cancelBtn=mini.get('cancelBtn');
	var tradeId=mini.get('tradeId');
	var postFee=mini.get('postFee');
	var tradeOrder={};
	tradeId.on('valuechanged',function(e){
		var tradeIdValue=tradeId.getValue();
		if(tradeIdValue==null || tradeIdValue==""){
			return;
		}
		$.ajax({
			url:'/trade/getTradeOrder?tradeId='+tradeIdValue, 
			type:'get'
		}).done(result=>{
				if(result.code=='200' && JSON.stringify(result.result.data)!='[]'){
					tradeOrder=result.result.data;
					$("#msg").html("<font color='green'>正确</font>"); 
				}
				else{
					$("#msg").html("<font color='red'>错误</font>"); 
				}
		})
	});
	
	okBtn.on('click',function(e){
		var tradeIdValue=tradeId.getValue();
		var postFeeValue=postFee.getValue();
		if(tradeIdValue==null || tradeIdValue==""){
			alert("请填写订单号");
			return;
		}
		if($("#msg").text()=='错误'){
			alert("请填写正确的订单号");
			return;
		}
		if(tradeOrder.tradeStatus!=3){
			alert("订单必须打单后才可以发货");
			return;
		}
		$.ajax({
			url:'/trade/send?tradeId='+tradeIdValue+'&postFee='+postFeeValue,
			type:'get'
		}).done(result=>{
				if(result.code=='200'){
					mini.showTips({'content':'发货完成','X':'center','Y':'center','state':'success'});
				}
		}).fail(error=>{
			mini.alert(JSON.stringify(error));
		});
		
	});
	
})(window,mini,jkUtils)