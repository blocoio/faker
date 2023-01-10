package io.bloco.faker.helpers

object MapHelper {
    fun deepMerge(original: MutableMap<String, Any>, newMap: Map<String, Any>): Map<String, Any> {
        for (key in newMap.keys) {
            if (newMap[key] is Map<*, *> && original[key] is MutableMap<*, *>) {
                val originalChild = original[key] as MutableMap<String, Any>
                val newChild = newMap[key] as MutableMap<String, Any>
                original[key] = deepMerge(originalChild, newChild)
            } else {
                 newMap[key]?.let { original[key] = it }
            }
        }
        return original
    }
}