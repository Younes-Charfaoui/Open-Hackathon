package blockchain.factory

import blockchain.chains.BlockChain
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Paths


object BlockchainFactory {

    fun readBlockChainFromJSON(path: String): String {

        return String(Files.readAllBytes(Paths.get(path)))
    }

    fun saveBlockChainToJSONFile(blockChain: BlockChain<*, *>, path: String) {
        FileWriter(path).use { file ->
            file.write(blockChain.toSaveString())
        }
    }
}