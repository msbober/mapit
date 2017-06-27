package org.mb.mapit;

import java.util.function.Function;

public interface ThenMap<D, O> {

	MappableTo<O> then(Function<D, O> function);

}
