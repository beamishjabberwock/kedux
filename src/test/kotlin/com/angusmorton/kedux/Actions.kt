package com.angusmorton.kedux

internal val PLUS_ACTION = "com.angusmorton.kedux.getPLUS_ACTION"
internal val MINUS_ACTION = "com.angusmorton.kedux.getMINUS_ACTION"
internal val RESET_ACTION = "com.angusmorton.kedux.getRESET_ACTION"
internal val NO_ACTION = "com.angusmorton.kedux.getNO_ACTION"

internal data class TestState(val value: Int)

internal data class TestAction(val type: String, val by: Int) {
}