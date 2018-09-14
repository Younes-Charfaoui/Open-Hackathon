package blockchain.workers

import blockchain.factory.BlockchainFactory
import utils.NetworkUtils

class ReplaceMaladies : Thread() {

    override fun run() {
        val maladies = BlockchainFactory.readMaladyBlockChainFromJSONFile()
        val nodes = NetworkUtils.getAllNodes()
        maladies.replaceChain(nodes)
    }
}