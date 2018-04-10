(function(window,mini,jkUtils){
  mini.parse();
  var productInfo=new mini.Form('productInfo');
  var okBtn=mini.get('okBtn');
  var cancelBtn=mini.get('cancelBtn');
  okBtn.on('click',function(e){
      $.ajax({
        url:'/product/add',
        type:'POST',
        data:productInfo.getData()
      }).done(result=>{
          if(result.code=='200'){
             mini.showTips({content:"保存成功",state:"success",x:"center",y:"center"});
             jkUtils.closeWindow('ok');
          }
      }).fail(error=>{
          mini.alert(JSON.stringify(error));
      });
  });
  cancelBtn.on('click',function(e){
    jkUtils.closeWindow('close');
  });
})(window,mini,jkUtils)
