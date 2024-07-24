package com.example.likeminds.model

data class Model(
    val index: Int,
    val fullName: String,
    val nickName: String,
    val hogwartsHouse: String,
    val interpretedBy: String,
    val children: List<String>,
    val image: String,
    val birthDate: String,
)
