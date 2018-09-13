package blockchain.chains

import blockchain.Sale
import blockchain.blocks.SaleBlock
import org.json.JSONObject
import utils.HashUtils
import java.util.*

class SalesBlockChain : BlockChain<SaleBlock, Sale>() {

    init {
        blockChain.add(SaleBlock(1, "First One",
                "First Product", "12", 1, Date(), "0000"))
    }


    override fun mineBlock(model: Sale): SaleBlock {
        var nonce = 1
        var check = false
        val jsonObject = JSONObject()

        jsonObject.put("number", lastBLock.number + 1)
        jsonObject.put("idPatient", model.idPatient)
        jsonObject.put("productId", model.productId)
        jsonObject.put("pharmacyId", model.pharmacyId)
        jsonObject.put("previousHash", lastBLock.hash)


        while (!check) {

            val hash = HashUtils.hash(JSONObject(jsonObject.toString()).put("nonce", nonce).toString())
            // the proof of work
            if (hash.startsWith("00"))
                check = true
            else
                nonce++
        }

        val newBlock = SaleBlock(lastBLock.number + 1,
                model.idPatient,
                model.productId,
                model.pharmacyId,
                nonce, Date(), lastBLock.hash)
        blockChain.add(newBlock)
        println(newBlock.toStringBlockChain())
        return newBlock
    }
}