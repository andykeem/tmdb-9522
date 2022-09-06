package loc.example.simplifyingandroiddev9522.rule

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@OptIn(ExperimentalCoroutinesApi::class)
class CoroutineTestRule : TestWatcher() {
    private val testCoroutineScheduler = TestCoroutineScheduler()

    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(dispatcher = UnconfinedTestDispatcher(testCoroutineScheduler))
    }

    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}