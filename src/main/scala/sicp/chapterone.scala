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
    println("sqrt(square(1000): " + sqrt(square(1000)))
    println("sqrtz(square(1000)): " + sqrtz(square(1000)))
    println("factorialR: " + factorialR(6))
    println("factorialI: " + factorialI(6))
    println("fib(9): " + fib(9))
    println("fibb(9): " + fibb(9))

    println(" ---- Exercises ---- ")
    println("1.3 : " + onePointThree(2,3,4))
    println("1.10 : " + A(0,0))
    println("1.10 : " + A(0,1))
    println("1.10 : " + A(0,2))
    println("1.10 : " + A(0,3))
    println("1.10 : " + A(0,4))
    println("1.11 (R): " + fR(4))
    println("1.11 (I): " + fI(4))
    println("1.12 :  " + pascal(3,5))
    println("1.12 : " + pascalrow(5))
  }

  // def <name>(<formal parramaters>): <return type> = <body>

  // Compound Procedures
  def square(i: Int): Int = i * i  
  def cube(i: Int): Int = i * i * i
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
  def average(x: Int, y: Int) = (x + y) / 2

  // Procedures as Black-box Abstractions
  // --

  // Square Roots by Newtons Method
  def sqrt(x: Int) = sqrtIter(1, x)
  def sqrtIter(guess: Int, x: Int): Int = {
    if (goodEnough(guess,x)) guess
    else sqrtIter(improveGuess(guess,x),x)
  }
  def goodEnough(guess: Int, x: Int): Boolean = abs(square(guess) - x) < 0.001
  def improveGuess(guess: Int, x: Int) = average(guess,(x / guess))
  
  // Block Structure - lexical scoping  
  def sqrtz(x: Int) = {
    def goodEnoughz(guess: Int): Boolean = abs(square(guess) - x) < 0.001
    def improveGuessz(guess: Int) = average(guess,(x / guess))
    def sqrtIterz(guess: Int): Int = {
      if (goodEnoughz(guess)) guess
      else sqrtIterz(improveGuessz(guess))
    }
    sqrtIter(1, x)
  }

  // Linear Recursion and Iteration
  def factorialR(x: Int): Int =                     // factorialR - recursive process
    if (x == 1) 1 else (x * factorialR(x - 1))

  def factorialI(x: Int): Int = {                   // factorialI - iterative process
    def iter(p: Int, c: Int): Int =                 // iter - recursive procedure
      if (c > x) p else iter(p * c, c + 1)
    iter(1,1)
  }

  // Tree recursion
  def fib(i: Int): Int = i match {
    case 0 => 0
    case 1 => 1
    case _ => (fib(i-1) + fib(i-2))
  }

  // iterative process of fibonacci
  def fibb(i: Int) = {
    def fibIter(a: Int, b: Int, count: Int): Int = {
      if (count == 0) b
      else fibIter((a + b),a,(count - 1))
    }
    fibIter(1,0,i)
  }

  // ------------------------------ Exercises ------------------------------

  // 1.3 - Define a Procedure that takes three numbers as arguments and returns
  //       the sum  of the squares of the two larger numbers
  def onePointThree(a: Int, b: Int, c: Int): Int =  {
    var (x,y) = if (a > b && b > c) (a,b)
                  else if (a > b && c > b) (a,c)
                  else (b,c)
    sumOfSquares(x,y)    
  }

  // 1.10 - Ackermann's Function
  def A(x: Int, y: Int): Int = (x,y) match {
    case (0,_) => (y + 1)
    case (a,0) if (a > 0) => A((x-1),1)
    case (a,b) if ((a > 0) && (b > 0)) => A((x-1),A(x,(y-1)))
  }

  // 1.11 - Write procedures that computes f as an recursive / iterative process
  //        f(n) = n                               n < 3
  //        f(n) = f(n-1) + 2f(n-2) + 3f(n-3)      n >= 3

  // recrusive
  def fR(n: Int): Int = {
    if (n < 3) n
    else ( f(n-1) + (2 * f(n-2)) + (3 * f(n-3)) )
  }

  // iterative
  def fI(n: Int): Int = {
    def iter(count: Int, product: Int): Int = {
      if (count > 3) product
      else iter((count + 1), product + (count * f(n-count)))
    }    
    if (n < 3) n else iter(1,0)
  }

  // 1.12 - Write a procedure that computes elements of a Pascal's triangle by
  //        means of a recursive process

  def pascal(column: Int, row: Int): Int = {
    if (column == 1 || column == row) 1
    else pascal(column - 1, row - 1) + pascal(column, row - 1)
  }

  def pascalrow(i: Int): String = {
    var r = "row " + i + ": "
    for (x <- 1 to i) {
      r = r + pascal(x,i) + " "
    }
    r
  }

  //
}