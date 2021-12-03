import java.io.File

fun parseFileAndGetInput(): List<Int> {
    val filepath = "/Users/jorgenstamnes/Documents/own/AdventOfCode2021/day1/src/main/resources/input.txt"
    return File(filepath).readLines(Charsets.UTF_8).map { s -> s.toInt() }
}

fun parseFileAndGetInput2(): List<Int> {
    val filepath = "/Users/jorgenstamnes/Documents/own/AdventOfCode2021/day1/src/main/resources/input2.txt"
    return File(filepath).readLines(Charsets.UTF_8).map { s -> s.toInt() }
}

fun solution1() {
    val measurements = parseFileAndGetInput()

    var previousMeasurement: Int? = null
    var count = 0

    measurements.forEach {
        if (previousMeasurement == null) {
            previousMeasurement = it
        } else {
            if (it > previousMeasurement!!) {
                count += 1
                previousMeasurement = it
            } else {
                previousMeasurement = it
            }
        }
    }

    println("Count: $count")
}

fun slidingWindowSize(): Int = 3

fun solution2() {
    val measurements = parseFileAndGetInput()

    var previousThreeMeasurement: Int? = null
    var count = 0
    for (i in 0 until measurements.size - 2) {

        var currentMeasure = measurements.slice(i..i + 2).sum()
        if (previousThreeMeasurement == null) {
            previousThreeMeasurement = currentMeasure
        } else {
            if (currentMeasure > previousThreeMeasurement!!) {
                count += 1
                previousThreeMeasurement = currentMeasure
            } else {
                previousThreeMeasurement = currentMeasure
            }
        }
    }

    println("Count: $count")
}

fun main() {
    solution1()
    solution2()
}
