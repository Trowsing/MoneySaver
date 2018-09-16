package com.tr.expenses;

import com.tr.MoneySaver.util.CurrencyUtil;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class CurrencyUtilTest {
    @Test
    public void testCurrencyConverter() {
        assertEquals(9999, CurrencyUtil.fromString("$@#!$@99.99$#%"));
        assertEquals("99.99", CurrencyUtil.toUnsignedCurrencyString(9999));
    }
}
