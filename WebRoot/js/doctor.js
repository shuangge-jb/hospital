/* 提交结果，执行ajax */

//给文本框绑定事件
$("#userName").blur(function() {
	var value = this.val();

	var result = $.ajax({
		type : "post",
		url : "UserValidateAction",// 需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
		data : {// 设置数据源
			name : value
		},
		dataType : "json",// 设置需要返回的数据类型
		success : function(data) {
			var result = eval("(" + data + ")");// 将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
			// 得到的d是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来
			$("#userName").text("" + result.userName + "");
		},
		error : function() {
			alert("系统异常，请稍后重试！");
		}// 这里不要加","
	});
	if (result == "existed") {
		$("#userName").after("用户名已存在");
	}
});

$("#age").blur(function() {
	var age = $("#age").val();
	if ((age <= 0) || (age % 1 !== 0)) {

		this.attr(parseInt(age));
		var warning = document.createElement($("#age").attr() + "不正确");
	}
});
$("#department").focus(
		function() {
			var departments = eval($.ajax({
				type : "post",
				url : "FindDepartmentsAction",// 需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
				dataType : "json",// 设置需要返回的数据类型
				success : function(data) {
					var result = eval("(" + data + ")");// 将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
					// 得到的d是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来
					$("#department").text("" + result.department + "");
				}
			}));
			for ( var item in departments) {
				this.append("<option value='" + departments[item] + "'>"
						+ departments[item] + "</option>");
			}
		});
$("#tel").flur(function() {
	var tel = this.val();
	if (tel.length != 11) {
		this.after("<font color=\"red\">手机号码为11位!</font>");
	}
});

$("#hospital").focus(
		function() {
			var hospitals = eval($.ajax({
				type : "post",
				url : "FindHospitalsAction",// 需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
				dataType : "json",// 设置需要返回的数据类型
				success : function(data) {
					var result = eval("(" + data + ")");// 将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
					// 得到的d是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来
					$("#hospital").text("" + result.hospital + "");
				}
			}));
			for ( var item in hospitals) {
				this.append("<option value='" + hospitals[item] + "'>"
						+ hospitals[item] + "</option>");
			}
		});
