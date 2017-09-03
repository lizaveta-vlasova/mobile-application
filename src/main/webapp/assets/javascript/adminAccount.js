/*$(document).ready(function() {
    $(".js-example-basic-single").select2({
        placeholder: "Select",
        allowClear: true
    });}
    )*/

$(document).ready(function() {
    $( "#number" ).select2({
        minimumResultsForSearch: -1
        /*placeholder: "Select a State",
        allowClear: true*/
    });
});



function clientList(){
    $.ajax({
        url:'/adminAccount/clientList',
        dataType : "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            $(".sidebar-wrapper ul li").removeClass('active');
            $("#liClientList").attr('class', 'active');

        }
    })
}

function createNewTariff(){
    $.ajax({
        url:'/adminAccount/createNewTariff',
        dataType : "html",
        success: function (data, textStatus) {
            $("#flex-container")[0].innerHTML = data;
            $(".flex-box-buttom div button").removeClass('active');
            $("#addTariffRightButton").attr('class','btn btn-info active');

        }
    })
}
function addTariff(){
    $.ajax({
        url:'/adminAccount/addTariff',
        dataType : "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            $(".sidebar-wrapper ul li").removeClass('active');
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
            $("#content")[0].innerHTML = data;

        }
    })
}
function removeOptionForTariff(optionId, tariffId){
    $.ajax({
        type: 'POST',
        url:'/adminAccount/addOptionsForTariff/' +tariffId+ '/remove/'+optionId,
        dataType : $("addOptionsForTariffForm").serialize(),
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
        }
    })
}
function addOptionsForTariff(tariffId, optionId){
    $.ajax({
        type: 'POST',
        url:'/adminAccount/editTariff/'+tariffId+'/add/'+optionId,
        dataType: "html",
        success: function (data, textStatus) {
            $("#containerForEditTariff")[0].innerHTML = data;

        },
        error:function (xhr, ajaxOptions, thrownError){
            if(xhr.status==404) {
                sweetAlert({
                    title: "Ошибка",
                    text: "Вы пытаетесь добавить несовместимую опцию!",
                    type: "error"
                });
            }
        }
    })
}
function removeOptionsForTariff(tariffId, optionId){
    $.ajax({
        type: 'POST',
        url:'/adminAccount/editTariff/'+tariffId+'/remove/'+optionId,
        dataType :"html",
        success: function (data, textStatus) {
            $("#containerForEditTariff")[0].innerHTML = data;
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
            $("#content")[0].innerHTML = data;
        }
    });

}
function removeTariff(tariffId){
    $.ajax({
        url:'/adminAccount/addTariff/'+tariffId+'/remove',
        dataType : "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("liEditOptios").attr('class', 'active');
        }
    })
}
function editTariff(tariffId){
    $.ajax({
        url:'/adminAccount/editTariff/'+tariffId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#flex-container")[0].innerHTML = data;
            cleanActiveLiSelection();
            $("liEditOptios").attr('class', 'active');
        }
    })
}

function changeDataTariff(tariffId){
    $.ajax({
        url:'/adminAccount/changeDataTariff/'+tariffId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#containerForEditTariff")[0].innerHTML = data;
            $(".flex-box-buttom-second button").removeClass('active');
        }
    })


}

function addAndRemoveOptionsForTariff(tariffId){
    $.ajax({
        url:'/adminAccount/addAndRemoveOptionsForTariff/'+tariffId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#containerForEditTariff")[0].innerHTML = data;
            $(".flex-box-buttom-second button").removeClass('active');
        }
    })


}

function saveEditTariff(tariffId) {
    var msg = $('#updateTariff').serialize();
    $.ajax({
        type: 'POST',
        url: '/adminAccount/editTariff/updateTariff/' + tariffId,
        data: msg,
        success: function (data, textStatus) {
            $("#flex-container")[0].innerHTML = data;
        }
    })
}



