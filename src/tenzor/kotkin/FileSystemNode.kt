package tenzor.kotkin

interface FileSystemNode {

    var name: String

    var parent: Folder?

    override fun toString(): String
}