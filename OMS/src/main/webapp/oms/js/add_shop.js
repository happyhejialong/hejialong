(function(window,jkUtils,mini){
  mini.parse();
  var shopInfo=new mini.Form('shopInfo');
  var okBtn=mini.get('okBtn');
  okBtn.on('click',function(e){
    var shopData=shopInfo.getData();
    $.ajax({
      url:'/shop/add',
      type:'POST',
      data:shopData
    }).done(result=>{
    	if(result.code==200){
    		mini.showTips({content:"保存成功",state:"success",x:"center",y:"center"});
    	}else{
    		mini.alert('新增失败，失败原因:'+result.msg);
    	}
    }).fail(result=>{
      mini.alert('添加失败');
    });
  });
})(window,jkUtils,mini)
