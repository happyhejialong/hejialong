(function(window,mini,jkUtils){
	mini.parse();
	var tradeId=mini.get('tradeId');
	var okBtn=mini.get('okBtn');
	okBtn.on('click',function(e){
		var id=tradeId.getValue();
		$.ajax({
			url:'/common/getExpRecommend?tradeId='+id,
			type:'get'
		}).done(result=>{
			if(result.code==200){
			var data=result.result.data;
			var expressInfo=$("#expressInfo");
			for(var i=0;i<data.length;i++){
        var isSupport=data[i].isSupport==1?'可用':'不可用';
				expressInfo.append("快递编号:"+data[i].expCode+" 快递名称:"+data[i].expName+" 费用:"+data[i].fee+"<br/>"+"预计到达需要时间:"+data[i].estimatedDeliveryTime+" 是否可用:"+isSupport+"<br/>");
			}
			}else{
				mini.alert(result.msg);
			}
		}).fail(error=>{
				mini.alert(JSON.stringify(error));
		})
	})
})(window,mini,jkUtils)
