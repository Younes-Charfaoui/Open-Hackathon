package blockchain

import blockchain.chains.SalesBlockChain

fun main(args: Array<String>) {
    val sales = SalesBlockChain()

    sales.mineBlock(Sale("1","2","3"))
    sales.mineBlock(Sale("4","5","6"))
    sales.mineBlock(Sale("7","8","9"))

    print(sales.toString())
}