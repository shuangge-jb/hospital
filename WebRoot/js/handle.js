/**
 * 
 */
$(document).ready(
		function() {
			$.ajax({
				type : "post",
				url : "getPeriods.action",
				data : {
					doctorName : "爽哥"
				},
				dataType : "json",// 设置需要返回的数据类型
				success : function(data) {
					for ( var i in data) {
						var period = data[i];
						$("#period").append(
								"<option value=\"" + period + "\">" + period
										+ "</option>");
					}

				},
				error : function(xhr) {
					console.error("error:" + xhr.responseText);
				}
			});

		});

function loadInfo() {
	alert($("#period").val());
	$
			.ajax({
				type : "post",
				url : "getRegistrations.action",
				data : {
					doctorName : "爽哥",
					periods : $("#period").val()
				},
				dataType : "json",// 设置需要返回的数据类型
				success : function(data) {
					$(".registration").remove();
					for ( var i in data) {
						var registration = data[i];

						$("#handlePatient")
								.append(
										"<tr id=\"title\">"
												+ "<td class='onecenter registration'><font>"
												+ registration.id
												+ "</font></td>"
												+ "<td class='onecenter registration'><font>"
												+ registration.userName
												+ "</font></td>"
												+ "<td class='onecenter registration'><font>"
												+ registration.beginTime
												+ "</font></td>"
												+ "<td class='onecenter registration'>"
												+ "<input type=\"checkbox\" name=\"check\" class=\"handled\" " +
														"onclick=\"selectThis(this)\"></td>"
												+ "</tr>");
					}
				},
				error : function(xhr) {
					console.error("error:" + xhr.responseText);
				}
			});

}

function selectThis(checkbox){
	var userId=$(checkbox).parent().prev().prev().prev().children("font").text();
	var userName=$(checkbox).parent().prev().prev().children("font").text();
	var period=$(checkbox).parent().prev().children("font").text();
	alert(userId);
	$.ajax({
		type : "post",
		url : "mark.action",
		data : {
			userId : userId,
			userName:userName,
			period:period
			
		},
		dataType : "json",// 设置需要返回的数据类型
		success : function(data) {
			
		},
		error:function(xhr){
			console.error("error:" + xhr.responseText);
		}
	});
}