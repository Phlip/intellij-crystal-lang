package org.crystal.intellij.util

import java.nio.file.InvalidPathException
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.exists
import kotlin.io.path.isRegularFile

private val emptyPath: Path = Path.of("")

fun String.toPathOrNull() = try {
    Paths.get(this)
} catch (e: InvalidPathException) {
    null
}

fun String.toPathOrEmpty() = toPathOrNull() ?: emptyPath

val Path.isValidFile: Boolean
    get() = exists() && isRegularFile()