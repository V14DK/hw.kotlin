package tenzor.kotkin

class File: AbstractFileSystem {
    override var name: String
    override var parent: Folder? = null
    override var path: String?
    private var extention: String

    internal constructor(name: String, extention: String) {
        this.name = name
        this.extention = extention
        this.path = "main/" + this.toString()
    }

    internal constructor(parent: Folder, name: String, extention: String): this(name, extention) {
        this.parent = parent
        parent.addChild(this)
        this.name = name
        this.extention = extention
        this.path = (this.parent as Folder).path + '/' + this.toString()
    }

    public fun setExtention(extention: String) { this.extention = extention}

    public fun getExtention(): String {return this.extention }

    override fun toString(): String {
        return this.name + '.' + this.extention
    }

}