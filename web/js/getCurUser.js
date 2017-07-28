document.addEventListener('DOMContentLoaded', function (e) {

    var xhr = new XMLHttpRequest();
    var id_par = window.location.href;
    id_par = id_par.split("?");
    id_par = id_par[1];
    id_par = id_par.split('&');
    var iii;
    for (var j = 0; j < id_par.length;j++){
        var sub = id_par[j].substring(0,2);
        if (sub === "id"){
            iii = id_par[j];
        }
    }
    var string = 'http://localhost:8080/getCurUser?' + iii;
    xhr.open('GET', string, false);
    xhr.send();
    if (xhr.status === 200) {
        var json = JSON.parse(xhr.responseText);
    }
    if (json == undefined) {
        // document.getElementById('textHere').style.display = 'none';

        //document.getElementById('shouldBeBlocked').style.display = 'none';
        var el = document.getElementsByClassName("container-fluid")[0];
        var row9 = document.createElement("div");
        row9.className = "row text-center";
        var p99 = document.createElement("p");
        p99.innerText = "Sorry, something is wrong";
        row9.appendChild(p99);
        el.appendChild(row9);
    }
    if (json[0] != undefined){

        for (var i = 0; i < json.length; i++) {
            var id = parseInt(json[i]["id"]);
            var firstname = json[i]["firstname"];
            var lastname = json[i]["lastname"];
            var username = json[i]["username"];
            var password = json[i]["password"];
            var email = json[i]["email"];
            var birthday = json[i]["birthday"];
            var createdTimestamp = json[i]["createdTimestamp"];
            var lastUpdatedTimeStamp = json[i]["lastUpdatedTimeStamp"];
            var isActive = json[i]["isActive"];
            var role = json[i]["role"];
            var zip = json[i]["zip"];
            var country = json[i]["country"];
            var city = json[i]["city"];
            var district = json[i]["district"];
            var street = json[i]["street"];

            document.getElementById("id").value = id;
            document.getElementById("username").value = username ;
            document.getElementById("firstname").value = firstname;
            document.getElementById("lastname").value = lastname;
            document.getElementById("password").value = password;
            document.getElementById("email").value = email;
            document.getElementById("birthday").value = birthday.substring(0,10);
            document.getElementById("zip").value = zip;
            document.getElementById("country").value = country;
            document.getElementById("city").value = city;
            document.getElementById("district").value = district;
            document.getElementById("street").value = street;
            if (isActive === 1) document.getElementById("active").selected = true;
            else document.getElementById("inactive").selected = true;
            if (role === "admin") document.getElementById("admin").selected = true;
            else document.getElementById("user").selected = true;
        }
    }
    else{
        document.getElementById('textHere').style.display = 'none';
        document.getElementById('shouldBeBlocked').style.display = 'none';
        var el = document.getElementsByClassName("container-fluid")[0];
        var row9 = document.createElement("div");
        row9.className = "row text-center";
        var p99 = document.createElement("p");
        p99.innerText = "Sorry, You do not have permission to view this page.";
        row9.appendChild(p99);
        el.appendChild(row9);
    }
});