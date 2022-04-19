package tenzor.kotkin

class File(override var parent: Folder?, override var name: String, var extention: String): AbstractFileSystem(parent, name) {

    init { parent?.addChild(this) }

    internal constructor(name: String, extention: String): this(null,name, extention)

    override fun toString(): String { return (this.parent?.toString() ?: "main") + '/' + this.name + '.' + this.extention }

}