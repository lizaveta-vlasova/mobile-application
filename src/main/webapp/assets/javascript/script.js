/*
 function client_entry() {
 location.replace("http://www.google.com");
 }*/
/*
document.getElementById("logButtom").onclick = function () {
    location.href = "www.youtube.com";
};*/
function redirect() {
    window.location.replace("/clientAccount");
    return false;
}
$(function () {
    $('#int_page').click(function () {
        $.ajax({
            type: get(),
            url: '../jsp/Internet.jsp',
            success: function(data) {

            }
        })
    })
})