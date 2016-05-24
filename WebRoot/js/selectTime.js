/**
 * 
 */
var doctorId = 1;
function submit() {
	$.ajax({
		type : "post",
		url : "insert.action",
		data : {
			doctorId : doctorId,
			periods : $("#periods").val()+$("#mornOrAfter").val()
		},
		dataType : "json",// 设置需要返回的数据类型
		success : function(data) {
			alert(data);
		},
		error : function(xhr) {
			alert("error:" + xhr.responseText);
		}
	});
}