$(document).ready(function(){
    if ($("#contractId")[0]) {
        tariffChange($("#contractId")[0].className);
    }
});


function tariffChange(contractId) {
    $.ajax({
        url: '/clientAccount/tariff/'+contractId,          // указываем URL и
        dataType : "html",                     // тип загружаемых данных
        success: function (data, textStatus) { // вешаем свой обработчик на функцию success
            $("#content")[0].innerHTML = data;
            $(".sidebar-wrapper ul li").removeClass('active');
            $("#liTariffChange").attr('class', 'active');

            $("#myDialog").dialog({
                autoOpen: false,
                modal: true,
                height: "auto",
                width: 400,
                modal: true,
                buttons: {
                    "Да": function () {
                        $(this).dialog("close");
                        var tariffId = $(this).data('tariffId');
                        window.location.replace('/clientAccount/tariff/' + contractId + '/newTariff/' + tariffId);
                    },
                    "Нет": function () {
                        $(this).dialog("close");
                    }
                }
            });
            $(".sidebar-wrapper ul li").removeClass('active');
            $("#liTariffChange").attr('class', 'active');
        }
    });
}
function userInformation(clientId) {
    $.ajax({
        url:'/clientAccount/userInfo/' + clientId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            $(".sidebar-wrapper ul li").removeClass('active');
            $("#liUserInformation").attr('class', 'active');
        }
    })
}


function showTariffChangeConfirmation(tariffId) {
    $("#myDialog")
        .data('tariffId', tariffId)
        .dialog("open");
}

function optionsChange(contractId){
    $.ajax({
        url:'/clientAccount/options/'+contractId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            $(".sidebar-wrapper ul li").removeClass('active');
            $("#liOptionsChange").attr('class', 'active');
        }
    })
}

function addOption(contractId, idOption){
    $.ajax({
        url:'/clientAccount/options/' + contractId + '/add/' + idOption,
        dataType : "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("#liOptionsChange").attr('class', 'active');
        }
    })
}

function deleteOption(contractId, idOption){
    $.ajax({
        url:'/clientAccount/options/' + contractId + '/remove/' + idOption,
        dataType : "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("#liOptionsChange").attr('class', 'active');
        }
    })
}

function numberBlock(contractId){
    $.ajax({
        url:'/clientAccount/block/'+contractId ,
        dataType : "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            $(".sidebar-wrapper ul li").removeClass('active');
            $("#liNumberBlock").attr('class', 'active');
        }
    })

}
function blockByUser(contractId){
    sweetAlert({
        title: "Выполнено",
        text: "Номер заблокирован!",
        type: "success"
    });
    window.location.replace('/clientAccount/block/'+contractId +'/blocked/');

}
function unblockByUser(contractId){
    sweetAlert({
        title: "Выполнено",
        text: "Номер разблокирован!",
        type: "success"
    });
    window.location.replace('/clientAccount/block/'+contractId +'/unblocked/');
}





function cleanActiveLiSelection() {
    $('#clientNavUl').find('li').removeClass();
}

function getContractNumer(tariffId) {
    $.ajax({
        url:'/clientAccount/loginTariff',
        dataType : "html",
        success: function (data, textStatus) {
            $("#clientContent")[0].innerHTML = data;

        }
    })
}


function getChangeTariff() {
    $.ajax({
        url:'/clientAccount/chooseTheTariff',
        dataType : "html",
        success: function (data, textStatus) {
            $("#clientContent")[0].innerHTML = data;
            alert("Изменения успешно сохранены!");

        }
    })

}

function updateTariff(){
    $.ajax({
        url:'/clientAccount/chooseTheContract',
        dataType : "html",
        success: function (data, textStatus) {
            $("#clientContent")[0].innerHTML = data;

        }
    })

}








