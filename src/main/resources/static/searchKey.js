$(function() {
	$("#search_ajax").click(function() {
		var Key = $("input[name='Key']").val();
		$.ajax({
			type : "GET",
			url : "/search_ajax",

			success : function(data) {
				console.log(data);
				var jsonObj = JSON.parse(data);
				if (Key == "") {
					$("#search_result").text(data);
				} else {
					var sJsonObj = JSON.stringify(jsonObj[Key])
					$("#search_result").text(sJsonObj);
				}
				
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("error:" + XMLHttpRequest);
				alert("status:" + textStatus);
				alert("errorThrown:" + errorThrown);
			}
		});
	});
});