package tenzor.kotkin

abstract class AbstractFileSystem: FileSystemNode {
    override var name: String
        get() = this.name
        set(name) {name}

    override var parent: Folder?
        get() = this.parent
        set(parent) {parent}

    override var path: String?
        get() = this.path
        set(value) {}
}