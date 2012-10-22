//var amq = org.activemq.Amq;
//amq.init({
//	uri : '/frontend/amq',
//	logging : true,
//	timeout : 20
//});


var numberChangedMessageHandler = {
	rcvMessage : function(message) {
		
		var jsonValue = message.nodeValue;
		numberChangedExternal (jsonValue);
	}
};

amq.addListener("frontendClient", "topic://cometPush", numberChangedMessageHandler.rcvMessage);

