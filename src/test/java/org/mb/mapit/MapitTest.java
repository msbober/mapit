package org.mb.mapit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

public class MapitTest {

	@Test
	public void test() {
		// given
		Model model = new Model();
		model.setAge(3);
		model.setName("Aagata Buzeks");
		
		// when
		String mapped = Mapit.<String>with(model)
			.when(the(Model.class).and(m -> m.getAge() == 3).and(m -> m.getName().startsWith("Ag")))
			.then(m -> m.getName())
			.when(the(String.class))
			.then(i -> i.toString() + "aaaa")
			.map();
			;
			
			
		// then
	    assertEquals("124314324134", mapped);
	}

	public static <T> Predicate<T> the(Class<T> clazz) {
		return new Predicate<T>() {

			@Override
			public boolean test(T t) {
				return clazz.isAssignableFrom(t.getClass());
			}
		};
	}
	
	@Test
	public void test4() {
		String any = any(new Integer(1));
		
		List<String> list = new ArrayList<>();
		
		Class<? extends List> class1 = list.getClass();
		
		// then
		assertEquals("aaa", any);
	}
	
	@SuppressWarnings("unchecked")
	private <T> T any(Object o) {
		T local;
		try {
			local = (T) o;
			return local;
		} catch (ClassCastException e) {
			return null;
		}
	}
}
