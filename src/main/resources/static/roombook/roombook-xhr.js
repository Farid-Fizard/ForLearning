function showAllRooms(){
    console.log("XHR show all rooms")
    let xhr = new XMLHttpRequest();
    let url="http://localhost:8080/room/api/";
    xhr.open("GET", url);
    xhr.onload= function(){
        console.log("XHR onload isledi")
    }
    xhr.onerror= function (){
        console.log("XHR xeta bas verdi")
    }
    xhr.send();

}
showAllRooms();