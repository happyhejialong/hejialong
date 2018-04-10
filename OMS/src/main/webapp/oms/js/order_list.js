(function(window,mini,jkUtils){
  mini.parse();
  var ordersGrid=mini.get('ordersGrid');
  var searchByConditionBtn=mini.get('searchByConditionBtn');
  ordersGrid.setAjaxOptions({
      dataFilter:function(jsonStr){
        var json1 = mini.clone(jsonStr);
        var json = JSON.parse(json1);
        var result = {
            total: 500,
            data: json.result.data
        };
        for(var i=0;i<result.data.length;i++){
        	result.data[i].gmtCreate= mini.formatDate(new Date(result.data[i].gmtCreate),'yyyy-MM-dd HH:mm:ss');
        }
        return JSON.stringify(result)
      }
  });
  ordersGrid.set({
    url:'/trade/list',
    type:'POST'
  });
  ordersGrid.load();

    //双击可以查看订单详情
    ordersGrid.on('rowdblclick', function (sender) {
        var info = sender.record;
        orderInfoLocation(info.id);
    });
    function orderInfoLocation(data) {
  		inputFrame = mini.open({
  			targetWindow: window,
  			url: '/oms/order_info.html',
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
            mini.showTips({content:"保存成功",state:"success",x:"center",y:"center"})
  					ordersGrid.load();
          }
  			}
  		});
	}
    var selectTable=new mini.Form('selectTable');

    searchByConditionBtn.on('click',function(){
    	var condition=selectTable.getData();
    	ordersGrid.load({'jsonStr':JSON.stringify(condition)});
    });
})(window,mini,jkUtils)

//列的渲染,处理时间的计算
function onGridOneRowRender(e) {
    var result = '';
    switch (e.column.field) {
        case 'tradeStatus':
        	  result=e.record['tradeStatus'];
        	  if(result==1){
        		  result='待审核'
        	  }else if(result==2){
        		  result='待打印';
        	  }else if(result==3){
        		  result='代发货';
        	  }else if(result==4){
        		  result='完成';
        	  }
          break;
     }
    return result;
}
