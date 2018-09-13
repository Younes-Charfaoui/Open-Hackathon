package blockchain

data class Malady(val idPatient: String,
                  val idMalady: String,
                  val maladyValue: Int)

data class Sale(val idPatient: String,
                val productId: String,
                val pharmacyId: String)