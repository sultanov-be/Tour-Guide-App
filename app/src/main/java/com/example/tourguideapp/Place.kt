package com.example.tourguideapp

data class Place(
    val place: String,
    val type: String,
    val adress: String,
    val time: String,
    val imgId: Int,
    var visibility: Boolean = false,
    val extra_info: String,
    val adressTouch: String,
    val numberTouch: String,
){

}
