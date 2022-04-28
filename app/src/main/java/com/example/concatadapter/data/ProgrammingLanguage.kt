package com.example.concatadapter.data

import androidx.annotation.DrawableRes
import com.example.concatadapter.R

data class ProgrammingLanguage(
    val name: String?,
    val paradigm: String?,
    @DrawableRes
    val logo: Int
)

val programmingLanguage = listOf(
    ProgrammingLanguage("Kotlin", "Oriendação a Objeto", R.drawable.kotlin),
    ProgrammingLanguage("Php", "Oriendação a Objeto", R.drawable.php),
    ProgrammingLanguage("Go", "Oriendação a Objeto", R.drawable.kotlin),
    ProgrammingLanguage("Php", "Oriendação a Objeto", R.drawable.kotlin),
    ProgrammingLanguage("Koin", "Oriendação a Objeto", R.drawable.php),
    ProgrammingLanguage("Java", "Oriendação a Objeto", R.drawable.kotlin)
)