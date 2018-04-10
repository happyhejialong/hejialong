(function(window,jkUtils,mini){
  mini.parse();
  var customersGrid=mini.get('customersGrid');
  customersGrid.setAjaxOptions({
    dataFilter:function(jsonStr){
        var json1=mini.clone(jsonStr);
        var json=JSON.parse(json1);
        var result={
          'total':500,
          'data':json.result.data
        };
        return JSON.stringify(result)
    }
  });

  customersGrid.set({
    url:'/customer/list',
    type:'POST'
  });
  customersGrid.load();
  
  //双击可以编辑波次策略
  customersGrid.on('rowdblclick', function (sender) {
        var info = sender.record;
        jkUtils.closeWindow(info);
  });
})(window,jkUtils,mini)

function onGridOneRowRender(e) {
    var result = '';
    switch (e.column.field) {
        case 'gender':		
        	  result=e.record['gender']; 
        	  if(result==1){
        		  result='男'
        	  }else if(result==2){
        		  result='女';
        	  }
          break;
     }
    return result;
}