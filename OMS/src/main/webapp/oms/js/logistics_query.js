(function(window,mini,jkUtils){
	mini.parse();
	var logisticsId=mini.get('logisticsId');
	var expCode=mini.get('expCode');
	var okBtn=mini.get('okBtn');
	okBtn.on('click',function(e){
		var expNo=logisticsId.getValue();
		var code=expCode.getValue();
		$.ajax({
			url:'/common/findLogisticsInfo?logisticsId='+expNo+'&expCode='+code,
			type:'get'
		}).done(result=>{
			console.log(result);
			if(result.code==200){
				var data=result.result.data;
				var traces=data.Traces;
				var logisticsInfo=$("#logisticsInfo");
				for(var i=0;i<traces.length;i++){
					logisticsInfo.append(traces[i].AcceptStation+" "+traces[i].AcceptTime+"<br/>");
				}
			}
			
		}).fail(error=>{
				mini.alert(JSON.stringify(error));
		})
	})
})(window,mini,jkUtils)