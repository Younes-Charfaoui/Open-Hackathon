package blockchain.workers

import blockchain.blocks.Block
import blockchain.factory.BlockchainFactory
import blockchain.factory.BlockchainPeersFactory
import utils.NetworkUtils

class NotifySales(val block : Block) : Thread() {

    override fun run() {
        val nodes = NetworkUtils.getAllNodes()
        for (node in nodes){
            BlockchainPeersFactory.addBlockToPeer(node, block)
        }
    }
}