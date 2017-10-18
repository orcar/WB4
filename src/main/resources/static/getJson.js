$(function() {
    // Ajax通信テスト ボタンクリック
    $("#ajax_btn").click(function() {
        // outputDataを空に初期化
        $("#output_data").text("");
        $.ajax({
            type        : "GET",
            url         : "Hoge",
            dataType    : "json",
            success     : function(data) {
            				success(data);
                        },
            error       : function(XMLHttpRequest, textStatus, errorThrown) {
                            error(XMLHttpRequest, textStatus, errorThrown);
                        }
        });
    });
});
 
// Ajax通信成功時処理
function success(data) {
	data1 = JSON.stringify(data);
    $("#output_data").text(data1);
}
 
// Ajax通信失敗時処理
function error(XMLHttpRequest, textStatus, errorThrown) {
    alert("error:" + XMLHttpRequest);
    alert("status:" + textStatus);
    alert("errorThrown:" + errorThrown);
}