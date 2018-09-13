package blockchain.blocks

import org.json.JSONObject
import java.util.*

/**
 * @Definition : Simple class to represent the Block of a Malady
 */
class MaladyBlock(number: Long,
                  val idPatient: String,
                  val idMalady: String,
                  val maladyValue: Int,
                  nonce: Int,
                  timestamp: Date,
                  previousHash: String) : Block(number, nonce, timestamp, previousHash) {

    override fun toStringBlock(): String {
        val blockObject = JSONObject()
        blockObject.put("number", number)
                .put("idPatient", idPatient)
                .put("idMalady", idMalady)
                .put("maladyValue", maladyValue)
                .put("previousHash", previousHash)
                .put("nonce", nonce)

        return blockObject.toString()
    }

    override fun toStringBlockChain(): String {
        val blockObject = JSONObject()

        blockObject.put("number", number)
                .put("idPatient", idPatient)
                .put("idMalady", idMalady)
                .put("maladyValue", maladyValue)
                .put("idMalady", idMalady)
                .put("hash", hash)
                .put("nonce", nonce)
                .put("previousHash", previousHash)
        return blockObject.toString()
    }

    // just for debug
    override fun toString(): String {
        return "MaladyBlock(number=$number, idPatient='$idPatient', idMalady='$idMalady', maladyValue=$maladyValue, nonce=$nonce, previousHash='$previousHash')"
    }
}