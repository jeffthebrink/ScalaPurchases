import java.io.File
import java.io.FileWriter
import scala.collection.mutable
import scala.io.Source

case class Purchase(customerId: String, date: String, creditCard: String, cvv: String, category: String) {
  override def toString: String = s"Customer Id: $customerId, Date: $date, Credit Card: $creditCard, CVV: $cvv, Category: $category"
}

case class choiceFurniture(customerId: String, date: String) {
  override def toString: String = s"Customer: $customerId, Date: $date"
}

object FileIO {

  val purchases = mutable.MutableList[(String, String, String, String, String)]()
  Source
    .fromFile("purchases.csv")
    .getLines().drop(1)
    .foreach(line => {
      val Array(customerId, date, creditCard, cvv, category) = line.split(",").map(_.trim)
      purchases += Tuple5(customerId, date, creditCard, cvv, category)
    })

  def prompt(s: String) = {
    println(s);
    io.StdIn.readLine()
  }

  case object choiceFurniture {
    def opt() = {
      val f = new File("filtered_purchases.prn")
      val fw = new FileWriter(f)
      val fullList = purchases
        .filter(_._5 == "Furniture")
        .map(p => s"Customer: ${p._1} Date: ${p._2}\n")
        .mkString
      fw.write(fullList);
      fw.close
    }
  }

  case object choiceAlcohol {
    def opt() = {
      val f = new File("filtered_purchases.prn")
      val fw = new FileWriter(f)
      val fullList = purchases
        .filter(_._5 == "Alcohol")
        .map(p => s"Customer: ${p._1} Date: ${p._2}\n")
        .mkString
      fw.write(fullList);
      fw.close
    }
  }

  case object choiceToiletries {
    def opt() = {
      val f = new File("filtered_purchases.prn")
      val fw = new FileWriter(f)
      val fullList = purchases
        .filter(_._5 == "Toiletries")
        .map(p => s"Customer: ${p._1} Date: ${p._2}\n")
        .mkString
      fw.write(fullList);
      fw.close
    }
  }

  case object choiceShoes {
    def opt() = {
      val f = new File("filtered_purchases.prn")
      val fw = new FileWriter(f)
      val fullList = purchases
        .filter(_._5 == "Shoes")
        .map(p => s"Customer: ${p._1} Date: ${p._2}\n")
        .mkString
      fw.write(fullList);
      fw.close
    }
  }

  case object choiceFood {
    def opt() = {
      val f = new File("filtered_purchases.prn")
      val fw = new FileWriter(f)
      val fullList = purchases
        .filter(_._5 == "Food")
        .map(p => s"Customer: ${p._1} Date: ${p._2}\n")
        .mkString
      fw.write(fullList);
      fw.close
    }
  }

  case object choiceJewelry {
    def opt() = {
      val f = new File("filtered_purchases.prn")
      val fw = new FileWriter(f)
      val fullList = purchases
        .filter(_._5 == "Jewelry")
        .map(p => s"Customer: ${p._1} Date: ${p._2}\n")
        .mkString
      fw.write(fullList);
      fw.close
    }
  }

  def main(args: Array[String]): Unit = {
    println()
    println("Scala I/O running...")
    println()
    println("Enter a category name to filter the file list.")
    println()
    println("Available options are: \n1. Furniture \n2. Alcohol \n3. Toiletries \n4. Shoes \n5. Food \n6. Jewelry")

    var resp = scala.io.StdIn.readLine()


    resp match {
      case "1" => choiceFurniture.opt()
      case "2" => choiceAlcohol.opt()
      case "3" => choiceToiletries.opt()
      case "4" => choiceShoes.opt()
      case "5" => choiceFood.opt()
      case "6" => choiceJewelry.opt()
    }
    println("Program execution complete. Your filtered list results are available in the file, filtered_purchases.prn")
  }
}