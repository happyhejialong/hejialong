(function(window,mini,jkUtils){
   mini.parse();
   var goodsGrid=mini.get('goodsGrid');
   var addBtn=mini.get('addBtn');
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

   addBtn.on('click',function(){
     var rows=goodsGrid.getSelecteds();
     if(rows==null || rows.length==0){
       alert('请勾选货品再点添加!!');
       return;
     }
     jkUtils.closeWindow(rows);
   })
})(window,mini,jkUtils)
