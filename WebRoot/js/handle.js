/**
 * 
 */
$(document).ready(function() {
	$.ajax({
		type : "post",
		url : "getPeriods.action",
		contentType: 'application/json; charset=utf-8', 
		data : {
			doctorName : "爽哥",
		},
		dataType : "json",// 设置需要返回的数据类型
		success : function(data) {
			for(var i in data){
				var period=data[i];
				alert("success:"+period);
				$("#period").append("<option value=\""+period+"\">"+period+"</option>");
			}
			
		},
		error:function(xhr){
			alert("error:"+xhr.responseText);
		}
	});

});