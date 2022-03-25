package com.example.moviesdb01.utils

interface Mapper<S,T> {
    fun map(source: S): T
}