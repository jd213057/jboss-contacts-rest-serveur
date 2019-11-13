package org.antislashn.bo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class MainClientContactsRest {

	public static void main(String[] args) {
		String domain = "http://localhost:9080/jboss-contacts-rest";
		String uri= domain + "/rest/contacts/all";
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		
		Contact[] contacts = target.request("application/json;charset=utf-8").get(Contact[].class);
				for(Contact c : contacts) {
					System.out.println(c);
				}
				
		ClientContactService service = new ClientContactService();
		System.out.println(service.getAllContacts());
		System.out.println(service.getAdresseByContactId(15));
//		service.createContact("M", "Travolta", "John");
//		service.deleteContact(78);
		System.out.println(service.getContact(15));
//		service.updateContact(7L, "Mme", "Hola", "Bonjour");
		System.out.println(service.getAllAdresses());
	}

}
