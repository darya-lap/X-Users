document.addEventListener('DOMContentLoaded', function (e) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/update', false);
    xhr.send();
    if (xhr.status === 200) {
        var json = JSON.parse(xhr.responseText);
    }

    var table = document.getElementById('usersTable');
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

        var row = document.createElement("div");
        row.className = "row";
        var colmd12 = document.createElement("div");
        colmd12.className = "col-md-12";
        var row2 = document.createElement("div");
        row2.className = "row";

        var col1 = document.createElement("div");
        col1.className = "col-md-1";
        var p1 = document.createElement("p");
        p1.innerText = id;
        col1.appendChild(p1);
        row2.appendChild(col1);

        var col2 = document.createElement("div");
        col2.className = "col-md-1";
        var p2 = document.createElement("p");
        p2.innerText = firstname;
        col2.appendChild(p2);
        row2.appendChild(col2);

        var col3 = document.createElement("div");
        col3.className = "col-md-1";
        var p3 = document.createElement("p");
        p3.innerText = lastname;
        col3.appendChild(p3);
        row2.appendChild(col3);

        var col4 = document.createElement("div");
        col4.className = "col-md-1";
        var p4 = document.createElement("p");
        p4.innerText = birthday.substring(0,10);
        col4.appendChild(p4);
        row2.appendChild(col4);

        // var col5 = document.createElement("div");
        // col5.className = "col-md-1";
        // var p5 = document.createElement("p");
        // p5.innerText = email;
        // col5.appendChild(p5);
        // row2.appendChild(col5);

        var col6 = document.createElement("div");
        col6.className = "col-md-1";
        var p6 = document.createElement("p");
        p6.innerText = username;
        col6.appendChild(p6);
        row2.appendChild(col6);

        var col7 = document.createElement("div");
        col7.className = "col-md-1";
        var p7 = document.createElement("p");
        p7.innerText = password;
        col7.appendChild(p7);
        row2.appendChild(col7);

        var col8 = document.createElement("div");
        col8.className = "col-md-1";
        var p8 = document.createElement("p");
        p8.innerText = createdTimestamp.substring(0,19);
        col8.appendChild(p8);
        row2.appendChild(col8);

        var col9 = document.createElement("div");
        col9.className = "col-md-1";
        var p9 = document.createElement("p");
        p9.innerText = lastUpdatedTimeStamp.substring(0,19);
        col9.appendChild(p9);
        row2.appendChild(col9);

        var col10 = document.createElement("div");
        col10.className = "col-md-1";
        var p10 = document.createElement("p");
        if (isActive === 1){
            p10.innerText = "Active";
            row.style = "background: none;"
        }
        else{
            p10.innerText = "Inactive";
            row.style = "background: #BFBFBF;"
        }
        col10.appendChild(p10);
        row2.appendChild(col10);

        var col11 = document.createElement("div");
        col11.className = "col-md-1";
        var p11 = document.createElement("p");
        p11.innerText = role;
        col11.appendChild(p11);
        row2.appendChild(col11);

        var col12 = document.createElement("div");
        col12.className = "col-md-1";
        var div = document.createElement("div");
        div.className = "btn-group-vertical";
        div.style = "width: 100%";
        var but1 = document.createElement("button");
        but1.className = "btn btn-primary btn-xs";
        but1.onclick = "";
        if (isActive === 1){
            but1.innerText = "Deactivate";
        }
        else{
            but1.innerText = "Activate";
        }
        var but2 = document.createElement("button");
        but2.className = "btn btn-primary btn-xs";
        but2.onclick = "";
        but2.innerText = "Edit";
        div.appendChild(but1);
        div.appendChild(but2);
        col12.appendChild(div);
        row2.appendChild(col12);

        var row3 = document.createElement("div");
        row3.className = "row";
        var col33 = document.createElement("div");
        col33.className = "col-md-6";
        col33.style = "border-top-width: 1px;";
        var p33 = document.createElement("p");
        p33.innerText = "Address: " + zip + ", " + country + ", " + city + ", " + district + ", " + street;
        col33.appendChild(p33);
        var col32 = document.createElement("div");
        col32.className = "col-md-3";
        var p32 = document.createElement("p");
        p32.innerText = "E-mail: " + email;
        col32.appendChild(p32);
        row3.appendChild(col33);
        row3.appendChild(col32);

        colmd12.appendChild(row2);
        colmd12.appendChild(row3);
        row.appendChild(colmd12);
        table.appendChild(row);
        var hr = document.createElement("hr");
        table.appendChild(hr);
    }
});