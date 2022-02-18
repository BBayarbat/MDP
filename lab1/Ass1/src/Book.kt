open class Book(title: String, author: String, price: Double) {
    var title:String = ""
    var author:String = ""
    var price:Double = 0.0

    init {
        this.title = title
        this.author = author
        this.price = price
    }

    open fun read(){
        println("Reading Paper book")
    }

    override
    fun toString():String {
        return "title : $title  author : $author  price : $price"
    }
}