
document.addEventListener('DOMContentLoaded', function (e) {

    var editButtons = document.getElementsByClassName("editButton");
    var activateButtons = document.getElementsByClassName("activateButton");
    var globalId;
    for (var i = 0; i < editButtons.length; i++){
        editButtons[i].addEventListener('click',function (e) {
            globalId = this.id;
            globalId = globalId.split("|");
            globalId = globalId[1];
            toPage("editUser.html?id=" + globalId);
        });
        activateButtons[i].addEventListener('click', function () {

        });
    }

});