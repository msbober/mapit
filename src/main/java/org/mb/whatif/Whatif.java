package org.mb.whatif;

import java.util.function.Predicate;

import org.mb.mapit.Model;

public class Whatif<T> {

	private T t;

	public Whatif(T t) {
		this.t = t;
	}

	public static <T> Whatif<T> whatif(T t) {
		return new Whatif<T>(t);
	}

	public Predicate<T> matches(Predicate<T> predicate) {
		return predicate;
	}

}
