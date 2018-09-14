package blockchain.workers

import blockchain.factory.BlockchainFactory
import utils.NetworkUtils

class ReplaceSales : Thread() {

    override fun run() {
        val sales = BlockchainFactory.readSalesBlockChainFromJSONFile()
        val nodes = NetworkUtils.getAllNodes()
        sales.replaceChain(nodes)
    }
}