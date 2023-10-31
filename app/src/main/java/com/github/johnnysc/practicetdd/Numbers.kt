package com.github.johnnysc.practicetdd

/**
 * @author DaisyBell on 31.10.2023
 */
interface Numbers {
    fun minimum(): Int
    fun maximum(): Int

    class Base(private val first: Int, private val second: Int) : Numbers {
        override fun minimum(): Int {
            return if (first > second) second else first
        }

        override fun maximum(): Int {
            return if (first > second) first else second
        }

    }

    class List(private val list: kotlin.collections.List<Int>) : Numbers {
        override fun minimum(): Int {
            var result = 0

            if (list.isEmpty())
                result = Int.MIN_VALUE
            else
                list.forEach {
                    if (it <= result)
                        result = it
                }

            return result
        }

        override fun maximum(): Int {
            var result = 0

            if (list.isEmpty())
                result = Int.MAX_VALUE
            else
                list.forEach {
                    if (it > result)
                        result = it
                }

            return result

        }

    }
}