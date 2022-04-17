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
    Spades
}

class Card {
    private lateinit var suit: String
    private var rank: Int = 0

    internal constructor(suit: String, rank: Int) {
        for (value in Suit.values())
            if (suit == value.name)
                this.suit = suit
        if (this.suit.isEmpty())
            return println("Wrong suit value")
        this.rank = rank
    }

    private companion object {
        public fun compareCards(firstCard: Card, secondCard: Card): Int {
            return Integer.compare(Rank.valueOf(firstCard.suit).rank, Rank.valueOf(secondCard.suit).rank)
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
        return rank + " " + this.suit
    }

    override fun hashCode(): Int {
        return Objects.hash(this.suit, this.rank)
    }

    public fun equals(otherCard: Card): Boolean {
        return this.hashCode() == otherCard.hashCode()
    }

    public fun isStandartDeck(): Boolean {
        return !(this.rank < 6) && !(this.rank > 14)
    }

    public fun isStronger(otherCard: Card): Boolean {
        return this.rank > otherCard.rank
    }

    public fun compareTo(otherCard: Card): Int {
        return Card.compareCards(this, otherCard)
    }

}

