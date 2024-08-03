package com.gorauskas.euler.solutions.fifty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.getData
import com.gorauskas.euler.functions.timer

class Euler54 : EulerSolution {
    private enum class Suit(val key: String, val value: Int) {
        HEARTS("H", 0),
        DIAMONDS("D", 1),
        CLUBS("C", 2),
        SPADES("S", 3),
    }

    private enum class Rank(val value: Int) {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14),
    }

    private enum class HandRank(val value: Int) {
        HIGH_CARD(1),
        PAIR(2),
        TWO_PAIR(3),
        THREE_OF_A_KIND(4),
        STRAIGHT(5),
        FLUSH(6),
        FULL_HOUSE(7),
        FOUR_OF_A_KIND(8),
        STRAIGHT_FLUSH(9),
        ROYAL_FLUSH(10),
    }

    private data class Card(val rank: Rank, val suit: Suit)

    private data class Hand(val cards: List<Card>)

    /**
     * holds the hand, its rank, and the sorted grouped ranks for tie-breaking
     */
    private data class RankedHand(val hand: Hand, val rank: HandRank, val ranks: List<Int>)

    override val problem = """
        Project Euler Problem 54

            In the card game poker, a hand consists of five cards and are ranked, from
            lowest to highest, in the following way:

              * High Card: Highest value card.
              * One Pair: Two cards of the same value.
              * Two Pairs: Two different pairs.
              * Three of a Kind: Three cards of the same value.
              * Straight: All cards are consecutive values.
              * Flush: All cards of the same suit.
              * Full House: Three of a kind and a pair.
              * Four of a Kind: Four cards of the same value.
              * Straight Flush: All cards are consecutive values of same suit.
              * Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

            The cards are valued in the order: 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen,
            King, Ace.

            If two players have the same ranked hands then the rank made up of the
            highest value wins; for example, a pair of eights beats a pair of fives (see
            example 1 below). But if two ranks tie, for example, both players have a
            pair of queens, then highest cards in each hand are compared (see example 4
            below); if the highest cards tie then the next highest cards are compared,
            and so on.

            Consider the following five hands dealt to two players:

            Hand  | Player 1            | Player 2            | Winner
            =============================================================
             1      5H 5C 6S 7S KD        2C 3S 8S 8D TD        Player 2
                    Pair of Fives         Pair of Eights
            -------------------------------------------------------------
             2      5D 8C 9S JS AC        2C 5C 7D 8S QH        Player 1
                    Highest card Ace      Highest card Queen
            -------------------------------------------------------------
             3      2D 9C AS AH AC        3D 6D 7D TD QD        Player 2
                    Three Aces            Flush with Diamonds
            -------------------------------------------------------------
             4      4D 6S 9H QH QC        3D 6D 7H QD QS        Player 1
                    Pair of Queens        Pair of Queens
                    Highest card Nine     Highest card Seven
            -------------------------------------------------------------
             5      2H 2D 4C 4D 4S        3C 3D 3S 9S 9D        Player 1
                    Full House            Full House
                    With Three Fours      with Three Threes
            -------------------------------------------------------------

            The file, poker.txt, contains one-thousand random hands dealt to two
            players. Each line of the file contains ten cards (separated by a single
            space): the first five are Player 1's cards and the last five are Player 2's
            cards. You can assume that all hands are valid (no invalid characters or
            repeated cards), each player's hand is in no specific order, and in each
            hand there is a clear winner.

            How many hands does Player 1 win?
    """.trimIndent()

    override val answer = """

        Player One wins ${timer { solve() }} hands.
    """.trimIndent()

    override fun solve(): Long = javaClass.getResource("/p054_poker.txt")!!.toURI()
        .getData()!!
        .split("\n")
        .map { it.split(" ") }
        .map { it.slice(0..4).toPokerHand() to it.slice(5..9).toPokerHand() }
        .count { compare(it.first, it.second) == 1 }
        .toLong()

    /**
     * Takes a Hand object and returns its rank by:
     *
     * - Grouping cards by rank and suit.
     * - Checking for flushes and straights.
     * - Determining the highest possible hand rank based on the grouped data.
     */
    private fun rank(hand: Hand): RankedHand {
        val ranks = hand.cards.groupBy { it.rank }.mapValues { it.value.size }
        val suits = hand.cards.groupBy { it.suit }.mapValues { it.value.size }
        val isFlush = suits.values.any { it == 5 }
        val sortedRanks = hand.cards.map { it.rank.value }.sorted()
        val isStraight = (sortedRanks.zipWithNext { a, b -> b == a + 1 }.all { it }) ||
            (sortedRanks == listOf(2, 3, 4, 5, 14)) // Ace-low straight
        val handRank = when {
            isFlush && isStraight && sortedRanks.last() == Rank.ACE.value -> HandRank.ROYAL_FLUSH
            isFlush && isStraight -> HandRank.STRAIGHT_FLUSH
            ranks.values.any { it == 4 } -> HandRank.FOUR_OF_A_KIND
            ranks.values.any { it == 3 } && ranks.values.any { it == 2 } -> HandRank.FULL_HOUSE
            isFlush -> HandRank.FLUSH
            isStraight -> HandRank.STRAIGHT
            ranks.values.any { it == 3 } -> HandRank.THREE_OF_A_KIND
            ranks.values.count { it == 2 } == 2 -> HandRank.TWO_PAIR
            ranks.values.any { it == 2 } -> HandRank.PAIR
            else -> HandRank.HIGH_CARD
        }
        val sortedGroupRanks = ranks.toList()
            .sortedWith(compareBy({ -it.second }, { -it.first.value }))
            .map { it.first.value }

        return RankedHand(hand, handRank, sortedGroupRanks)
    }

    /**
     * Compares two hands by:
     *
     * - Ranking both hands.
     * - Comparing their ranks.
     * - If the ranks are the same, comparing the sorted group ranks to determine the winner.
     *
     * Returns 1 if Player A wins, -1 if Player B wins, 0 if it's a tie
     */
    private fun compare(playerA: Hand, playerB: Hand): Int {
        val rankedHandA = rank(playerA)
        val rankedHandB = rank(playerB)

        return when {
            rankedHandA.rank.value > rankedHandB.rank.value -> 1
            rankedHandA.rank.value < rankedHandB.rank.value -> -1
            else -> {
                for (i in rankedHandA.ranks.indices) {
                    if (rankedHandA.ranks[i] > rankedHandB.ranks[i]) return 1
                    if (rankedHandA.ranks[i] < rankedHandB.ranks[i]) return -1
                }
                0
            }
        }
    }

    /**
     * Transforms something like `listOf("2D", "9C", "AS", "AH", "AC")`
     * into a `Hand` data class
     */
    private fun List<String>.toPokerHand(): Hand = map { card ->
        val rankVal = when (card[0].toString()) {
            "T" -> 10
            "J" -> 11
            "Q" -> 12
            "K" -> 13
            "A" -> 14
            else -> card[0].toString().toInt()
        }
        Card(
            Rank.entries.associateBy { it.value }[rankVal]!!,
            Suit.entries.associateBy { it.key }[card[1].toString()]!!,
        )
    }.let {
        Hand(it)
    }
}
