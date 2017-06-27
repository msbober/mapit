package org.mb.whatif;

import org.junit.Test;
import org.mb.mapit.Model;

public class WhatifTest {
	
	@Test
	public void test() {
		// given
		Model model = new Model();
		model.setAge(10);
		model.setName("Ala ma kota");
		
		// when
		Whatif.whatif(model).matches(m -> m.getAge() > 10).and(m -> m.getName().startsWith("Ala"));
		
		//.and(m -> m.getName().startsWith("Ala");)
		
		// then
	}

}
