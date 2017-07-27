function logout() {
   var href = window.location.href;
    href = href.split('/');
    href = href[0];
    window.location.href = href + "/index.html";
}

function addNewUser(){
    var href = window.location.href;
    href = href.split('/');
    href = href[0];
    window.location.href = href + "/newUser.html";
}