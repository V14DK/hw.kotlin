package tenzor.kotkin

class Folder(override var parent: Folder?, override var name: String): AbstractFileSystem(parent, name) {

    private var children: ArrayList<AbstractFileSystem> = ArrayList()

    init { parent?.addChild(this)}

    internal constructor(name: String): this(null, name)

    fun addChild(child: AbstractFileSystem) {
        if (child.parent != null)
            child.parent!!.removeChild(child)
        children.add(child)
        child.parent = this
    }

    fun removeChild(child: AbstractFileSystem) { children.remove(child) }

    fun getChildren(): ArrayList<AbstractFileSystem> { return this.children }

    override fun toString(): String { return (this.parent?.toString() ?: "main") + '/' + this.name}
}