package blockchain.chains

import blockchain.Malady
import blockchain.blocks.MaladyBlock
import org.json.JSONObject
import utils.HashUtils
import java.util.*

class MaladyBlockChain : BlockChain<MaladyBlock, Malady>() {

    init {
        blockChain.add(MaladyBlock(1, "First One",
                "First Malady", 1, 1, Date(), "0000"))
    }


    override fun mineBlock(model: Malady): MaladyBlock {
        var nonce = 1
        var check = false
        val jsonObject = JSONObject()

        jsonObject.put("number", lastBLock.number + 1)
        jsonObject.put("idPatient", model.idPatient)
        jsonObject.put("idMalady", model.idMalady)
        jsonObject.put("maladyValue", model.maladyValue)
        jsonObject.put("previousHash", lastBLock.hash)


        while (!check) {

            val hash = HashUtils.hash(JSONObject(jsonObject.toString()).put("nonce", nonce).toString())
            // the proof of work
            if (hash.startsWith("00"))
                check = true
            else
                nonce++
        }

        val newBlock = MaladyBlock(lastBLock.number + 1,
                model.idPatient,
                model.idMalady,
                model.maladyValue,
                nonce, Date(), lastBLock.hash)
        blockChain.add(newBlock)
        return newBlock
    }
}