package usermanagement.service;

import org.junit.Before;
import org.junit.Test;
import usermanagement.entity.Person;

import static org.junit.Assert.assertEquals;

public class TransformServiceTest {
	private final TransformService transformService = new TransformService();
	private static final int ID = 1;
	private static final String FIRST_NAME = "Ali";
	private static final String MIDDLE_NAME = "Reza";
	private static final String LAST_NAME = "Alavi";
	private static final String COMPANY_NAME = "Microsoft";
	private User user = new User();
	private Person person = new Person();

	@Before
	public void setup()
	{
		user.setUserId(ID);
		user.setFirstName(FIRST_NAME);
		user.setLastName(LAST_NAME);
		user.setCompanyName(COMPANY_NAME);

		person.setPersonId(ID);
		person.setfName(FIRST_NAME);
		person.setmName(MIDDLE_NAME);
		person.setlName(LAST_NAME);
		person.setCompanyName(COMPANY_NAME);
	}

	@Test
	public void toUserDomain_result_should_have_equal_attributes_with_given_person()
	{
		// Action
		final User convertedUser = transformService.toUserDomain(person);

		// Assert
		assertEquals(person.getPersonId(), (int)convertedUser.getUserId());
		assertEquals(person.getfName(), convertedUser.getFirstName());
		assertEquals(person.getlName(), convertedUser.getLastName());
		assertEquals(person.getCompanyName(), convertedUser.getCompanyName());
	}

	@Test
	public void toUserEntity_result_should_have_equal_attributes_with_given_user()
	{
		// Action
		final Person convertedPerson = transformService.toUserEntity(user);

		// Assert
		assertEquals((int) user.getUserId(), convertedPerson.getPersonId());
		assertEquals(user.getFirstName(), convertedPerson.getfName());
		assertEquals(user.getLastName(), convertedPerson.getlName());
		assertEquals(user.getCompanyName(), convertedPerson.getCompanyName());
	}

	@Test
	public void converting_a_user_with_id_to_person_and_converting_back_to_user_should_return_the_initial_user()
	{
		// Action
		final Person convertedPerson = transformService.toUserEntity(user);
		final User convertedUser = transformService.toUserDomain(convertedPerson);

		// Assert
		assertEquals(user, convertedUser);
	}
}
