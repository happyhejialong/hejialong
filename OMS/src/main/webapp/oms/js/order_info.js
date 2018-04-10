(function(window,mini,jkUtils){
  mini.parse();
  var orderInfo=new mini.Form('orderInfo');
  var goodsGrid=mini.get('goodsGrid');
  window.editPage={
        setData:function(data){
            $.ajax({
              url:'/trade/detail?id='+data,
              type:'get'
            }).done(result=>{
              if(result.code==200){
                  result=result.result.data;
                  orderInfo.setData(result);
                  goodsGrid.setData(result.tradeGoodsArr);
              }
            }).fail(error=>{
                mini.alert(JSON.stringify(error));
            })
        }
      };
})(window,mini,jkUtils)
