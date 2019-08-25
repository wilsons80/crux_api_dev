package br.com.crux.infra.dao;


import java.util.Objects;

import javax.persistence.AttributeConverter;

public class SimNaoConverter implements AttributeConverter<Boolean, Character> {

	@Override
	public Character convertToDatabaseColumn(Boolean attribute) {
		if (Objects.isNull(attribute)) {
			return null;
		}
		return attribute ? 'S' : 'N';
	}

	@Override
	public Boolean convertToEntityAttribute(Character dbData) {
		if (Objects.isNull(dbData)) {
			return null;
		}
		return dbData.equals('S');
	}

}
