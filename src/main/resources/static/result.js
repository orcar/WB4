$(function() {
//	   @input ,when ajax submit click
	$("#submit_ajax").click(function() {
		var number = parseInt($("input[name='aNumber']").val(), 10);
		var animal = $("input[name='aAnimal']").val();
		var nation = $("input[name='aNation']").val();
		var myValue = {
			"number" : number,
			"animal" : animal,
			"nation" : nation
		};
//		alert(myValue);

		$.ajax({
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			type : "POST",
			url : "submit_ajax",
			data : JSON.stringify(myValue),
			dataType : "json",
			success : function(data) {
				console.log(data);
				$("#result_ajax").text(JSON.stringify(data));
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("error:" + XMLHttpRequest);
				alert("status:" + textStatus);
				alert("errorThrown:" + errorThrown);
			}
		});
	});
	
});