var socket = new Websocket("ws://https://220.80.88.122:8081/00Project2/index.html");


socket.onopen = function(event) {
	socket.send("웹소켓");
};