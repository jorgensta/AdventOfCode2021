import java.io.File

fun parseFileAndGetInput(): List<String> {
    val filepath = "/Users/jorgenstamnes/Documents/own/AdventOfCode2021/day2/src/main/kotlin/input1.txt"
    return File(filepath).readLines(Charsets.UTF_8).toList()
}

fun first() {
    val inputs = parseFileAndGetInput()

    val FORWARD = "forward"
    val DOWN = "down"
    val UP = "up"

    var horizontalPos = 0
    var depthPos = 0
    var aim = 0

    inputs.forEach { line ->
        val actionAndValue = line.split(" ")
        val action = actionAndValue[0]
        val value = actionAndValue[1]

        if (action == FORWARD) {
            horizontalPos += value.toInt()
        }

        if (action == DOWN) {
            depthPos += value.toInt()
        }

        if (action == UP) {
            depthPos -= value.toInt()
        }
    }
    println("Solution: ${depthPos * horizontalPos}")
}

fun second() {
    val inputs = parseFileAndGetInput()

    /*
    forward X does two things:
        It increases your horizontal position by X units.
        It increases your depth by your aim multiplied by X.
     */
    val FORWARD = "forward"
    val DOWN = "down" // down X increases your aim by X units.
    val UP = "up" // up X decreases your aim by X units.

    var horizontalPos = 0
    var depthPos = 0
    var aim = 0

    inputs.forEach { line ->
        val actionAndValue = line.split(" ")
        val action = actionAndValue[0]
        val value = actionAndValue[1]

        if (action == FORWARD) {
            horizontalPos += value.toInt()
            depthPos += aim * value.toInt()
        }

        if (action == DOWN) {
            aim += value.toInt()
        }

        if (action == UP) {
            aim -= value.toInt()
        }
    }
    println("Solution: ${depthPos * horizontalPos}")
}

fun main(args: Array<String>) {
    first()
    second()
}
