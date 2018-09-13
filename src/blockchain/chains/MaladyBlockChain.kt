package blockchain.chains

import blockchain.blocks.Block
import blockchain.blocks.MaladyBlock
import blockchain.models.Malady
import org.json.JSONObject
import utils.HashUtils
import java.util.*

/**
 * @definition: Class that represent the Malady BlockChain
 * and it's corresponding functions.
 */
class MaladyBlockChain : BlockChain<MaladyBlock, Malady>() {

    init {
        blockChain.add(MaladyBlock(1, "First One",
                "First Malady", 1, 1, Date().time, "0000"))
    }

    override fun mineBlock(model: Malady): MaladyBlock {
        var nonce = 1
        var check = false
        val jsonObject = JSONObject()

        jsonObject.put(Block.NUMBER, lastBLock.number + 1)
        jsonObject.put(MaladyBlock.ID_PATIENT, model.idPatient)
        jsonObject.put(MaladyBlock.ID_MALADY, model.idMalady)
        jsonObject.put(MaladyBlock.MALADY_VALUE, model.maladyValue.value)
        jsonObject.put(Block.PREVIOUS_HASH, lastBLock.hash)

        while (!check) {

            val hash = HashUtils.hash(JSONObject(jsonObject.toString()).put(Block.NONCE, nonce).toString())
            // the proof of work
            if (hash.startsWith(PROOF))
                check = true
            else
                nonce++
        }

        val newBlock = MaladyBlock(lastBLock.number + 1,
                model.idPatient,
                model.idMalady,
                model.maladyValue.value,
                nonce, Date().time, lastBLock.hash)
        blockChain.add(newBlock)
        println(newBlock.toString())
        println(newBlock.toStringBlockChain())
        return newBlock
    }
}