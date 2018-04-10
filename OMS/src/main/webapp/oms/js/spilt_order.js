(function(window,mini,jkUtils){
  mini.parse();
  var addBtn=mini.get('addBtn');
  var delBtn=mini.get('delBtn');
  var ordersGrid=mini.get('ordersGrid');
  var ordersGrid1=mini.get('ordersGrid1');
  var saveBtn=mini.get('btn-save');
  var delBtn=mini.get('btn-close');
  window.editPage={
		  setData:function(data){
            $.ajax({
              url:'/trade/getTradeGoods?tradeId='+data,
              type:'get'
            }).done(result=>{
              if(result.code==200){
                  result=result.result.data;
                  ordersGrid.setData(result);
              }
            }).fail(error=>{
                mini.alert(JSON.stringify(error));
            })
        }
      };

  addBtn.on('click',function(){
    var rows=ordersGrid.getSelecteds();
    if(rows==null || rows.length==0){
      return;
    }
    var data=ordersGrid1.getData();
    var data1=[];
    if(rows!=null && rows.length>0){
      var index=0;
      for(var i=0;i<rows.length;i++){
          var flag=0;
        for(var j=0;j<data.length;j++){
            if(rows[i].id==data[j].id){
                flag=1;
                break;
            }
        }
        if(flag==0){
          data1[index++]=rows[i];
        }
      }
    }
    ordersGrid.removeRows(rows,true);
    //var data3=ordersGrid.getData();
    //var data2=mini.clone(data3);
    data.push.apply(data,data1);

  //ordersGrid.setData(data2);
    ordersGrid1.setData(data);
  });

  delBtn.on('click',function(){
    jkUtils.closeWindow('close');
  });

  delBtn.on('click',function(){
    var rows=ordersGrid1.getSelecteds();
    if(rows!=null && rows.length>0){
      ordersGrid1.removeRows(rows);
    }
  });

  saveBtn.on('click',function(){
      var rows1=ordersGrid.getData();
      var rows2=ordersGrid1.getData();
      for(var i=0;i<rows1.length;i++){
        delete rows1[i]._id;
        delete rows1[i]._uid;
      }
      for(var i=0;i<rows2.length;i++){
        delete rows2[i]._id;
        delete rows2[i]._state;
        delete rows2[i]._uid;
      }
      var temp={};
      temp.srcTradeGoodsArr=rows1;
      temp.destTradeGoodsArr=rows2;
      $.ajax({
        url:'/trade/split',
        type:'post',
        data:{jsonStr:JSON.stringify(temp)}
      }).done(result=>{
        if(result.code=='200'){
            mini.showTips({content:"拆分成功",x:"center",y:"center",state:"success"});
            jkUtils.closeWindow('ok');
        }
      }).fail(error=>{
        mini.alert(JSON.stringify(error));
      })

  });

})(window,mini,jkUtils)
