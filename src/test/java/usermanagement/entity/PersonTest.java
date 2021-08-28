package usermanagement.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {
	private Person person = new Person();

	@Test
	public void test_setfName() {
		final String fName = "fName1";

		person.setfName(fName);
		assertEquals(fName, person.getfName());
	}

	@Test
	public void test_setmName() {
		final String mName = "mName1";

		person.setmName(mName);
		assertEquals(mName, person.getmName());
	}

	@Test
	public void test_setlName() {
		final String lName = "lName1";

		person.setlName(lName);
		assertEquals(lName, person.getlName());
	}
	
	@Test
	public void test_setCompanyName(){
		final String companyName = "foo";
		person.setCompanyName(companyName);
		assertEquals(companyName,person.getCompanyName());
	}
	@Test
	public void test_setPersonId(){
		final int personId = 13;
		person.setPersonId(personId);
		assertEquals(personId, person.getPersonId());
	}

}
