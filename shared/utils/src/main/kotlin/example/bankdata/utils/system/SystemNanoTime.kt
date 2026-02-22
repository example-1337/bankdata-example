package example.bankdata.utils.system

import kotlin.time.*

@JvmInline
value class SystemNanoTime(val time: Long) {

    fun isAfter(other: SystemNanoTime): Boolean {
        return this.time > other.time
    }

    operator fun plus(duration: Duration): SystemNanoTime {
        return SystemNanoTime(time + duration.inWholeNanoseconds)
    }

    companion object {
        fun now() = SystemNanoTime(System.nanoTime())
    }
}