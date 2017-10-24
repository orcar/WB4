$(function() {
	// @/input ,when ajax submit click
	$("#submit_ajax").click(function() {
		// outputDataを空に初期化
		$.ajax({
			type : "POST",
			url : "submit_ajax",
			data : params,
			success : function(data) {
				console.log(data);
				$("#result_ajax").text(data);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("error:" + XMLHttpRequest);
				alert("status:" + textStatus);
				alert("errorThrown:" + errorThrown);
			}
		});
	});
});