package blockchain.models

import blockchain.blocks.MaladyStatus

data class Malady(val idPatient: String,
                  val idMalady: String,
                  val maladyValue: MaladyStatus)