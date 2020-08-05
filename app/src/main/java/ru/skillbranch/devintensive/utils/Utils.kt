package ru.skillbranch.devintensive.utils


object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String?>? = fullName?.trimStart()?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        val transformedFirstName = if (firstName.isNullOrBlank()) null else firstName
        val transformedLastName = if (lastName.isNullOrBlank()) null else lastName

        return transformedFirstName to transformedLastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        var result = ""

        val dictionary: Map<String, String> =
            mapOf(
                "а" to "a",
                "б" to "b",
                "в" to "v",
                "г" to "g",
                "д" to "d",
                "е" to "e",
                "ё" to "e",
                "ж" to "zh",
                "з" to "z",
                "и" to "i",
                "й" to "i",
                "к" to "k",
                "л" to "l",
                "м" to "m",
                "н" to "n",
                "о" to "o",
                "п" to "p",
                "р" to "r",
                "с" to "s",
                "т" to "t",
                "у" to "u",
                "ф" to "f",
                "х" to "h",
                "ц" to "c",
                "ч" to "ch",
                "ш" to "sh",
                "щ" to "sh'",
                "ъ" to "",
                "ы" to "i",
                "ь" to "",
                "э" to "e",
                "ю" to "yu",
                "я" to "ya",
                " " to divider
            )

        for (i in payload) {
            val symbol = dictionary.getValue(i.toLowerCase().toString())

            result += if (i.isUpperCase()) {
                symbol.capitalize()
            } else symbol
        }

        return result
    }

    fun toInitials(firstName: String?, lastName: String?): String {
        val firstInitial: String? = firstName?.firstOrNull()?.toUpperCase().toString()
        val lastInitial: String? = if (lastName.isNullOrBlank()) "" else lastName.first().toUpperCase().toString()
        return "$firstInitial$lastInitial"
    }
}