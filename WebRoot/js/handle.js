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
					alert("error:" + xhr.responseText);
				}
			});
			$.ajax({
				type : "post",
				url : "getRegistrations.action",
				data : {
					doctorName : "爽哥"
				},
				dataType : "json",// 设置需要返回的数据类型
				success : function(data) {
					for ( var i in data) {
						var registration = data[i];
						alert("success:" + registration);
						$("#handlePatient").append(
								"<tr id=\"title\">"
			+"<td class='onecenter'><font>"+registration.doctorId +"</font></td>"
			+"<td class='onecenter'><font>"+registration.userName+"</font></td>"
			+"<td class='onecenter'><font>"+registration.period+"</font></td>"
			+"<td class='onecenter'><font>操作</font></td>"
		+"</tr>");
					}
				},
				error : function(xhr) {
					alert("error:" + xhr.responseText);
				}
			});
		});