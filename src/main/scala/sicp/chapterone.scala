package sicp
// Building Abstractions with Procedures

object One {
  def main(args: Array[String]){
    println("Square (2): " + square(2))
    println("Sum of squares (3,4): " + sumOfSquares(3,4))
    println("f (5): " + f(5))
    println("abs(5): " + abs(5))
    println("abs(0): " + abs(0))
    println("abs(-5): " + abs(-5))
    println("2 >= 3: " + >=(4,3))

    println("asd: " + sqrt(9))

    println("Exercises")
    println("1.3: " + onePointThree(2,3,4))
  }

  // def <name>(<formal parramaters>): <return type> = <body>

  // Compound Procedures
  def square(i: Int): Int = i * i  
  def sumOfSquares(a: Int, b: Int): Int = square(a) + square(b)  
  def f(i: Int): Int = sumOfSquares(i+1,i*2)

  // Conditional Expressions and Predicates
  def abss(i: Int): Int =  if (i >= 0) i else -i

  // Pattern matching
  def abs(i: Int): Int = i match {
    case _ if i >= 0 => i
    case _ if i < 0 => -i
  }  

  def >=(a: Int, b: Int): Boolean = a >= b

  // ---------------- Exercises ----------------

  // 1.3 - Define a Procedure that takes three numbers as arguments and returns
  //       the sum  of the squares of the two larger numbers
  def onePointThree(a: Int, b: Int, c: Int): Int =  {
    var (x,y) = if (a > b && b > c) (a,b)
                  else if (a > b && c > b) (a,c)
                  else (b,c)
    sumOfSquares(x,y)    
  }

  // Square Roots by Newtons Method
  def average(x: Int, y: Int) = (x + y) / 2
  def improve(guess: Int, x: Int) = average(guess,(x / guess))
  def goodEnough(guess: Int, x: Int): Boolean = abs(square(guess) - x) < 0.001
  def sqrtIter(guess: Int, x: Int): Int = {
    if (goodEnough(guess,x)) guess
    else sqrtIter(improve(guess,x),x)
  }
  def sqrt(x: Int) = sqrtIter(1, x)

  // 1.x - x
  def x() = {
    error("")
  }

}