package com.emptycastle.batch.service

import com.emptycastle.batch.model.Transaction
import org.apache.http.impl.client.CloseableHttpClient
import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemProcessor
import org.springframework.beans.factory.annotation.Autowired


class BaeldungItemProcessor: ItemProcessor<Transaction, Transaction> {

    @Autowired
    private lateinit var closeableHttpClient: CloseableHttpClient

    companion object {
        val LOGGER = LoggerFactory.getLogger(BaeldungItemProcessor::class.java)
    }

    override fun process(transaction: Transaction): Transaction {
        LOGGER.info("SkippingItemProcessor: $transaction")

        if (transaction.username.isEmpty()) {
            throw MissingUsernameException()
        }

        val txAmount: Double = transaction.amount
        if (txAmount < 0) {
            throw NegativeAmountException(txAmount)
        }

        return transaction
    }

//    override fun process(item: Transaction): Transaction {
//        LOGGER.info("Attempting to process user with id = ${item.userId}")
//        val response = fetchMoreUserDetails(item.userId)
//        val result = EntityUtils.toString(response.entity)
//        val userObject = JSONObject(result)
//        item.apply {
//            age = userObject.getString("age").toInt()
//            postCode = userObject.getString("postCode")
//        }
//        return item
//    }
//
//    private fun fetchMoreUserDetails(id: Int): HttpResponse =
//        closeableHttpClient.execute(HttpGet("http://www.baeldung.com:81/user/$id"))
}