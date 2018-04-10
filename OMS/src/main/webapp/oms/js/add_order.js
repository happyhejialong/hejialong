(function(mini,window,jkUtils){
  mini.parse();
  var btnSave=mini.get('btn-save');
  var goodsGrid=mini.get('goodsGrid');
  var orderInfo=new mini.Form('orderInfo');
  var tradeType=mini.get('tradeType');
  var customerType=mini.get('customerType');
  var identityCardType=mini.get('identityCardType');
  var logisticsInfo=mini.get('logisticsInfo');
  var shopInfo=mini.get('shopInfo');
  var state=mini.get('state');
  var city=mini.get('city');
  var district=mini.get('district');
  var customerInfo=mini.get('customerInfo');
  var customerNick=mini.get('customerNick');
  var addProdBtn=mini.get('addProdBtn');
  	
  $.getJSON('/oms/json/baseEnum.json',function(e){
	  tradeType.setData(e.tradeType.values);
	  customerType.setData(e.customerType.values);
	  identityCardType.setData(e.identityCardType.values);
	  logisticsInfo.setData(e.logisticsInfo.values);
});
  
  customerNick.on('buttonclick',function(e){
	  	mini.open({
	  	  targetWindow: window,
	      url: "/oms/customer_list.html",
	      title: "请添加客户",
	      width: "80%",
	      height: "60%",
	      showModal: true,
	      allowResize: false,
	      onload: function () {
	                  var iframe = this.getIFrameEl();
	                  var data = {
	                      action: "new"
	                };
	          },
	        ondestroy: function (action) {
	        	customerNick.setText(action.customerNick);
	        	mini.get('email').setValue(action.email);
	        	mini.get('customerType').setValue(action.customerType);
	        	mini.get('phone').setValue(action.phone);
	        	mini.get('customerId').setValue(action.customerId);
	        }
	  	});
  });

  $.ajax({
	  url:'/shop/list',
	  type:'get',
  }).done(result=>{
	  shopInfo.setData(result.result.data);
  });

  btnSave.on('click',function(e){
    var orderInfoData=orderInfo.getData();
    //给tradeOrder店铺信息赋值
    orderInfoData.tradeOrder.shopId=shopInfo.getValue();
    orderInfoData.tradeOrder.shopName=shopInfo.getText();
    //给tradeGoodsArr赋值
    orderInfoData.tradeGoodsArr=goodsGrid.getData();
    for(var i=0;i<orderInfoData.tradeGoodsArr.length;i++){
      delete orderInfoData.tradeGoodsArr[i]._id;
      delete orderInfoData.tradeGoodsArr[i].id;
    }
    console.log(orderInfoData);
    $.ajax({
      url:'/trade/add',
      type:'POST',
      data:{jsonStr:JSON.stringify(orderInfoData)}
    }).done(result=>{
      if(result.code=='200'){
         mini.showTips({content:"保存成功",state:"success",x:"center",y:"center"});
      }
    }).fail(error=>{
        mini.alert(JSON.stringify(result));
    });
  });
  function findDistricts(e,keyword){
    $.ajax({
        url:"/districts/findDistricts/"+keyword,
        type:"get"
    }).done(result=>{
        e.setData(result.result.data);
    })
  };
  state.on('click',function(e){
    if(state.getData()==null || JSON.stringify(state.getData())=="[]"){
      findDistricts(state,'中华');
    }
  });
  state.on('valuechanged',function(e){
    var stateText=state.getValue();
    findDistricts(city,stateText);
    district.setData(null);
  });
  city.on('valuechanged',function(e){
    var cityText=city.getValue();
    findDistricts(district,cityText);
  });

  addProdBtn.on('click',function(e){
    var btnEdit = e.sender;
    mini.open({
      targetWindow: window,
      url: "/oms/goods_selector.html",
      title: "请添加货品",
      width: "80%",
      height: "80%",
      showModal: true,
      allowResize: false,
      onload: function () {
                  var iframe = this.getIFrameEl();
                  var data = {
                      action: "new"
                };
          },
        ondestroy: function (action) {
            if(action.length>0){
             for(var i=0;i<action.length;i++){
            	 action[i].discount=1;
            	 action[i].sellCount=1;
            	 action[i].sellPrice= action[i].price*1;
             }
              var data=goodsGrid.getData();
              action.push.apply(action,data);
              goodsGrid.setData(action);
            }
        }
    });
  });
})(mini,window,jkUtils)
