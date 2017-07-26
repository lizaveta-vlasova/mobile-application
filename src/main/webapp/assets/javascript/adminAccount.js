function clientList(){
    $.ajax({
        url:'/adminAccount/clientList',
        dataType : "html",
        success: function (data, textStatus) {
            $("#clientContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("#liClientList").attr('class', 'active');
        }
    })
}

function addTariff(){
    $.ajax({
        url:'/adminAccount/addTariff',
        dataType : "html",
        success: function (data, textStatus) {
            $("#clientContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("#liAddTariff").attr('class', 'active');
        }
    })
}

function blockedContract(){
    $.ajax({
        url:'/adminAccount/blockedContract',
        dataType : "html",
        success: function (data, textStatus) {
            $("#clientContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("liContractBlock").attr('class', 'active');
        }
    })
}

function cleanActiveLiSelection() {
    // $("#clientNavUl")[0].childNodes
    $('#clientNavUl').find('li').removeClass();
}