package com.github.johnnysc.practicetdd

/**
 * @author DaisyBell on 30.10.2023
 */
interface MyStack<T> {

    fun push(item: T)
    fun pop(): T

    class LIFO<T : Any?>(private val maxCount: Int) : MyStack<T> {

        private val array: Array<Any?>
        private var position: Int = 0

        init {
            if (maxCount <= 0)
                throw IllegalStateException("Max count should be positive! It is $maxCount")

            array = Array(maxCount) { null }
        }

        override fun push(item: T) {
            if (position == maxCount)
                throw IllegalStateException("Stack overflow exception, maximum is $maxCount")
            array[position] = item
            position++
        }

        override fun pop(): T {
            if (position == 0)
                throw IllegalStateException("item is empty!")

            val item = array[position - 1] as T
            array[position - 1] = null
            position--
            return item
        }

    }

    class FIFO<T : Any?>(private val maxCount: Int) : MyStack<T> {

        private val array: Array<Any?>
        private var position: Int = 0

        init {
            if (maxCount <= 0)
                throw IllegalStateException("Max count should be positive! It is $maxCount")

            array = Array(maxCount) { null }
        }

        override fun push(item: T) {
            if (position == maxCount)
                throw IllegalStateException("Stack overflow exception, maximum is $maxCount")
            array[position] = item
            position++
        }

        override fun pop(): T {
            if (position == 0)
                throw IllegalStateException("item is empty!")

            val item = array[0] as T
            val oneItem = array[position - 1]
            array[0] = oneItem
            position--
            return item
        }
    }

}