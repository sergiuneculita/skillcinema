package com.example.skillcinema.data.database.films

import androidx.room.TypeConverter
import com.example.skillcinema.data.films.ItemDto
import com.google.gson.Gson

class ConverterFilmsInJson {
    companion object {
        @JvmStatic
        @TypeConverter
        fun fromItemList(itemList: List<ItemDto>): String =
            Gson().toJson(itemList)

        @JvmStatic
        @TypeConverter
        fun toItemList(itemListString: String): List<ItemDto> =
            Gson().fromJson(itemListString, Array<ItemDto>::class.java).toList()
    }
}
