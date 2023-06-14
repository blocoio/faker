package io.bloco.faker.helpers

@Suppress("UNCHECKED_CAST")
internal fun MutableMap<String, Any>.deepMerge(newMap: Map<String, Any>): Map<String, Any> {
    for ((key, value) in newMap) {
        if (value is Map<*, *> && this[key] is MutableMap<*, *>) {
            val originalChild = this[key] as MutableMap<String, Any>
            val newChild = value as Map<String, Any>
            this[key] = originalChild.deepMerge(newChild)
        } else {
            this[key] = value
        }
    }
    return this
}
