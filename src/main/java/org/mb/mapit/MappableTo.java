package org.mb.mapit;

import java.util.function.Predicate;


public interface MappableTo<T> {

	<D> ThenMap<D, T> when(Predicate<D> any);

	T map();

}
