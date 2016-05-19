/**
 * 
 */
$(document).ready(function() {
	$.ajax({
		type : "post",
		url : "registrationAction.action",
		data : {
			userName : value
		},
		dataType : "json",// 设置需要返回的数据类型
		success : function(data) {
			
			$("#title").after();
		},
		error:function(xhr){
			alert("error:"+xhr.responseText);
		}
	});

});