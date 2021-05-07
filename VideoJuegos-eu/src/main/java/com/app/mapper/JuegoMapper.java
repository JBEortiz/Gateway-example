package com.app.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.app.dto.JuegoDto;
import com.app.model.Juego;

@Mapper
public interface JuegoMapper extends GenericMapper<Juego, JuegoDto>{
	
	JuegoMapper INSTANCE = Mappers.getMapper(JuegoMapper.class);
	
	@Override
	@Mapping(source = "juego.titulo", target = "titulo")
	@Mapping(source = "juego.name", target = "nombre")
	@Mapping(source = "juego.cagetory", target = "categoria")
	@Mapping(source = "juego.price", target = "precio")
	JuegoDto entityToDto(Juego juego);
	
	@Override
	@InheritInverseConfiguration
	Juego dtoToEntity(JuegoDto juegoDto);

	@Override
	List<JuegoDto> dtosToEntitys(List<Juego> juegos);
}
