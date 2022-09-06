package loc.example.simplifyingandroiddev9522

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import loc.example.simplifyingandroiddev9522.rule.CoroutineTestRule
import org.junit.Rule

open class BaseTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()
}