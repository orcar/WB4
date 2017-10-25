$(function() {
	$("#search_ajax").click(function() {
		var Key = $("input[name='Key']").val();
		$.ajax({
			type : "GET",
			url : "/search_ajax",
			data : {
				Key : Key
			},
			success : function(data) {
				console.log(data);
				$("#search_result").text(data);

			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("error:" + XMLHttpRequest);
				alert("status:" + textStatus);
				alert("errorThrown:" + errorThrown);
			}
		});
	});
});