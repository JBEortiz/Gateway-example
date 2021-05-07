package com.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.app.dto.JuegoDto;
import com.app.model.Juego;

@Mapper
public interface JuegoMapper extends GenericMapper<Juego, JuegoDto>{
	
	JuegoMapper INSTANCE = Mappers.getMapper(JuegoMapper.class);
	
	@Override
	JuegoDto entityToDto(Juego juego);
	
	@Override
	Juego dtoToEntity(JuegoDto juegoDto);

	@Override
	List<JuegoDto> dtosToEntitys(List<Juego> juegos);
}
