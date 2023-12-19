function showAllRooms(){
    console.log("XHR show all rooms")
    let xhr = new XMLHttpRequest();
    let url="http://localhost:8080/room/api/";
    xhr.open("GET", url);
    xhr.onload= function(){
        console.log("XHR onload isledi")
        console.log("server response= "+ xhr.responseText)
        let rooms= JSON.parse(xhr.responseText);
        addRoomsToTable(rooms);

    }
    xhr.onerror= function (){
        console.log("XHR xeta bas verdi")
    }
    xhr.send();

}

function addRoomsToTable(rooms) {
    let roomsTable= document.getElementById("rooms_table");

    while(roomsTable.rows.length >0){
        roomsTable.deleteRow(0);
    }
    console.log("addRoomsToTable() funksiyasi isledi")
    for (let i = 0; i < rooms.length; i++) {
    //    console.log(rooms[i].id + ' ' + rooms[i].name + ' ' + rooms[i].capacity + ' ' + rooms[i].projector + ' ' + rooms[i].whiteboard);
        let room = '<tr>' +
            '<td>'+ rooms[i].id +'</td>' +
            '<td>'+ rooms[i].name +'</td>' +
            '<td>'+ rooms[i].capacity +'</td>' +
            '<td>'+ rooms[i].projector +'</td>' +
            '<td>'+ rooms[i].whiteboard +'</td>' +
            '<td><button onclick="showRoom('+ rooms[i].id +')">View</button> &nbsp; <button onclick="updateRoom('+ rooms[i].id +')">Update</button></td>' +
            '</tr>';
       console.log(roomsTable)
        let newRow=roomsTable.insertRow(roomsTable.rows.length);
        newRow.innerHTML=room;
    }
}


function showRoom(id){
//console.log("showRoom() funksiyasi isleyir");
    console.log("gelen id="+id);

    let xhr= new XMLHttpRequest();
    let url="http://localhost:8080/room/api/"+id;
    xhr.open("GET",url)

    xhr.onload= function (){

        console.log("gelen data="+xhr.responseText);
        let room= JSON.parse(xhr.responseText);
        document.getElementById("roomId").innerHTML= room.id;
        document.getElementById("roomName").innerHTML= room.name;
        document.getElementById("roomCapacity").innerHTML= room.capacity;
        document.getElementById("roomProjector").innerHTML= room.projector;
        document.getElementById("roomWhiteboard").innerHTML= room.whiteboard;
        document.getElementById("roomDetail").style.display='block';
    }

    xhr.onerror= function (){
        console.log("Error is occured"+id);
    }

    xhr.send();

}

function updateRoom(id){
//console.log("showRoom() funksiyasi isleyir");
    console.log("gelen id="+id);

    let xhr= new XMLHttpRequest();
    let url="http://localhost:8080/room/api/"+id;
    xhr.open("GET",url)

    xhr.onload= function (){

        console.log("gelen data="+xhr.responseText);
        let room= JSON.parse(xhr.responseText);
        document.getElementById("editRoomId").innerHTML= room.id;
        document.getElementById("editRoomName").value= room.name;
        document.getElementById("editRoomCapacity").value= room.capacity;
        document.getElementById("editRoomProjector").checked= room.projector;
        document.getElementById("editRoomWhiteboard").checked= room.whiteboard;
        document.getElementById("editRoomDetail").style.display='block';
    }

    xhr.onerror= function (){
        console.log("Error is occured"+id);
    }

    xhr.send();

}

function savingUpdates(){
    let roomId= document.getElementById("editRoomId").innerHTML;
    let roomName= document.getElementById("editRoomName").value;
    let roomCapacity= document.getElementById("editRoomCapacity").value;
    let roomProjector= document.getElementById("editRoomProjector").checked;
    let roomWhiteboard= document.getElementById("editRoomWhiteboard").checked;

    let room={
        id: roomId,
        name: roomName,
        capacity: roomCapacity,
        projector: roomProjector,
        whiteboard: roomWhiteboard
    }
    let roomJson=JSON.stringify(room);
    console.log("roomJson "+ roomJson);

    let xhr= new XMLHttpRequest();
    let url="http://localhost:8080/room/api/"+roomId;
    xhr.open("PUT",url)
    xhr.onload=function(){
        if(xhr.status==200) {
            console.log("Updated succesfully")
            showAllRooms();
        }
        else
            console.log("Update failed")
    }
    xhr.onerror= function (){
        console.log("Error is occured"+ xhr.responseText);
    }
    xhr.setRequestHeader("Content-Type","application/json")
    xhr.send(roomJson)

}

showAllRooms();