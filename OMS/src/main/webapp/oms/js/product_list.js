(function(window,mini,jkUtils){
  mini.parse();
  var addProdBtn=mini.get('add_product_btn');
  var delProdBtn=mini.get('del_product_btn');
  var goodsGrid=mini.get('goodsGrid');
  delProdBtn.on('click',function(e){
    var btnEdit=e.sender;
    var rows=goodsGrid.getSelecteds();
    var id=[];
    for(var i=0;i<rows.length;i++){
      id[i]=rows[i].id;
    }
    $.ajax({
      url:'/product/delete?id='+id,
      type:'get',
    }).done(result=>{
      if(result.code=='200'){
          mini.showTips({content:"删除成功",state:"success",x:"center",y:"center"});
          goodsGrid.load();
      }
    }).fail(error=>{
      mini.alert(JSON.stringify(error));
    })
  });
  addProdBtn.on('click',function(e){
    var btnEdit = e.sender;
    mini.open({
      targetWindow: window,
      url: "/oms/add_product.html",
      title: "请添加货品",
      width: "666",
      height: "400",
      showModal: true,
      allowResize: false,
      onload: function () {
                  var iframe = this.getIFrameEl();
                  var data = {
                      action: "new"
                };
          },
        ondestroy: function (action) {
          if(action=='ok'){
              goodsGrid.load();
          }
        }
    });
  });
  goodsGrid.setAjaxOptions({
       dataFilter: function (jsonStr) {
           var json1 = mini.clone(jsonStr);
           var json = JSON.parse(json1);
           var result = {
               total: 500,
               data: json.result.data
           }
           return JSON.stringify(result)
       }
   });
  goodsGrid.set({
    url:"/product/findAll",
    ajaxType:'get',
  });

  goodsGrid.load();
})(window,mini,jkUtils)
