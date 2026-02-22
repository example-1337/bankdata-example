//fake for idea's inspection to work :)
package org.intellij.lang.annotations

annotation class Language(
    val value: String,
    val prefix: String = "",
    val suffix: String = ""
)