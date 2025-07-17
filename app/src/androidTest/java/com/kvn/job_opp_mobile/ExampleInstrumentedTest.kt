package com.kvn.job_opp_mobile

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

/**
 * Instrumented tests for Job Opportunity Mobile App
 */
@RunWith(AndroidJUnit4::class)
class JobOppInstrumentedTest {
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.kvn.job_opp_mobile", appContext.packageName)
    }
}