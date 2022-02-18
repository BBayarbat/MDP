import java.lang.StringBuilder

fun main() {
    println("Hello World")

    var inputNumber: Int = 0
    inputNumber = readLine()?.toInt() ?: 0;
    print("Write a number : ")
    printLastAndFirstDigit(inputNumber);

    val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7)

    printOddSquare(numbers);

    calculateWeight();
}

fun printLastAndFirstDigit(number: Int) {
    var absNumber = Math.abs(number);

    var firstDigit = firstDigit(absNumber)
    println("First digit: $firstDigit")

    var lastDigit = absNumber % 10;
    println("Last digit: $lastDigit")
}

fun firstDigit(x: Int): Int {
    var x = x
    while (x > 9) {
        x /= 10
    }
    return x
}

fun printOddSquare(arrayInt: Array<Int>) {
    var sumOfSquares = 0
    var currentSquare = 0
    var sb = StringBuilder()

    for (i in 0..arrayInt.size step 2) {
        currentSquare = arrayInt[i] * arrayInt[i]
        if (sb.length > 0) {
            sb.append(" + " + currentSquare)
        } else {
            sb.append(currentSquare)
        }

        sumOfSquares += currentSquare
    }

    if (sb.length > 0) {
        sb.append(" = " + sumOfSquares)
    }

    println(sb.toString())
}

fun calculateWeight() {

    var calculatedWeight: Double = 0.0

    do {
        print("Enter weight : ")
        var weight = readLine()?.toDouble();

        print("Choose the planet 1. Venus 2. Mars 3. Jupiter 4. Saturn 5. Uranus :");
        var planet = readLine()?.toInt();

        if (weight != null && planet != null) {
            when (planet) {
                1 -> calculatedWeight = weight.times(0.78)
                2 -> calculatedWeight = weight.times(0.39)
                3 -> calculatedWeight = weight.times(2.65)
                4 -> calculatedWeight = weight.times(1.17)
                5 -> calculatedWeight = weight.times(1.05)
                else -> {
                    calculatedWeight = 0.0
                    println("Wrong planet!")
                }
            }
            if(calculatedWeight > 0.0)
                break;
        } else {
            println("Please enter valid weight and planet!")
        }

    } while (true)

    println("Your weight is " + calculatedWeight)
}