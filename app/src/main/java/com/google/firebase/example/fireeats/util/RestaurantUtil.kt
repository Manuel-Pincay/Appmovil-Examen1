package com.google.firebase.example.fireeats.util

import android.content.Context
import com.google.firebase.example.fireeats.R
import com.google.firebase.example.fireeats.model.Restaurant

import java.util.Arrays
import java.util.Random

/**
 * Utilities for Restaurants.
 */
object RestaurantUtil {

    private const val FOTO = "https://www.qhubobogota.com/wp-content/uploads/2022/08/balon2.jpg"


    private val fotos = arrayOf(
        "https://www.qhubobogota.com/wp-content/uploads/2022/08/balon2.jpg",
       "https://johancruyffinstitute.com/wp-content/uploads/2017/12/liga-femenina-holandesa-com.jpg",
        "https://www.metroecuador.com.ec/resizer/lGjZ9bGSh9ou3ndLsFZdR0Xfc8M=/800x0/filters:format(jpg):quality(70)/cloudfront-us-east-1.images.arcpublishing.com/metroworldnews/DL4BHR2RUREH7EG4QQ7RICBPRY.jpg",

"https://e.rpp-noticias.io/normal/2022/11/16/000500_1346189.jpg"    )

    private val NAME_FIRST_WORDS = arrayOf(
        "Toros", "Manta", "Barca", "Madrid", "Ballenita", "Costa", "World", "Google", "The Best")

    private val NAME_SECOND_WORDS = arrayOf(
        "FC", "SC", "Sport", "Juniors", "Sur", "Norte", "Soccer")


    /**
     * Create a random Restaurant POJO.
     */
    fun getRandom(context: Context): Restaurant {
        val restaurant = Restaurant()
        val random = Random()

        // Cities (first elemnt is 'Any')
        var cities = context.resources.getStringArray(R.array.cities)
        cities = Arrays.copyOfRange(cities, 1, cities.size)


        val prices = intArrayOf(1, 2, 3)

        restaurant.name = getRandomName(random)
        restaurant.city = getRandomString(cities,random)
        restaurant.photo = getRandomFotos(random)
        restaurant.categoria = getRandomInt(prices, random)
        restaurant.numRatings = random.nextInt(20)

        // Note: average rating intentionally not set

        return restaurant
    }

    private fun getRandomFotos(random: Random): String {
        return (getRandomString(fotos, random))
    }



    /**
     * Get categoria represented as dollar signs.
     */
    fun getPriceString(restaurant: Restaurant): String {
        return getPriceString(restaurant.categoria)
    }


    /**
     * Get categoria represented as dollar signs.
     */
    fun getPriceString(priceInt: Int): String {
        when (priceInt) {
            1 -> return "SUB 18"
            2 -> return "SUB 20"
            3 -> return "PROFESIONAL"
            else -> return "PROFESIONAL"
        }
    }

    private fun getRandomName(random: Random): String {
        return (getRandomString(NAME_FIRST_WORDS, random) + " " +
                getRandomString(NAME_SECOND_WORDS, random))
    }

    private fun getRandomString(array: Array<String>, random: Random): String {
        val ind = random.nextInt(array.size)
        return array[ind]
    }

    private fun getRandomInt(array: IntArray, random: Random): Int {
        val ind = random.nextInt(array.size)
        return array[ind]
    }
}
