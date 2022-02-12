package com.example.diceroll

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DiceTest {
    private var dice: Dice? = null

    @Before
    public fun initialize() {
        dice = Dice(6)
    }


    @Test
    fun good_random_range() {
        val number = dice?.roll()
        assertTrue((number in 1..6))
    }

    @Test
    fun no_zero_in_random_range() {
        val number = dice?.roll()
        assertFalse(number == 0)

    }
}