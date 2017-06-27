package org.mb.mapit;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class Mapit<T> implements MappableTo<T> {
	
	private Map<Predicate<Object>, Function<Object, T>> predicatesByMapper = new HashMap<>();
	private Object object;

	Mapit(Object object) {
		this.object = object;
	}

	public static <T> MappableTo<T> with(Object object) {
		return new Mapit<T>(object);
	}

	@Override
	public <D> ThenMap<D, T> when(Predicate<D> predicate) {
		return new ThenMap<D, T>() {

			@SuppressWarnings("unchecked")
			@Override
			public MappableTo<T> then(Function<D, T> function) {
				predicatesByMapper.put((Predicate<Object>) predicate, (Function<Object, T>) function);
				return Mapit.this;
			}
		};
	}

	@Override
	public T map() {
		return predicatesByMapper.entrySet().stream()
				.filter(e -> e.getKey().test(object))
				.findFirst()
				.map(e -> e.getValue().apply(object))
				.orElse(null);
	}

}
