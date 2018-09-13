package blockchain.blocks

import org.json.JSONObject
import java.util.*

/**
 * @Definition : Simple class to represent the Block of a Sale
 */
class SaleBlock(number: Long,
                val idPatient: String,
                val productId: String,
                val pharmacyId: String,
                nonce: Int,
                timestamp: Date,
                previousHash: String) : Block(number, nonce, timestamp, previousHash) {

    override fun toStringBlockChain(): String {
        val blockObject = JSONObject()
        blockObject.put("number", number)
                .put("idPatient", idPatient)
                .put("productId", productId)
                .put("nonce", nonce)
                .put("hash", hash)
                .put("timestamp", timestamp)
                .put("previousHash", previousHash)
        return blockObject.toString()
    }

    override fun toStringBlock(): String {
        val blockObject = JSONObject()
        blockObject.put("number", number)
                .put("idPatient", idPatient)
                .put("productId", productId)
                .put("pharmacyId", pharmacyId)
                .put("previousHash", previousHash)
                .put("nonce", nonce)
        return blockObject.toString()
    }

    // just for debug
    override fun toString(): String {
        return "MaladyBlock(number=$number, idPatient='$idPatient', productId='$productId', nonce=$nonce, previousHash='$previousHash' , timestamp='$timestamp')"
    }
}