(function(window,mini,jkUtils){
	mini.parse();
	var sendMsg=mini.get('sendMsg');
	var phone=mini.get('phone');
	var userInfo=new mini.Form('userInfo');
	var okBtn=mini.get('btn-save');
	sendMsg.on('click',function(e){
		var phoneText=phone.getValue();
		if(phoneText==null || phoneText==""){
			alert("手机号不为空");
			return;
		}
		$.ajax({
			url:'/user/sendValidate?phone='+phoneText,
			type:'get'
		}).done(result=>{
			if(result.code==200){
				mini.showTips({content:"发送成功",state:"success",x:"center",y:"center"});
			}else{
				mini.alert('发送失败，失败原因:'+result.msg);
			}
		}).fail(error=>{
			mini.alert('发送失败');
		});
	});

	okBtn.on('click',function(e){
		$.ajax({
			url:'/user/register',
			type:'POST',
			data:userInfo.getData()
		}).done(result=>{
			mini.showTips({content:"注册成功",state:"success",x:"center",y:"center"});
		}).fail(error=>{
			alert(JSON.stringify(error));
		})

	})
})(window,mini,jkUtils)
