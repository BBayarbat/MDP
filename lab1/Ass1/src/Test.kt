fun main(){
    var bookOne = Book ("R","R", 5.6)
    var ebookOne = EBook("eR", "R", 3.6, "docx")

    println(bookOne)
    println(ebookOne)

    bookOne.title = "Lord of the rings"
    ebookOne.fileType = "pdf"

    println(bookOne)
    println(ebookOne)
}