import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

public class ConversationTest {
	public static void main(String[] args) {
		test();
	}
	
	private static void test(){
		String workspaceId = "33ba3ce1-5642-41a7-8d22-f57c29750d72";
		ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2016_07_11);
		service.setUsernameAndPassword("a2f9b231-fb7c-4a56-8d82-0ff6d4f44efb", "MNyO0Y0K4IBE");
		
		MessageResponse response = service.message(workspaceId, null).execute();
		System.out.println(response);
		
		System.out.println("==========================");
		MessageRequest newMessage = new MessageRequest.Builder().inputText("turn on light")
				.context(response.getContext())
				.build();
		response = service.message(workspaceId, newMessage).execute();
		System.out.println(response);
		
	}
	
	private static void car(){
		String workspaceId = "a54b677c-1208-4b46-aa24-46f09f260aed";
		ConversationService service = new ConversationService("2016-09-20");
		service.setUsernameAndPassword("a2f9b231-fb7c-4a56-8d82-0ff6d4f44efb", "MNyO0Y0K4IBE");
		
		MessageResponse response = service.message(workspaceId, null).execute();
		String conversationId = (String)response.getContext().get("conversation_id");
		System.out.println(response);
		
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("conversation_id", conversationId);
		
		System.out.println("==========================");
		MessageRequest newMessage = new MessageRequest.Builder().inputText("turn off light")
				.context(response.getContext())
				.build();
		response = service.message(workspaceId, newMessage).execute();
		System.out.println(response);
		
		System.out.println("==========================");
		newMessage = new MessageRequest.Builder().inputText("turn off light")
				.context(response.getContext())
				.build();
		response = service.message(workspaceId, newMessage).execute();
		System.out.println(response);
		
		System.out.println("==========================");
	}
}
