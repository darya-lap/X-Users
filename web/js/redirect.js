
function toPage(s){
    var href = window.location.href;
    href = href.split('/');
    href = href[0];
    window.location.href = href + "/" + s;
}