document.addEventListener('DOMContentLoaded', function (e) {
    var element = document.getElementById("isSuccessAdd");
    var href1 = window.location.href;
    href1 = href1.split('?');
    var href = href1[1];
    href = href.split('&');
    var success = 3;
    var correct = 3;
    var successUpdate = 3;
    for (var i = 0; i < href.length; i++) {
        if (href[i].substring(0, 12) === 'isSuccessAdd') {
            success = href[i].substring(13, href[i].length);
        }
        if(href[i].substring(0,12) === 'correctInput'){
            correct = href[i].substring(13,href[i].length);
        }
        if (href[i].substring(0, 12) === 'isSuccessUpd') {
            successUpdate = href[i].substring(13, href[i].length);
        }
    }
    if (success != 3){
        if (success){
            element.innerText = "The user has been added to the database";
        }
        else{
            element.innerText = "The user hasn't been added to the database. Please, try again.";
        }
    }
    if (successUpdate != 3){
        if (successUpdate === "true"){
            element.innerText = "The user has been update";
        }
        else{
            element.innerText = "The user hasn't been update. Please, try again.";
        }
    }
    if (correct != 3){
        if (correct === "false"){
            element.innerText = "Incorrect data were entered! Please, try again";
        }
    }


});