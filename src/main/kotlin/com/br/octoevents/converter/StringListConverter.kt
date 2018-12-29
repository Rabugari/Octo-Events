package com.br.octoevents.converter

import javax.persistence.AttributeConverter

/**
 * Conversor para tratamento de lista de strings
 * @author douglas.takara
 */
class StringListConverter : AttributeConverter<List<String>, String>{
    override fun convertToDatabaseColumn(attribute: List<String>?): String = attribute!!.joinToString()

    override fun convertToEntityAttribute(dbData: String?): List<String> = dbData!!.split(",").toList()
}