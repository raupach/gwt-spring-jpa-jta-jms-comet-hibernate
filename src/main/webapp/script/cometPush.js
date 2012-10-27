
amq.uri = 'frontend/amq';

var numberChangedMessageHandler = {
	rcvMessage : function(message) {
		
		var jsonValue = message.nodeValue;
		numberChangedExternal (jsonValue);
	}
};

function addCometListener () {

  amq.addListener("frontendClient", "topic://cometPush", numberChangedMessageHandler.rcvMessage);
}
