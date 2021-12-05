import java.io.File

fun parseFileAndGetInput(): List<String> {
    val filepath = "/Users/jorgenstamnes/Documents/own/AdventOfCode2021/day3/src/main/kotlin/input.txt"
    return File(filepath).readLines(Charsets.UTF_8).toList()
}

fun first() {
    val inputs = parseFileAndGetInput()

    val one = '1'
    val zero = '0'

    var gammaRateBits: String = ""
    var epsilonRateBits: String = ""

    val lengthOfBits = "110111100101".length

    for (i in 0 until lengthOfBits) {
        var numberOf0s = 0
        var numberOf1s = 0

        inputs.forEach { bits ->
            val bit: Char = bits[i]
            if (bit == '1') {
                numberOf1s += 1
            }
            if (bit == '0') {
                numberOf0s += 1
            }
        }

        if (numberOf1s > numberOf0s) {
            gammaRateBits += one
            epsilonRateBits += zero
        }

        if (numberOf0s > numberOf1s) {
            gammaRateBits += zero
            epsilonRateBits += one
        }

        println("1s: $numberOf1s, gammaRate: $gammaRateBits")
        println("0s: $numberOf0s")
    }

    val powerConsumption = Integer.parseInt(epsilonRateBits, 2) * Integer.parseInt(gammaRateBits, 2)
    println("Power consumption: $powerConsumption")
}

fun getBitCountAtPosition(inputs: List<String>, position: Int): Pair<Int, Int> {
    var numberOf0s = 0
    var numberOf1s = 0

    inputs.forEach { bits ->
        val bit: Char = bits[position]
        if (bit == '1') {
            numberOf1s += 1
        }
        if (bit == '0') {
            numberOf0s += 1
        }
    }

    return Pair(numberOf1s, numberOf0s)
}

fun getRecursiveAnswer(inputs: List<String>, position: Int, searchForFewest: Boolean = false): List<String> {
    if (inputs.size == 1) return inputs

    val (oneCount, zeroCount) = getBitCountAtPosition(inputs, position)

    if (oneCount == zeroCount) {
        return getRecursiveAnswer(
            inputs.filter {
                when (searchForFewest) {
                    false -> it[position] != '1'
                    else -> it[position] != '0'
                }
            },
            position + 1, searchForFewest
        )
    }

    if (oneCount > zeroCount) {
        return getRecursiveAnswer(
            inputs.filter {
                when (searchForFewest) {
                    false -> it[position] != '1'
                    else -> it[position] != '0'
                }
            },
            position + 1, searchForFewest
        )
    }

    return getRecursiveAnswer(
        inputs.filter {
            when (searchForFewest) {
                false -> it[position] != '0'
                true -> it[position] != '1'
            }
        },
        position + 1, searchForFewest
    )
}

fun second() {
    val inputs = parseFileAndGetInput()

    var oxygenList = mutableListOf<String>()
    var co2List = mutableListOf<String>()

    oxygenList.addAll(inputs)
    co2List.addAll(inputs)

    val oxygen = getRecursiveAnswer(oxygenList, 0)
    val co2 = getRecursiveAnswer(co2List, 0, true)

    println("OxygenList: $oxygen")
    println("co2List: $co2")

    println("Answer: ${Integer.parseInt(oxygen[0], 2) * Integer.parseInt(co2[0], 2)}")
}

fun main() {
    // first()
    second()
}
