package com.br.octoevents.converter

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class StringListConverterTest {

    val converter:StringListConverter = StringListConverter()


    @Test
    fun convertStringToList(){
        val stringValue:String = "1,2,3,4,cinco"
        val expectedArrayList = listOf<String>("1", "2", "3", "4", "cinco")
        val arrayList = converter.convertToEntityAttribute(stringValue)
        Assert.assertEquals(arrayList, expectedArrayList)
    }

    @Test
    fun convertListToString(){
        val expectedStringValue:String = "1,2,3,4,cinco"
        val arrayList = listOf<String>("1", "2", "3", "4", "cinco")
        val valueString= converter.convertToDatabaseColumn(arrayList)
        Assert.assertEquals(expectedStringValue, valueString.replace(" ", ""))
    }

}