function editOptions() {
    $.ajax({
        url: '/adminAccount/optionList',
        dataType: "html",
        success: function (data, textStatus) {
            $("#content")[0].innerHTML = data;
            $(".sidebar-wrapper ul li").removeClass('active');
            $("#liEditOptions").attr('class', 'active');
        }
    })
}
function createNewOption() {
    $.ajax({
        url: '/adminAccount/addOption',
        dataType: "html",
        success: function (data, textStatus) {
            $("#flex-container-remove-Option")[0].innerHTML = data;
            $(".flex-box-buttom div button").removeClass('active');
            $(this).attr('class', 'active');
           // $("#addOption").attr('class','btn btn-info active');
        }
    })
}
function compatibilityManagement() {
    $.ajax({
        url: '/adminAccount/compatibilityManagement',
        dataType: "html",
        success: function (data, textStatus) {
            $("#flex-container-remove-Option")[0].innerHTML = data;
            $(".flex-box-buttom div button").removeClass('active');
            $("this").attr('class', 'active');
        }
    })
}
function choose(optionId) {
    $.ajax({
        url: '/adminAccount/compatibilityManagement/'+optionId,
        dataType: "html",
        success: function (data, textStatus) {
            $("#flex-container-remove-Option")[0].innerHTML = data;
            $(".flex-box-buttom div button").removeClass('active');
            $("this").attr('class', 'active');
        }
    })
}
function getCompatible(option, optionId) {
    $.ajax({
        url: '/adminAccount/getCompatible/'+option+'/'+ optionId,
        dataType: "html",
        success: function (data, textStatus) {
            $("#flex-container-remove-Option")[0].innerHTML = data;
            $(".flex-box-buttom div button").removeClass('active');
            $("this").attr('class', 'active');
        }
    })
}
function getUncompatible(option, optionId) {
    $.ajax({
        url: '/adminAccount/getUncompatible/'+option+'/'+optionId,
        dataType: "html",
        success: function (data, textStatus) {
            $("#flex-container-remove-Option")[0].innerHTML = data;
            $(".flex-box-buttom div button").removeClass('active');
            $("this").attr('class', 'active');
        }
    })
}



    function addNewOption() {
        var msg = $('#addOptionForm').serialize();
        $.ajax({
            type: 'POST',
            url: "/adminAccount/optionList/add",
            data: msg,
            success: function (data, textStatus) {
                $("#content")[0].innerHTML = data;
            }
        });

    }

    function saveNewClient() {
        var msg = $('#saveNewClientForm').serialize();
        $.ajax({
            type: 'POST',
            url: '/adminAccount/addNewClient/save',
            data: msg,
            success: function (data, textStatus) {
                $("#content")[0].innerHTML = data;
            }
        })
    }

    function saveNewContract() {
        var msg = {
            tariffId: $('#tariffDropDow').val(),
            clientId: $('#clientDropDown').val(),
            number: $('#number').val()
        }
        $.ajax({
            type: 'POST',
            url: 'adminAccount/addNewContract/add',
            data: msg,
            success: function (data, textStatus) {
                $("#content")[0].innerHTML = data;
            }
        })
    }


    function findContractPage() {
        $.ajax({
            url: '/adminAccount/findContractPage',
            dataType: "html",
            success: function (data, textStatus) {
                $("#content")[0].innerHTML = data;
                $(".sidebar-wrapper ul li").removeClass('active');
                $("#liFindContractPage").attr('class', 'active');
            },
            error: function(data) {
                alert('контракта с данным номером не существует');
            }})
    }

    function contractPage() {
        var msg = $('#getFoundContractForm').serialize();
        $.ajax({
            type: 'GET',
            url: '/adminAccount/getFoundContract/' + msg,
            data: msg,
            success: function (data, textStatus) {
                $("#content")[0].innerHTML = data;
            },
            error:function (xhr, ajaxOptions, thrownError){
                if(xhr.status==404) {
                    sweetAlert({
                        title: "Ошибка",
                        text: "Номер не существует!",
                        type: "error"
                    });
                }
            }
        })
    }
function contractBlock(contractId){
    $.ajax({
        url:'/adminAccount/blockAndUnblockContract/' + contractId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#addInformationForContract")[0].innerHTML = data;
            $(".flex-box-buttom div button").removeClass('active');
            $(this).attr('class', 'active');
        }
    })
}
function changeTariffOnAdminDashboard(contractId){
    $.ajax({
        url:'/adminAccount/changeTariffInContract/' + contractId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#addInformationForContract")[0].innerHTML = data;
            $(".flex-box-buttom div button").removeClass('active');
            $(this).attr('class', 'active');
        }
    })
}

