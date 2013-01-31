package sicp
import One._

object Exercises {
  def main(args: Array[String]){
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

  // 1.16 - Design a iterative exponentiation process that uses successive
  //        squaring and uses a logarithmic number of steps
  //        NB: (b ^ n/2)^2 = (b^2)^n/2
  def expt(base: Int, exponent: Int)= {
    def x(base: Int, exponent: Int, state: Int): Int = {
      error("")
    }
    x(base,exponent,1)
  }

  // 1.17 - Design a multiplications procedure analogous to fast-expt that
  //        uses a logarithmic number of steps
  //        addition(), double(), halve()
  def *(a: Int, b: Int)= {
    error("")
    /*
      a * b = a * 2 * halve(b)
      a * b = a * 0.5 * double(b)

    */

  }

}