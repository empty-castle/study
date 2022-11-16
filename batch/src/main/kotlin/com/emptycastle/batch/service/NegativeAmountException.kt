package com.emptycastle.batch.service

class NegativeAmountException(
    val amount: Double
): RuntimeException()