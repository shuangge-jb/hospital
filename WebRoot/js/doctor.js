/* 提交结果，执行ajax */

//给文本框绑定事件
$("#userName").blur(function() {
	var value=this.val();
	
	var result=$.ajax({
		type : "post",
		url : "ValidateAction",// 需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
		data : {// 设置数据源
			name : value
		},
		dataType : "json",// 设置需要返回的数据类型
		success : function(data) {
			var d = eval("(" + data + ")");// 将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
			// 得到的d是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来
			$("#userName").text("" + d.userName + "");
		},
		error : function() {
			alert("系统异常，请稍后重试！");
		}// 这里不要加","
	});
	if(result=="existed"){
		$("#userName").after("用户名已存在");
	}
});

$("#age").blur(function() {
	var age=$("#age").val();
	if((age<=0)||(age%1!==0)){
		
		this.attr(parseInt(age));
		var warning=document.createElement($("#age").attr()+"不正确");
	}
});
