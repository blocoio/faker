package io.bloco.faker

import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class FakerComponentTest {
    inner class TestComponent(data: FakerData) : FakerComponent(data) {
        fun test(): String {
            return "ok"
        }
    }

    private lateinit var fakerData: FakerData
    private lateinit var fakerComponent: FakerComponent

    @Before
    fun setUp() {
        fakerData = mockk()
        fakerComponent = TestComponent(fakerData)
    }

    @Test
    fun testFetch() {
        val componentKey = "wtv"
        val options: List<String> = listOf("John", "Mary")
        val data: MutableMap<String, Any> = HashMap()
        data["list"] = options
        every { fakerData.getComponentData(eq(componentKey)) } returns data

        assertTrue(options.contains(fakerComponent.fetch("wtv.list")))
    }

    @Test
    fun testFetchComposed() {
        val componentKey = "wtv"
        val options: List<String> = listOf("John", "Mary")
        val internal = mutableMapOf<String, Any>()
        internal["list"] = options
        val data: MutableMap<String, Any> = HashMap()
        data["composed"] = internal
        every { fakerData.getComponentData(eq(componentKey)) } returns data

        assertTrue(options.contains(fakerComponent.fetch("wtv.composed.list")))
    }

    @Test
    fun testSampleNestedLists() {
        val componentKey = "wtv"
        val options = listOf("John", "Mary")
        val data: MutableMap<String, Any> = HashMap()
        data["list"] = listOf(options, options)
        every { fakerData.getComponentData(eq(componentKey)) } returns data

        assertTrue(options.contains(fakerComponent.fetch("wtv.list")))
    }

    @Test
    fun testNumerify() {
        val digit = "#"
        assertTrue(fakerComponent.numerify(digit).matches(Regex("\\d")))
        val number = "###"
        assertTrue(fakerComponent.numerify(number).matches(Regex("\\d{3}")))
        val phone = "###-00-####"
        assertTrue(fakerComponent.numerify(phone).matches(Regex("\\d{3}-00-\\d{4}")))
        val version = "#.#.#"
        assertTrue(fakerComponent.numerify(version).matches(Regex("\\d.\\d.\\d")))
    }

    @Test
    fun testParse() {
        every { fakerData.getComponentByKey<FakerComponent>(any()) } returns fakerComponent

        assertTrue(fakerComponent.parse("#{test}") == "ok")
        assertTrue(fakerComponent.parse("#{testcomponent.test}") == "ok")
        assertTrue(fakerComponent.parse("#{TestComponent.test}") == "ok")
        assertTrue(fakerComponent.parse("#{TestComponent.test} - #{TestComponent.test}") == "ok - ok")
    }

    @Test
    fun testCall() {
        every { fakerData.getComponentByKey<FakerComponent>(any()) } returns fakerComponent
        assertTrue(fakerComponent.call("test") == "ok")
    }

    @Test(expected = IllegalArgumentException::class)
    fun testCallInvalid() {
        every { fakerData.getComponentByKey<FakerComponent>(any()) } returns fakerComponent
        fakerComponent.call("invalid")
    }
}
