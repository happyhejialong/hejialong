(function(window,mini,jkUtils){
  mini.parse();
  var customerInfo=new mini.Form('customerInfo');
  var saveBtn=mini.get('btn-save');
  var state=mini.get('state');
  var city=mini.get('city');
  var district=mini.get('district');
  saveBtn.on('click',function(){
      alert(JSON.stringify(customerInfo.getData()));
      $.ajax({
        url:'/customer/add',
        type:'post',
        data:customerInfo.getData()
      }).done(result=>{
          if(result.code==200){
            mini.showTips({content:"发送成功",state:"success",x:"center",y:"center"});
          }
      }).fail(error=>{
        mini.alert(JSON.stringify(error));
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
})(window,mini,jkUtils)
