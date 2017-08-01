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

function findContractPage(){
    $.ajax({
        url:'/adminAccount/findContractPage',
        dataType : "html",
        success: function (data, textStatus) {
            $("#clientContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("#liAddTariff").attr('class', 'active');
        }
    })
}

function editOptions(){
    $.ajax({
        url:'/adminAccount/optionList',
        dataType : "html",
        success: function (data, textStatus) {
            $("#clientContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("liEditOptios").attr('class', 'active');
        }
    })
}

function removeOption(optionId){
    $.ajax({
        url:'/adminAccount/optionList/'+ optionId + '/remove' ,
        dataType : "html",
        success: function (data, textStatus) {
            $("#clientContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("liEditOptios").attr('class', 'active');
        }
    })
}

function addNewClient(){
    $.ajax({
        url:'/adminAccount/addNewClient',
        dataType : "html",
        success: function (data, textStatus) {
            $("#clientContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("liAddNewClient").attr('class', 'active');
        }
    })
}


function blockByAdmin(contractId) {
    window.location.replace('/adminAccount/findContractPage' + contractId + '/block');

}
/*
function blockByAdmin(contractId){
    $.ajax({
        url:'/adminAccount/findContractPage/' + contractId+ '/block/',
        dataType : "html",
        success: function (data, textStatus) {
            $("#clientContent")[0].innerHTML = data;

        }
    })
*/


   // window.location.replace('/adminAccount/blockContract/'+contractId + '/block/');



function cleanActiveLiSelection() {
    // $("#clientNavUl")[0].childNodes
    $('#clientNavUl').find('li').removeClass();
}