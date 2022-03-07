package com.example.hw_15_1

object Citys {
    val city_1 = City("Tehran")
    val city_2 = City("Toronto")
    val city_3 = City("Qazvin")
    val city_4 = City("Esfahan")
    val city_5 = City("NewYork")
    val city_6 = City("Kerman")
    val city_7 = City("Kilan")
    val city_8 = City("Ahavaz")
    val city_9 = City("Chabahar")
    val city_10 = City("Kabul")
}
fun getCityName(element: Citys = Citys): List<String> {
  val listOfCitys:List<String> = listOf(element.city_1.name, element.city_2.name, element.city_3.name, element.city_4.name, element.city_5.name, element.city_6.name, element.city_7.name, element.city_8.name, element.city_9.name, element.city_10.name)
return listOfCitys
}