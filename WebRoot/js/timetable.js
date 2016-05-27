/**
 * 
 */

$(document).ready(function(){
	$("#table").hide();
	$.ajax({
		type : "post",
		url : "worktime.action",
		data : {
			doctorName : "柯晓燕"
		},
		dataType : "json",// 设置需要返回的数据类型
		success : function(data) {
			var currentDate=new Date();
			var week=new Array("one","two","three","four","five","six","seven");
			//alert(currentDate.toLocaleString());
			$(data).each(function(i) {
				var period = data[i];
				var dateArray=period.substring(0,10).split("-");
				var mornOrAfter=period.substring(10,12);
				var isFilled=period.substring(13);
				var date=new Date(dateArray[0],dateArray[1]-1,dateArray[2]);
				var dayNum=daysBetween(currentDate,date);
				if(dayNum>=0){
					var mornOrAfterStr=mornOrAfter=="上午"?"Morn":"After";
					var id=week[dayNum]+mornOrAfterStr;
					if(isFilled=="unfilled"){
					$("#"+id).append("<button  class='unfilled handled btn btn-primary' value=\""+id+"\">预约</button>");
					}else{
						$("#"+id).append("<button  disabled=\"disabled\" class='filled handled btn  btn-warning' value=\""+id+"\">已满</button>");
					}
				}
			});
		},
		error : function(xhr) {
			console.error("error:" + xhr.responseText);
		}
	});
	
})

function showTable(){
	$("#table").show();
}

function daysBetween(date1, date2) {
    // The number of milliseconds in one day
    var ONE_DAY = 1000 * 60 * 60 * 24
    // Convert both dates to milliseconds
    var date1_ms = date1.getTime()
    var date2_ms = date2.getTime()
    // Calculate the difference in milliseconds
    var difference_ms =  date2_ms-date1_ms;
    // Convert back to days and return
    return Math.round(difference_ms/ONE_DAY)
}

