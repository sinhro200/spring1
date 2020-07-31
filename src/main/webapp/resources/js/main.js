
function createUser(){
	var userName = document.getElementById("user_name").value;
    var userLogin = document.getElementById("user_login").value;
    var userEmail = document.getElementById("user_email").value;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST","/users/save");
    xmlhttp.setRequestHeader("Content-Type","application/json");
    xmlhttp.send(JSON.stringify({
    	name:userName,
    	login:userLogin,
    	email:userEmail
    }));

    xmlhttp.onreadystatechange = function(){
    	if (this.readyState == 4 && this.status == 200) {
    		loadUsers();
    	}
    }
}

function deleteUser(userId) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "/users/delete/" + userId, true);
    xhttp.send();
    xhttp.onreadystatechange = function(){
    	if (this.readyState == 4 && this.status == 200) {
    		loadUsers();
    	}
    }
}

function loadUsers(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
    	if (this.readyState == 4 && this.status == 200) {
    		var users = JSON.parse(this.responseText);
    		var html = '<tr>\n' +
                    '        <th>User id</th>\n' +
                    '        <th>User name</th>\n' +
                    '        <th>User login</th>\n' +
                    '        <th>User email</th>\n' +
                    '        <th>Delete</th>\n' +
                    '    </tr>';
            for (var i = 0; i < users.length; i++) {
                var user = users[i];
                console.log(user);
                html = html + '<tr><td>' + user.id + '</td>\n' +
                    '        <td>' + user.name + '</td>\n' +
                    '        <td>' + user.login + '</td>\n' +
                    '        <td>' + user.email + '</td>' +
                    '        <td><button onclick="deleteUser(' + user.id + ')">Delete</button></td></tr>';

            }
            document.getElementById("users-table").innerHTML = html;
    	}
    };
    xhttp.open("GET", "/users/findAll", true);
    xhttp.send();
}
document.addEventListener("DOMContentLoaded", loadUsers);