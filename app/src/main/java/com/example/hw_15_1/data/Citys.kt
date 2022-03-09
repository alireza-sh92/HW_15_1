package com.example.hw_15_1.data

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
fun getCityName(element: Citys = Citys): List<City> {
  val listOfCitys:List<City> = listOf(element.city_1, element.city_2, element.city_3, element.city_4, element.city_5, element.city_6, element.city_7, element.city_8, element.city_9, element.city_10)
return listOfCitys
}