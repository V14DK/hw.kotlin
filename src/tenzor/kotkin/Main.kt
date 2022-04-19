package tenzor.kotkin

fun main() {

    val card1 = Card("Clubs", 12)
    val card2 = Card("Clubs", 11)
    println(card1.compareTo(card2))
    println(card1.hashCode())
    println(card2.hashCode())


    val folder = Folder("first")
    val folder1 = Folder(folder, "a")
    val folder2 = Folder(folder, "b")

    val file = File("text", "txt")
    println(file)

    folder.addChild(file)
    println(file)

    val newFile = File(folder1, "table", "xlsx")
    folder1.addChild(file)
    println(file)
    println(newFile)

    folder2.addChild(newFile)
    println(folder.getChildren())
    println(folder1.getChildren())
    println(folder2.getChildren())
}