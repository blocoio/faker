package io.bloco.faker.helpers

object MapHelper {
    @Suppress("UNCHECKED_CAST")
    fun deepMerge(original: MutableMap<String, Any>, newMap: Map<String, Any>): Map<String, Any> {
        for ((key, value) in newMap) {
            if (value is Map<*, *> && original[key] is MutableMap<*, *>) {
                val originalChild = original[key] as MutableMap<String, Any>
                val newChild = value as Map<String, Any>
                original[key] = deepMerge(originalChild, newChild)
            } else {
                original[key] = value
            }
        }
        return original
    }
}