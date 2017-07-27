document.addEventListener('DOMContentLoaded', function (e) {
    var element = document.getElementById("userNameSurname");
    var href1 = window.location.href;
    href1 = href1.split('?');
    var href = href1[1];
    href = href.split('&');
    var name1;
    var surname1;
    for (var i = 0; i < href.length; i++) {
        if (href[i].substring(0, 4) === 'name') {
            name1 = href[i].substring(5, href[i].length);
        }
        if (href[i].substring(0, 7) === 'surname') {
            surname1 = href[i].substring(8, href[i].length);
        }
    }
    element.innerText = "Hello, " + name1 + " " + surname1;
});
