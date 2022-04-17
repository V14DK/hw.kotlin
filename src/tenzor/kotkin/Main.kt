package tenzor.kotkin

fun main() {
    var card1 = Card("Clubs", 11)
    var card2 = Card("Clubs", 12)

    var folder = Folder("first")
    var folder1 = Folder(folder, "a")
    var folder2 = Folder(folder, "b")

    var file = File("text", "txt")
    println(file.path)

    folder.addChild(file)
    println(file.path)

    var newFile = File(folder1, "table", "xlsx")
    folder1.addChild(file)
    println(file.path)
    println(newFile.path)

    folder2.addChild(newFile)
    println(folder.getChildren())
    println(folder1.getChildren())
    println(folder2.getChildren())
}