function contractInformation(contractId){
    $.ajax({
        url:'/adminAccount/contractInfo/'+contractId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#addInformationForContract")[0].innerHTML = data;
            $(".flex-box-buttom div button").removeClass('active');
            $(this).attr('class', 'active');
        }
    })
}



function optionsForCurrentContract(contractId){
    $.ajax({
        url:'/adminAccount/editOptionsForContract/' + contractId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#addInformationForContract")[0].innerHTML = data;
            $(".flex-box-buttom div button").removeClass('active');
            $(this).attr('class', 'active');
        }
    })
}
function pageToRemoveContract(contractId){
    $.ajax({
        url:'/adminAccount/pageToRemoveContract/' + contractId,
        dataType : "html",
        success: function (data, textStatus) {
            $("#addInformationForContract")[0].innerHTML = data;
            $(".flex-box-buttom div button").removeClass('active');
            $(this).attr('class', 'active');
        }
    })
}
function removeContract(contractId){
    $.ajax({
        url:'/adminAccount/removeContract/' + contractId,
        dataType : "html",
        success: function (data, textStatus) {
            sweetAlert({
                title: "Выполнено",
                text: "Контракт успешно удален!",
                type: "success"
            });
            $("#content")[0].innerHTML = data;

        }
    })
}


    function removeOption(optionId) {
        $.ajax({
            url: '/adminAccount/optionList/' + optionId + '/remove',
            dataType: "html",
            success: function (data, textStatus) {
                $("#content")[0].innerHTML = data;

            }
        })
    }

    function addNewClient() {
        $.ajax({
            url: '/adminAccount/addNewClient',
            dataType: "html",
            success: function (data, textStatus) {
                $("#content")[0].innerHTML = data;
                $(".sidebar-wrapper ul li").removeClass('active');
                $("#liAddNewClient").attr('class', 'active');
            }
        })
    }

    function addNewContract() {
        $.ajax({
            url: '/adminAccount/addNewContract',
            dataType: "html",
            success: function (data, textStatus) {
                $("#content")[0].innerHTML = data;
                $(".sidebar-wrapper ul li").removeClass('active');
                $("#liAddNewContract").attr('class', 'active');
            }
        })
    }


    function blockByAdmin(contractId) {
        $.ajax({
            url: '/adminAccount/getFoundContract/' + contractId + '/block',
            dataType: "html",
            success: function (data, textStatus) {
                $("#addInformationForContract")[0].innerHTML = data;
                cleanActiveLiSelection();
                $("liAddNewContract").attr('class', 'active');
            }
        })

    }

    function unblockByAdmin(contractId) {
        $.ajax({
            url: '/adminAccount/getFoundContract/' + contractId + '/unblock',
            dataType: "html",
            success: function (data, textStatus) {
                $("#addInformationForContract")[0].innerHTML = data;
                cleanActiveLiSelection();
                $("liAddNewContract").attr('class', 'active');
            }
        })


    }



    function changeTariffForClientContract(contractId, tariffId) {
        $.ajax({
            url: '/adminAccount/getFoundContract/' + contractId + '/change/' + tariffId,
            dataType: "html",
            success: function (data, textStatus) {
                $("#addInformationForContract")[0].innerHTML = data;
                cleanActiveLiSelection();
                $("liAddNewContract").attr('class', 'active');
            }
        })

        // window.location.replace('/adminAccount/getFoundContract/' + contractId + '/change/'+tariffId);

    }

    function addOptionForClientContract(contractId, optionId) {
        $.ajax({
            url: '/adminAccount/getFoundContract/' + contractId + '/add/' + optionId,
            dataType: "html",
            success: function (data, textStatus) {
                $("#addInformationForContract")[0].innerHTML = data;
                cleanActiveLiSelection();
                $("liAddNewContract").attr('class', 'active');
            }
        })

    }


    function deleteOptionForClientContract(contractId, optionId) {
        $.ajax({
            url: '/adminAccount/getFoundContract/' + contractId + '/remove/' + optionId,
            dataType: "html",
            success: function (data, textStatus) {
                $("#addInformationForContract")[0].innerHTML = data;
                cleanActiveLiSelection();
                $("liAddNewContract").attr('class', 'active');
            }
        })

    }

    function cleanActiveLiSelection() {
        // $("#clientNavUl")[0].childNodes
            $('#clientNavUl').find('li').removeClass('active');



    }


    



