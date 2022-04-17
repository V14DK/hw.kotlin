package tenzor.kotkin

class Folder: AbstractFileSystem {
    private var children: ArrayList<AbstractFileSystem> = ArrayList()

    override var name: String
    override var parent: Folder? = null
    override var path: String?

    internal constructor(name: String) {
        this.name = name
        this.path = "main/" + this.name
    }

    internal constructor(parent: Folder, name: String) {
        this.name = name
        this.parent = parent
        parent.addChild(this)
        this.path = (this.parent as Folder).path + "/" + this.name
    }

    fun addChild(child: FileSystemNode) {
        if (child.parent != null)
            child.parent!!.removeChild(child)
        children.add(child as AbstractFileSystem)
        child.parent = this
        child.path = child.parent!!.path + '/' + child.toString()
    }

    fun removeChild(child: FileSystemNode) {
        children.remove(child)
    }

    fun getChildren(): ArrayList<AbstractFileSystem> { return this.children }
}