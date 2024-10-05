package com.gorauskas.euler.solutions.fifty

import com.gorauskas.euler.EULER059_CIPHER_SAMPLE_LENGTH
import com.gorauskas.euler.EULER059_KEY_LENGTH
import com.gorauskas.euler.EULER059_KEY_RANGE_LOWER
import com.gorauskas.euler.EULER059_KEY_RANGE_UPPER
import com.gorauskas.euler.EULER059_PLAIN_TEXT_SAMPLE
import com.gorauskas.euler.EULER_EMPTY_STRING
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.getData
import com.gorauskas.euler.functions.timer
import com.gorauskas.euler.sequences.cycle
import com.gorauskas.euler.sequences.product

class Euler59 : EulerSolution {
    override val problem = """
        Project Euler Problem 59

            Each character on a computer is assigned a unique code and the preferred
            standard is ASCII (American Standard Code for Information Interchange). For
            example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.

            A modern encryption method is to take a text file, convert the bytes to
            ASCII, then `XOR` each byte with a given value, taken from a secret key. The
            advantage with the `XOR` function is that using the same encryption key on
            the cipher text, restores the plain text; for example, `65 XOR 42 = 107`,
            then `107 XOR 42 = 65`.

            For unbreakable encryption, the key is the same length as the plain text
            message, and the key is made up of random bytes. The user would keep the
            encrypted message and the encryption key in different locations, and
            without both "halves", it is impossible to decrypt the message.

            Unfortunately, this method is impractical for most users, so the modified
            method is to use a password as a key. If the password is shorter than the
            message, which is likely, the key is repeated cyclically throughout the
            message. The balance for this method is using a sufficiently long password
            key for security, but short enough to be memorable.

            Your task has been made easy, as the encryption key consists of three lower
            case characters. Using cipher.txt (right click and 'Save Link/Target
            As...'), a file containing the encrypted ASCII codes, and the knowledge
            that the plain text must contain common English words, decrypt the message
            and find the sum of the ASCII values in the original text.
    """.trimIndent()

    override val answer = """

        The sum of the ASCII values in the original text is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long {
        val cipherCodes = javaClass.getResource("/p059_cipher.txt")!!
            .toURI()
            .getData()!!
            .split(",")
            .map { it.toInt() }
        val key = findKey(cipherCodes.take(EULER059_CIPHER_SAMPLE_LENGTH))
        // println("KEY: $key")
        val plainCodes = decode(cipherCodes, key.map(Char::code))
        // println("PLAIN: ${plainCodes.map { it.toChar() }.joinToString(EULER_EMPTY_STRING)}")
        return plainCodes.sum().toLong()
    }

    private fun findKey(cipherSample: List<Int>): String {
        // the encryption key consists of three lower case characters
        val keyRange = (EULER059_KEY_RANGE_LOWER..EULER059_KEY_RANGE_UPPER).toList()
        for (key in product(keyRange, repeat = EULER059_KEY_LENGTH)) {
            val plain = decode(cipherSample, key)
            if (EULER059_PLAIN_TEXT_SAMPLE in plain.map { it.toChar() }.joinToString(EULER_EMPTY_STRING)) {
                return key.map { it.toChar() }.joinToString(EULER_EMPTY_STRING)
            }
        }
        return EULER_EMPTY_STRING
    }

    private fun decode(cipherCodes: List<Int>, key: List<Int>) = cipherCodes.zip(
        key.cycle().take(cipherCodes.size).toList(),
    ) { x, y ->
        x xor y
    }
}
