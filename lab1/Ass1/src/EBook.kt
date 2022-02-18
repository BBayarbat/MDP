class EBook(title:String, author:String, price:Double, fileType:String): Book(title, author, price) {
var fileType: String = ""
    init {
        this.fileType = fileType
    }

    override
    fun read(){
        println("Read from Electronic Device")
    }

    override
    fun toString():String {
        return "title : $title  author : $author  price : $price  fileType : $fileType"
    }
}