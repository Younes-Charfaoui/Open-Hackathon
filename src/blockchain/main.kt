package blockchain

import blockchain.blocks.MaladyType
import blockchain.chains.MaladyBlockChain
import blockchain.factory.BlockchainFactory
import blockchain.models.Malady

fun main(args: Array<String>) {
    val blockChain = MaladyBlockChain()

    blockChain.mineBlock(Malady("1", "2", MaladyType.SICK))
    blockChain.mineBlock(Malady("1", "2", MaladyType.SICK))
    blockChain.mineBlock(Malady("1", "2", MaladyType.SICK))
    println(blockChain.toString())


}