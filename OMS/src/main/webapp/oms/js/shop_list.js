(function(mini,window,jkUtils){
	mini.parse();
	var shopsGrid=mini.get('shopsGrid');
	shopsGrid.setAjaxOptions({
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
	shopsGrid.set({
		url:'/shop/list',
		ajaxType:'get'
	});
	shopsGrid.load();
	
	  var gridMenu=mini.get('gridMenu');
	  gridMenu.on('beforeopen',function(e){
	    var menu = e.sender;
	    var row = shopsGrid.getSelected();
	    var rowIndex = shopsGrid.indexOf(row);
	    if (!row) {
	        e.cancel = true;
	        //阻止浏览器默认右键菜单
	        e.htmlEvent.preventDefault();
	        return;
	    }
	    ////////////////////////////////
	    var editItem = mini.getbyName("edit", menu);
	    var removeItem = mini.getbyName("add", menu);
	    editItem.show();
	    removeItem.enable();

	    if (rowIndex == 1) {
	        editItem.hide();
	    }
	    if (rowIndex == 1) {
	        removeItem.disable();
	    }
	  });
})(mini,window,jkUtils)

    function install_order(e) {
            var shopGrid=mini.get('shopsGrid');
            var row=shopGrid.getSelected();
         //   if(row.access_token !=null && row.access_token!=""){ 
           //      var shopDto={};
           //      shopDto.shopInfo=row;
           //      shopDto.accessToken=row.access_token;
                 var data=JSON.stringify(row);
                 alert(data);
                 $.ajax({
                   url:"/trade/install",
                   type:'POST',
                   data:{jsonStr:row}
                 }).done(result=>{
                    if(result.code=='200'){
                      mini.showTips({content:"下载成功",state:"success",x:"center",y:"center"});
                    }else{
                      mini.alert("下载失败，失败原因:"+result.msg);
                    }
                 }).fail(error=>{
                   alert(JSON.stringify(error));
                 });
         //   }else{
         //     alert('该用户未授权!!');
         //   }
        }

function authorize(e) {
    var shopGrid=mini.get('shopsGrid');
    var row = shopGrid.getSelected();
    mini.open({
      targetWindow: window,
      url: '/oms/authorize.html',
      title: "请选择",
      width: "40%",
      height: "20%",
      showModal: true,
      allowResize: false,
      onload: function () {
          var iframe = this.getIFrameEl();
          var data = {
              action: "new"
          };
      },
      ondestroy: function (action) {
          if(action!=null && action!="" && action!="close"){
              row.access_token=action;
              shopGrid.updateRow(row,{
                sid : row.sid,
                shopName : row.shopName,
                category : row.category,
                authorize_state :row.authorize_state ,
                authorize_time : new Date(),
                auto_install : row.auto_install
              });
          }
      }
    });
  }