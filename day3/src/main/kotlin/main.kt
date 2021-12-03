import java.io.File

fun parseFileAndGetInput(): List<String> {
    val filepath = "/Users/jorgenstamnes/Documents/own/AdventOfCode2021/day3/src/main/kotlin/input.txt"
    return File(filepath).readLines(Charsets.UTF_8).toList()
}

fun first() {
}

fun second() {
}

fun main() {
    first()
    second()
}
