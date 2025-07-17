package com.kvn.job_opp_mobile

import org.junit.Test
import org.junit.Assert.*

/**
 * Unit tests for Job Opportunity Mobile App
 */
class JobOppUnitTest {
    @Test
    fun formatCurrency_isCorrect() {
        assertEquals("$2,500,000", formatCurrency(2500000))
        assertEquals("$1,000", formatCurrency(1000))
    }
}