package messaging.agent;
import messaging.MessageUser;


	public class AgentMessages{
	
		private AgentMessageType theMessageType;
		private MessageUser from;
		private MessageUser to;
		
		public AgentMessages(MessageUser from, MessageUser to, AgentMessageType theMessageType){
			this.from=from;
			this.to=to;
			this.theMessageType=theMessageType;
		}
		
		AgentMessageType getMessageType(){return theMessageType;}

		public AgentMessageType getTheMessageType() {
			return theMessageType;
		}

		public MessageUser getFrom() {
			return from;
		}

		public MessageUser getTo() {
			return to;
		}
	};
