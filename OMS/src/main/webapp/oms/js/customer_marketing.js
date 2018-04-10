(function(window,mini,jkUtils){
  mini.parse();
  var addBtn=mini.get('addBtn');
  var delBtn=mini.get('delBtn');
  var customersGrid=mini.get('customersGrid');
  var customersGrid1=mini.get('customersGrid1');
  var sendBtn=mini.get('sendBtn');
  var subject=mini.get('subject');
  var message=mini.get('message');
  customersGrid.setAjaxOptions({
    dataFilter:function(jsonStr){
      var json1=mini.clone(jsonStr);
      var json=JSON.parse(json1);
      var result={
        'total':500,
        'data':json.result.data
      }
      return JSON.stringify(result);
    }
  });
  customersGrid.set({
    url:'/customer/list',
    type:'post'
  });
  customersGrid.load();
  addBtn.on('click',function(){
    var rows=customersGrid.getSelecteds();
    if(rows==null || rows.length==0){
      return;
    }
    var data=customersGrid1.getData();
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
    data.push.apply(data,data1);
    customersGrid1.setData(data);
  });

  delBtn.on('click',function(){
    var rows=customersGrid1.getSelecteds();
    if(rows!=null && rows.length>0){
      customersGrid1.removeRows(rows);
    }
  });
  sendBtn.on('click',function(){
    var rows=customersGrid1.getData();
    if(rows==null || rows.length<=0){
      alert('请选择用户后再发送信息');
      return;
    }
    var temp={};
    var emails="";
    var j=0;
    for(var i=0;i<rows.length;i++){
      if(rows[i].email!=null && rows[i].email!=""){
        if(i==rows.length-1){
          emails+=rows[i].email;
          break;
        }
        emails+=rows[i].email+",";
      }
    }
    temp.emails=emails;
    temp.subject=subject.getValue();
    if(temp.subject==null || temp.subject==""){
      alert("主题不能为空");
      return;
    }
    temp.message=message.getValue();
    $.ajax({
      url:'/common/sendEmail',
      type:'post',
      data:temp
    }).done(result=>{
      mini.showTips({content:"发送成功",state:"success",x:"center",y:"center"});
    }).fail(error=>{
      mini.alert(JSON.stringify(error));
    });
  });
})(window,mini,jkUtils)
