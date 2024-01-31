package com.ilia.tacos;

import com.ilia.tacos.data.IngredientRepository;
import com.ilia.tacos.data.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TacosApplicationTests {

	@Autowired
	public OrderRepository orderRepository;
	@Autowired
	public IngredientRepository ingredientRepository;



	@Test
	void contextLoads() {
//		Ingredient ingredient = new Ingredient("dasd", "Shrimp", Ingredient.Type.PROTEIN);
		Taco taco = new Taco();
		Ingredient ingredient = ingredientRepository.findById("CARN").orElse(null);
		taco.getIngredients().add(ingredient);
		taco.setName("Ilusha");
		TacoOrder tacoOrder = new TacoOrder();
		tacoOrder.setCcCVV("354");
		tacoOrder.setCcNumber("4580910100198720");
		tacoOrder.setCcExpiration("07/24");
		tacoOrder.setDeliveryName("asdas");
		tacoOrder.setDeliveryCity("holon");
		tacoOrder.setDeliveryState("tel av");
		tacoOrder.setDeliveryZip("34534");
		tacoOrder.setDeliveryStreet("shehset ha yamim");
		tacoOrder.getTacos().add(taco);
		orderRepository.save(tacoOrder);
		// Retrieve the saved ingredient from the repository
		Ingredient savedIngredient = ingredientRepository.findById("dasd").orElse(null);

		// Assert that the retrieved ingredient is not null
		assertNotNull(savedIngredient);
		assertEquals("Shrimp",savedIngredient.getName());

		System.out.println(ingredientRepository.findAll());
		orderRepository.delete(tacoOrder);
		System.out.println("-------------------------");
		System.out.println(ingredientRepository.findAll());
		Ingredient savedIngredientSecondFetch = ingredientRepository.findById("dasd").orElse(null);

		/*assertNotNull(savedIngredientSecondFetch);
		assertEquals("Shrimp",savedIngredientSecondFetch.getName());*/

	}

}
