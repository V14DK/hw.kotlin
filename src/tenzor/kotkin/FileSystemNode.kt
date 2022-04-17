package tenzor.kotkin

interface FileSystemNode {
    public var name: String

    public var parent: Folder?

    public var path: String?
}