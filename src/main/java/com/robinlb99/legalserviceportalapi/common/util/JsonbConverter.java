package com.robinlb99.legalserviceportalapi.common.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;


/**
 * Convertidor de atributos de JPA para convertir un Map a una cadena JSON y viceversa.
 * Se utiliza para almacenar datos de tipo Map<String, Object> en una columna de
 * base de datos de tipo JSONB.
 */
@Convert
@Component
public class JsonbConverter implements AttributeConverter<Map<String, Object>, String> {

	private final ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * Convierte un Map a su representación en cadena JSON para ser almacenado en la base de datos.
	 *
	 * @param attribute El Map a ser convertido.
	 * @return La representación en cadena JSON del Map.
	 * @throws IllegalArgumentException Si ocurre un error al serializar el Map a JSON.
	 */
	@Override
	public String convertToDatabaseColumn(Map<String, Object> attribute) {
		try {
			return objectMapper.writeValueAsString(attribute);
		} catch (Exception e) {
			throw new IllegalArgumentException("Error al serializar Map a JSON", e);
		}
	}

	/**
	 * Convierte una cadena JSON de la base de datos a un Map.
	 *
	 * @param dbData La cadena JSON de la base de datos a ser convertida.
	 * @return El Map resultante de la deserialización de la cadena JSON.
	 * @throws IllegalArgumentException Si ocurre un error al deserializar el JSON a Map.
	 */
	@Override
	public Map<String, Object> convertToEntityAttribute(String dbData) {
		try {
			return objectMapper.readValue(dbData, new TypeReference<Map<String, Object>>() {
			});
		} catch (Exception e) {
			throw new IllegalArgumentException("Error al deserializar JSON a Map", e);
		}
	}

}

