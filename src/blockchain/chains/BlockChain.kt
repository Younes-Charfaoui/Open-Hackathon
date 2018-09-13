package blockchain.chains

import blockchain.blocks.Block
import org.json.JSONArray
import org.json.JSONObject

abstract class BlockChain<T, in B> {

    val blockChain = mutableListOf<T>()

    val lastBLock: T
        get() = blockChain[blockChain.lastIndex]

    fun add(block: B) = blockChain.add(mineBlock(block))

    abstract fun mineBlock(model: B): T

    override fun toString(): String {
        val blockChainObject = JSONObject()
        val blocksArray = JSONArray()

        for (block in blockChain) {
            blocksArray.put(JSONObject((block as Block).toStringBlockChain()))
        }

        blockChainObject.put("blocks", blocksArray)
        blockChainObject.put("length", blockChain.size)
        blockChainObject.put("isValid", this.isValid())
        return blockChainObject.toString()
    }

    fun isValid(): Boolean {
        var previous = blockChain[0] as Block
        var currentIndex = 1
        while (currentIndex < blockChain.size) {
            with(blockChain[currentIndex] as Block) {
                if (this.previousHash != previous.hash) return false
                if (!this.hash.startsWith("00")) return false
                previous = this
                currentIndex++
            }
        }
        return true
    }
}