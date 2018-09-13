package blockchain.factory

import blockchain.blocks.Block
import blockchain.blocks.MaladyBlock
import blockchain.blocks.SaleBlock
import blockchain.chains.BlockChain
import blockchain.chains.MaladyBlockChain
import blockchain.chains.SalesBlockChain
import blockchain.models.Malady
import blockchain.models.Sale
import org.json.JSONArray
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Paths


object BlockchainFactory {

    fun readMaladyBlockChainFromJSON(path: String): BlockChain<MaladyBlock, Malady> {
        val blocks = JSONArray(String(Files.readAllBytes(Paths.get(path))))
        val allBlocks = mutableListOf<MaladyBlock>()

        for (i in 0 until blocks.length()) {
            val block = blocks.getJSONObject(i)

            val idMalady = block.getString(MaladyBlock.ID_MALADY)
            val idPatient = block.getString(MaladyBlock.ID_PATIENT)
            val maladyValue = block.getInt(MaladyBlock.MALADY_VALUE)
            val number = block.getLong(Block.NUMBER)
            val nonce = block.getInt(Block.NONCE)
            val previous = block.getString(Block.PREVIOUS_HASH)
            val timestamp = block.getLong(Block.TIMESTAMP)
            allBlocks.add(MaladyBlock(number, idPatient, idMalady, maladyValue
                    , nonce, timestamp, previous))
        }
        return MaladyBlockChain(allBlocks)
    }

    fun readSalesBlockChainFromJSON(path: String): BlockChain<SaleBlock, Sale> {
        val blocks = JSONArray(String(Files.readAllBytes(Paths.get(path))))
        val allBlocks = mutableListOf<SaleBlock>()

        for (i in 0 until (blocks.length())) {

            val block = blocks.getJSONObject(i)

            val productId = block.getString(SaleBlock.PRODUCT_ID)
            val idPatient = block.getString(MaladyBlock.ID_PATIENT)
            val pharmacyId = block.getString(SaleBlock.PHARMACY_ID)
            val number = block.getLong(Block.NUMBER)
            val nonce = block.getInt(Block.NONCE)
            val previous = block.getString(Block.PREVIOUS_HASH)
            val timestamp = block.getLong(Block.TIMESTAMP)
            val blo = SaleBlock(number, idPatient, productId, pharmacyId
                    , nonce, timestamp, previous)

            allBlocks.add(blo)
        }
        return SalesBlockChain(allBlocks)
    }

    fun saveBlockChainToJSONFile(blockChain: BlockChain<*, *>, path: String) {
        FileWriter(path).use { file ->
            file.write(blockChain.toSaveString())
        }
    }
}