import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.antislashn.bo.Adresse;
import org.antislashn.bo.ClientContactService;
import org.antislashn.bo.Contact;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	void testGetAllContacts() {
  List<Contact> contacts = ClientContactService.getAllContacts();
  assertNotNull(contacts);
  assertTrue(contacts.size()>0);		
	}
	
	@Test
	void testGetContact() {
  Contact contact = ClientContactService.getContact(80);
  assertNotNull(contact);
  assertEquals(81, contact.getId());		
	}
	
	@Test
	void testGetAllAdresses() {
		Long id =15L;
  List<Adresse> adresses = ClientContactService.getAdresseByContactId(id);
  assertNotNull(adresses);
  assertTrue(adresses.size()>0);
  assertEquals(6,adresses.size() );
	}
	
	

	@Test 
	void testCreateContact() {
		List<Contact> contacts = ClientContactService.getAllContacts();
		int size = contacts.size();
		ClientContactService.createContact("M", "Doe", "John");
		contacts = ClientContactService.getAllContacts();
		int size2=contacts.size();
		assertNotEquals(size, size2);
//		ClientContactService.getContact(100);
	}
	
	@Test 
	void testDeleteContact() {
		List<Contact> contacts = ClientContactService.getAllContacts();
		int size = contacts.size();
		ClientContactService.deleteContact(size);
		contacts = ClientContactService.getAllContacts();
		int size2 = contacts.size();
		assertNotEquals(size, size2);
		ClientContactService.createContact("M", "Doe", "John");
//		ClientContactService.getContact(100);
//		Contact c1 = new Contact ("M", "Doe", "John");
//		Contact c2 =ClientContactService.createContact(c1);
//		ClientContactService.deleteContact(c2.getId());
//		Contact c3 = ClientContactService.findById(c2.getId());
	}
	
	@Test 
	void testUpdateContact() {
		Contact contact= ClientContactService.getContact(7);
		ClientContactService.updateContact(7L, "Mr", "Pas", "Doué");
		Contact c = ClientContactService.getContact(7);
		assertNotEquals(c.getPrenom(), contact.getPrenom());
		assertNotEquals(c.getNom(), contact.getNom());
		ClientContactService.updateContact(7L, "Mr", "Sur", "Fait");
//		ClientContactService.getContact(100);
	}
	
}
