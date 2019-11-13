package org.antislashn.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ClientContactService {
	private static final String WEB_APPLI ="http://localhost:9080/jboss-contacts-rest";
	
	public static final List<Contact> getAllContacts() {
String uri= WEB_APPLI + "/rest/contacts/all";
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		
		Contact[] contacts = target.request("application/json;charset=utf-8").get(Contact[].class);
		return Arrays.asList(contacts);
	}
	
	public List<Adresse> getAllAdresses(){
String uri= WEB_APPLI + "/rest/contacts/allAdresses";
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		Adresse[] adresses = target.request("application/json;charset=utf-8").get(Adresse[].class);
		return Arrays.asList(adresses);
	}
	
	public static final List<Adresse> getAdresseByContactId(long id) {
		
String uri= WEB_APPLI + "/rest/contacts/adresses/"+id;
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		Adresse[] adresses = target.request("application/json;charset=utf-8").get(Adresse[].class);
		return Arrays.asList(adresses);
	}
	
  public static final void createContact(String civilite, String nom, String prenom) {
	  Contact contact = new Contact(0, civilite, nom, prenom);
	  String uri= WEB_APPLI +"/rest/contacts/add";
	  Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		contact = target.request("application/json;charset=utf-8").post(Entity.json(contact), Contact.class);
  }
  
  public static final void deleteContact(long id) {
	  String uri= WEB_APPLI +"/rest/contacts/del/"+id;
	  Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
//		String response =target.request(MediaType.TEXT_PLAIN).delete(String.class);
		target.request().delete();
//		return response.equalsIgnoreCase("ok");
  }
  
  public static final Contact getContact(long id) {
	  String uri= WEB_APPLI + "/rest/contacts/"+id;
	  		
	  		Client client = ClientBuilder.newClient();
	  		WebTarget target = client.target(uri);
	  		
	  		Contact contact = target.request("application/json;charset=utf-8").get(Contact.class);
	  		return contact;
	  	}
  
  public static final void updateContact(Long id, String civilite, String nom, String prenom) {
	  Contact c = new Contact(id, civilite, nom, prenom);
	  String uri= WEB_APPLI +"/rest/contacts/edit";
	  Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		Contact contact = target.request("application/json;charset=utf-8").post(Entity.json(c), Contact.class);
  }
  

}
