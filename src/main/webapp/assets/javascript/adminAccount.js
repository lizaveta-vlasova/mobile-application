function clientList(){
    $.ajax({
        url:'/adminAccount/clientList',
        dataType : "html",
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
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
            $("#adminContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("#liAddTariff").attr('class', 'active');
        }
    })
}


function addOptionForTariff(optionId, tariffId){
    $.ajax({
        type: 'POST',
        url:'/adminAccount/addOptionsForTariff/' +tariffId+ '/add/'+optionId,
        data: $("addOptionsForTariffForm").serialize(),
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;

        }
    })
}
function removeOptionForTariff(optionId, tariffId){
    $.ajax({
        type: 'POST',
        url:'/adminAccount/addOptionsForTariff/' +tariffId+ '/remove/'+optionId,
        dataType : $("addOptionsForTariffForm").serialize(),
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
        }
    })
}


function addNewTariff(){
    var msg = $('#addTariffForm').serialize();
    $.ajax({
        type: 'POST',
        url: "/adminAccount/addTariff/add",
        data: msg,
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
        }
    });

}
function removeTariff(tariffId){
    $.ajax({
        url:'/adminAccount/addTariff/'+tariffId+'/remove',
        dataType : "html",
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("liEditOptios").attr('class', 'active');
        }
    })
}

function addNewOption(){
    var msg = $('#addOptionForm').serialize();
    $.ajax({
        type: 'POST',
        url: "/adminAccount/optionList/add",
        data: msg,
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
        }
    });

}

function saveNewClient(){
    var msg = $('#saveNewClientForm').serialize();
    $.ajax({
        type: 'POST',
        url:'/adminAccount/addNewClient/save',
        data : msg,
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
        }
    })
}

function saveNewContract(){
    var msg ={
       tariffId: $('#tariffDropDow').val(),
       clientId:$('#clientDropDown').val(),
        number: $('#number').val()
    }
    $.ajax({
        type: 'POST',
        url:'adminAccount/addNewContract/add',
        data : msg,
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
        }
    })
}



function findContractPage(){
    $.ajax({
        url:'/adminAccount/findContractPage',
        dataType : "html",
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("#liFindContractPage").attr('class', 'active');
        }
    })
}
function contractPage(){
    var msg = $('#getFoundContractForm').serialize();
    $.ajax({
        type: 'GET',
        url:'/adminAccount/getFoundContract/' + msg,
        data : msg,
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
        }
    })
}

function editOptions(){
    $.ajax({
        url:'/adminAccount/optionList',
        dataType : "html",
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("#liEditOptions").attr('class', 'active');
        }
    })
}

function removeOption(optionId){
    $.ajax({
        url:'/adminAccount/optionList/'+ optionId + '/remove' ,
        dataType : "html",
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;

        }
    })
}

function addNewClient(){
    $.ajax({
        url:'/adminAccount/addNewClient',
        dataType : "html",
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("#liAddNewClient").attr('class', 'active');
        }
    })
}

function addNewContract(){
    $.ajax({
        url:'/adminAccount/addNewContract',
        dataType : "html",
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("#liAddNewContract").attr('class', 'active');
        }
    })
}


function blockByAdmin(contractId) {
    $.ajax({
        url:'/adminAccount/getFoundContract/' + contractId + '/block',
        dataType : "html",
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("liAddNewContract").attr('class', 'active');
        }
    })

}
function unblockByAdmin(contractId) {
    $.ajax({
        url:'/adminAccount/getFoundContract/' + contractId + '/unblock',
        dataType : "html",
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("liAddNewContract").attr('class', 'active');
        }
    })


}
function changeTariffForClientContract(contractId, tariffId) {
    $.ajax({
        url:'/adminAccount/getFoundContract/' + contractId + '/change/'+tariffId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("liAddNewContract").attr('class', 'active');
        }
    })

    // window.location.replace('/adminAccount/getFoundContract/' + contractId + '/change/'+tariffId);

}
function addOptionForClientContract(contractId, optionId){
    $.ajax({
        url:'/adminAccount/getFoundContract/'+ contractId + '/add/' + optionId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("liAddNewContract").attr('class', 'active');
        }
    })

}


function deleteOptionForClientContract(contractId, optionId){
    $.ajax({
        url:'/adminAccount/getFoundContract/'+ contractId + '/remove/' + optionId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#adminContent")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("liAddNewContract").attr('class', 'active');
        }
    })

}



function cleanActiveLiSelection() {
    // $("#clientNavUl")[0].childNodes
    $('#clientNavUl').find('li').removeClass();
}