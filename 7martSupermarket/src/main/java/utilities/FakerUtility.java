package utilities;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Food;

public class FakerUtility {
	public String getFakeFirstName() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.firstName();

		return text;

	}

	public String getPassword() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.lastName();

		return text;
	}

	public String getFakeCityName() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.cityName();

		return text;

	}

	public String getFakeCategoryName() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = faker.food().ingredient();

		return text;

	}

	public String getFakeBookName() {
		Faker faker = new Faker();
		String text = faker.book().title();
		return text;
	}

	public String getFakeArtistName() {
		Faker faker = new Faker();
		String text = faker.artist().name();
		return text;
	}
}
