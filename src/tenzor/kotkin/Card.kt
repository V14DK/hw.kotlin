package tenzor.kotkin

import java.util.Objects

internal enum class Rank(val rank: Int) {
    Jack(11),
    Queen(12),
    King(13),
    Ace(14),
    Joker(15)
}

internal enum class Suit {
    Clubs,
    Diamonds,
    Hearts,
    Spades;

    companion object{
        fun has(suit: String): Boolean {
            for (value in values())
                if (value.name == suit)
                    return true
            return false
        }
    }
}

data class Card(private val suit: String, private val rank: Int) {

    init {
        if (!Suit.has(suit))
            throw Exception("Передана недопустимая масть")
    if (rank < 2 || rank > 15)
            throw Exception("Передан недопустимый ранг")
    }

    companion object {
        fun compareCards(firstCard: Card, secondCard: Card): Int {
            return Suit.valueOf(firstCard.suit).ordinal.compareTo(Suit.valueOf(secondCard.suit).ordinal)
        }
    }

    override fun toString(): String {
        var rank: String = this.rank.toString()
        if (this.rank > 10)
            for (value in Rank.values())
                if (value.rank == this.rank) {
                    rank = value.toString()
                    if (rank == "Joker")
                        return rank
                }
        return rank + " " + suit
    }

    override fun hashCode(): Int = Objects.hash(rank, suit)

    override fun equals(other: Any?): Boolean = hashCode() == other.hashCode()

    fun isStandartDeck(): Boolean = rank in 6..14

    fun isStronger(otherCard: Card): Boolean {
        if (suit == otherCard.suit)
            return rank > otherCard.rank
        throw Exception("Карты разных мастей")
    }

    fun compareTo(otherCard: Card): Int = compareCards(this, otherCard)

}

