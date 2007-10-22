package rlVizLib.messaging.agent;

import rlVizLib.messaging.GenericMessage;
import rlVizLib.messaging.GenericMessageParser;
import rlVizLib.messaging.NotAnRLVizMessageException;

public class AgentMessageParser extends GenericMessageParser{
	public static AgentMessages parseMessage(String theMessage) throws NotAnRLVizMessageException{
		GenericMessage theGenericMessage = new GenericMessage(theMessage);

		int cmdId=theGenericMessage.getTheMessageType();

		if(cmdId==AgentMessageType.kAgentQueryValuesForObs.id()){
			AgentMessages theRequest= new AgentValueForObsRequest(theGenericMessage);
			return theRequest;
		}

	System.out.println("AgentMessageParser - unknown query type: "+theMessage);
	Thread.dumpStack();
	System.exit(1);
	return null;
}
}