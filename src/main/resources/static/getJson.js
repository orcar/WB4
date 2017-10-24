$(function() {
	// Ajax通信テスト ボタンクリック
	$("#ajax_btn").click(function() {
		// outputDataを空に初期化
		$("#output_data").text("");
		$.ajax({
			type : "GET",
			url : "Hoge",
			dataType : "json",
			success : function(jsonOb) {
				string = JSON.stringify(jsonOb);
				$("#output_data").text(string);
			},
			error : function error(XMLHttpRequest, textStatus, errorThrown) {
				alert("error:" + XMLHttpRequest);
				alert("status:" + textStatus);
				alert("errorThrown:" + errorThrown);
			}
		});
	});
});