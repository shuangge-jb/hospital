/* 提交结果，执行ajax */
$(document)
		.ready(
				function() {
					// 给文本框绑定事件
					var doctorNameCounter=0;
					$("#doctorName").blur(function() {
						var value = $("#doctorName").val();

						$.ajax({
							type : "post",
							url : "doctorAction.action",
							data : {
								doctorName : value
							},
							dataType : "json",// 设置需要返回的数据类型
							success : function(data) {
								
								//alert("success:"+data);
								if (data == "existed"&&doctorNameCounter==0) {
									$("#doctorName").after("<font id=\"doctorNameWarning\" color=\"red\">用户名已存在</font>");
									doctorNameCounter++;
								}else if(data != "existed"){
									$("#doctorNameWarning").remove();
								}
							},
							error:function(xhr){
								alert("error: "+xhr.responseText);
							}
								

						});
						
					});

					$("#age").blur(
							function() {
								var age = $("#age").val();
								if ((age <= 0) || (age % 1 !== 0)) {

									$("#age").val(parseInt(age));
									var warning = document.createElement($(
											"#age").val()
											+ "<font id=\"telWarning\" color=\"red\">不正确</font>");
								}
							});
					$("#department").focus(
							function() {
								var departments = eval($.ajax({
									type : "post",
									url : "DepartmentAction",// 需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
									dataType : "json",// 设置需要返回的数据类型
									success : function(data) {
										var result = eval("(" + data + ")");// 将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
										// 得到的d是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来
										for ( var item in result) {
											$("#department").append(
													"<option value='"
															+ result[item] + "'>"
															+ result[item]
															+ "</option>");
										}
									}
								}));
								
							});
					var counter = 0;
					$("#tel")
							.blur(
									function() {
										var tel = $("#tel").val();
										if (tel.length != 11 && counter == 0) {
											$("#tel")
													.after(
															"<font id=\"telWarning\" color=\"red\">手机号码为11位!</font>");
											counter++;
										} else if (tel.length == 11) {
											$("#telWarning").remove();
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
										$("#hospital").val(
												"" + result.hospital + "");
									}
								}));
								for ( var item in hospitals) {
									$("#hospital").append(
											"<option value='" + hospitals[item]
													+ "'>" + hospitals[item]
													+ "</option>");
								}
							});
				});