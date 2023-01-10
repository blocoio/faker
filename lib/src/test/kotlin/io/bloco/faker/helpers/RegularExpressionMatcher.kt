package io.bloco.faker.helpers

import org.hamcrest.Description
import org.hamcrest.Factory
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import java.util.regex.Pattern

class RegularExpressionMatcher(private val pattern: Pattern) : TypeSafeMatcher<String>() {
    constructor(pattern: String) : this(Pattern.compile(pattern))

    override fun describeTo(description: Description) {
        description.appendText("matches regular expression ").appendValue(pattern)
    }

    public override fun matchesSafely(item: String): Boolean {
        return pattern.matcher(item).matches()
    }

    companion object {
        fun matchesPattern(pattern: Pattern): Matcher<*> {
            return RegularExpressionMatcher(pattern)
        }

        fun matchesPattern(pattern: String): Matcher<String> {
            return RegularExpressionMatcher(pattern)
        }
    }
}