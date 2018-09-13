package blockchain.blocks

import utils.HashUtils
import java.util.Date

abstract class Block(val number: Long,
                     val nonce: Int,
                     val timestamp: Date,
                     val previousHash: String) {

    val hash: String
        get() = HashUtils.hash(this)

    abstract fun toStringBlock(): String

    abstract fun toStringBlockChain(): String
}