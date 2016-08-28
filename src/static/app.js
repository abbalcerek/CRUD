/**
 * Created by adam on 28.08.16.
 */

let path = "http://localhost:8081/";

$.get(`${path}users`, function(data) {
    $.each(data, function(index, user) {
        appendUser(user)
    });
});

let addUser = function () {

    let form = {};
    let formHtml = $('#userForm');
    $.each(formHtml.serializeArray(), function (i, field) {
        form[field.name] = field.value || "";
    });

    $.ajax({
        type: "POST",
        url: `${path}saveUser`,
        data: JSON.stringify(form),
        success: function(user) {
            appendUser(user);
            formHtml.each(function(){
                this.reset();
            });
        },
        contentType:'application/json',
        dataType: "json"
    });
};

let removeUser = function (userId) {
    $.ajax({
        type: "DELETE",
        url: `${path}deleteUser/${userId}`,
        success: function() {
            $(`#user-${userId}`).remove();
        }
    });
};

let getUser = function(userId, success) {
    $.ajax({
        type: "GET",
        url: `${path}user/${userId}`,
        success: success
    });
};

let editUser = function () {
    let form = {id: editedUser.id};

    let formHtml = $('#updateUserForm');
    $.each(formHtml.serializeArray(), function (i, field) {
        form[field.name] = field.value || "";
    });

    $.ajax({
        type: "PUT",
        url: `${path}updateUser`,
        data: JSON.stringify(form),
        success: function(user) {
            modifyUser(user);
        },
        contentType:'application/json',
        dataType: "json"
    });
};

let appendUser = function (user) {
    $("#userList").append(
        `<li id="user-${user.id}" class="list-group-item">name: ${user.firstName} ${user.lastName}
         <br> phone: ${user.phoneNumber}
         <br>age: ${user.age}
         <br><button class="btn btn-default" onclick="removeUser(${user.id})" id="delete-${user.id}">delete</button>
         <button class="btn btn-default" data-toggle="modal" data-target="#edit-modal"
           id="update-${user.id}"  onclick="setEditedUser(${user.id})">update</button>
       </li>`);
};

let modifyUser = function (user) {
    $(`#user-${user.id}`).html(
        `name: ${user.firstName} ${user.lastName}
      <br> phone: ${user.phoneNumber}
      <br>age: ${user.age}
      <br><button class="btn btn-default" onclick="removeUser(${user.id})" id="delete-${user.id}">delete</button>
      <button class="btn btn-default" data-toggle="modal" data-target="#edit-modal"
        id="update-${user.id}"  onclick="setEditedUser(${user.id})">update</button>`
    );
};

let setEditedUser = function(userId) {
    getUser(userId, function (data) {
        editedUser = data;
        $("#firstNameUpdate").val(data.firstName);
        $("#lastNameUpdate").val(data.lastName);
        $("#ageUpdate").val(data.age);
        $("#phoneNumberUpdate").val(data.phoneNumber);
    })
};

//state
let editedUser = undefined;
