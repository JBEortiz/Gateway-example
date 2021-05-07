package com.app.mapper;

import java.util.List;

public interface GenericMapper<E,D> {
	
	D entityToDto(E entity);

	E dtoToEntity(D dto);

	List<D> dtosToEntitys(List<E> juegos);


}
