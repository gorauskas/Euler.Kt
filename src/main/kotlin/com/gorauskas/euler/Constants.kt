package com.gorauskas.euler

/**
 * This program is full of magic numbers everywhere.
 * I use these constants when I have to assign an `odd` value to a variable.
 * I use magic numbers for numbers less than 10 or simple things like 20, 100, 1000.
 */

const val EULER_EMPTY_STRING = ""

const val EULER_CHAR_OFFSET_48_INT = 48
const val EULER_CHAR_OFFSET_48_LONG = 48L
const val EULER_CHAR_OFFSET_64 = 64L
const val EULER_NUM_FIVEK_INT = 5_000
const val EULER_NUM_HUNDREDK_INT = 100_000
const val EULER_NUM_ONE_MILLION_INT = 1_000_000
const val EULER_NUM_ONE_MILLION_LONG = 1_000_000L
const val EULER_NUM_ONE_MILLION_MINUS_ONE_LONG = EULER_NUM_ONE_MILLION_LONG - 1L
const val EULER_NUM_TENK_INT = 10_000
const val EULER_NUM_TENK_LONG = 10_000L
const val EULER_NUM_TEN_BILLION_INT = 10_000_000_000
const val EULER_NUM_THREENINES_LONG = 999L

const val EULER001_MAX = EULER_NUM_THREENINES_LONG
const val EULER002_FIB_MAX = EULER_NUM_ONE_MILLION_LONG * 4
const val EULER003_PF_NUMBER = 600_851_475_143L
const val EULER003_RANGE_MAX = 775_164L
const val EULER004_RANGE_MAX = EULER_NUM_THREENINES_LONG
const val EULER007_MAX = 105_000
const val EULER007_TARGET_INDEX = EULER_NUM_TENK_INT
const val EULER008_CHAR_OFFSET = EULER_CHAR_OFFSET_48_LONG
const val EULER010_MAX = EULER_NUM_ONE_MILLION_INT * 2
const val EULER014_RANGE_MAX = EULER_NUM_ONE_MILLION_MINUS_ONE_LONG
const val EULER014_RANGE_MIN = 500_000L
const val EULER016_CHAR_OFFSET = EULER_CHAR_OFFSET_48_LONG
const val EULER017_CHAR_OFFSET = EULER_CHAR_OFFSET_48_LONG
const val EULER017_START_INDEX = 99L
const val EULER019_CENTURY_END = 2_000L
const val EULER019_CENTURY_START = 1_901L
const val EULER019_UPPER_BOUND = 48_000L
const val EULER020_CHAR_OFFSET = EULER_CHAR_OFFSET_48_LONG
const val EULER021_RANGE_MAX = EULER_NUM_TENK_LONG
const val EULER023_RANGE_MAX = 20_162L
const val EULER024_REMAINING_PERMUTATIONS = EULER_NUM_ONE_MILLION_MINUS_ONE_LONG
const val EULER025_TARGET_MAX = 999L
const val EULER027_RANGE_MAX = EULER_NUM_THREENINES_LONG
const val EULER027_RANGE_MIN = -EULER_NUM_THREENINES_LONG
const val EULER030_CHAR_OFFSET = EULER_CHAR_OFFSET_48_LONG
const val EULER030_UPPER_BOUND = 354_294L
const val EULER032_HIGH_START = 1_234L
const val EULER032_LOW_START = 123L
const val EULER032_MULTIPLICAND_MAX = 101L
const val EULER032_MULTIPLIER_MAX = EULER_NUM_TENK_LONG
const val EULER034_CHAR_OFFSET = EULER_CHAR_OFFSET_48_INT
const val EULER034_HIGH_RANGE = 49_989L
const val EULER035_PRIME_SEQUENCE_MAX = EULER_NUM_ONE_MILLION_INT
const val EULER036_SUM_MAX = EULER_NUM_ONE_MILLION_LONG
const val EULER037_PRIME_SEQUENCE_MAX = 740_000
const val EULER038_RANGE_MAX = 9_487L
const val EULER038_RANGE_MIN = 9_213L
const val EULER040_CHAR_OFFSET = EULER_CHAR_OFFSET_48_INT
const val EULER040_IDX_HUNDK = EULER_NUM_HUNDREDK_INT
const val EULER040_IDX_ONEMIL = EULER_NUM_ONE_MILLION_INT
const val EULER040_IDX_TENK = EULER_NUM_TENK_INT
const val EULER040_RANGE_MAX = EULER_NUM_ONE_MILLION_LONG
const val EULER041_TARGET_MAX = 7_654_321L
const val EULER044_PENTA_SEQUENCE_MAX_SIZE = EULER_NUM_HUNDREDK_INT
const val EULER044_RANGE_MAX = 2500
const val EULER045_HEXA_SEQUENCE_MAX_SIZE = EULER_NUM_HUNDREDK_INT
const val EULER045_LOWER_BOUND = 40755
const val EULER046_LOWER_BOUND = 33L
const val EULER046_MAX_PRIME = EULER_NUM_FIVEK_INT
const val EULER047_LOWER_BOUND = 210L
const val EULER049_INCREASE_BY = 3330
const val EULER049_UPPER_BOUND = 3000
const val EULER050_MAX_PRIME = EULER_NUM_ONE_MILLION_INT
const val EULER050_UPPER_BOUND = 547
const val EULER051_LOWER_BOUND = EULER_NUM_HUNDREDK_INT
const val EULER051_UPPER_BOUND = EULER_NUM_ONE_MILLION_INT
const val EULER052_LOWER_BOUND = 99999L
const val EULER053_UPPER_BOUND = 1000000L
const val EULER055_UPPER_BOUND = 29
const val EULER057_UPPER_BOUND = 1000
const val EULER058_LOWER_BOUND = 0.10
const val EULER059_CIPHER_SAMPLE_LENGTH = 80
const val EULER059_KEY_LENGTH = 3
const val EULER059_KEY_RANGE_LOWER = 97
const val EULER059_KEY_RANGE_UPPER = 122
const val EULER059_PLAIN_TEXT_SAMPLE = " the "
const val EULER060_SET_SIZE = 5
const val EULER060_UPPER_BOUND = EULER_NUM_TENK_INT

const val EULER008_NUMS =
    """
            73167176531330624919225119674426574742355349194934
            96983520312774506326239578318016984801869478851843
            85861560789112949495459501737958331952853208805511
            12540698747158523863050715693290963295227443043557
            66896648950445244523161731856403098711121722383113
            62229893423380308135336276614282806444486645238749
            30358907296290491560440772390713810515859307960866
            70172427121883998797908792274921901699720888093776
            65727333001053367881220235421809751254540594752243
            52584907711670556013604839586446706324415722155397
            53697817977846174064955149290862569321978468622482
            83972241375657056057490261407972968652414535100474
            82166370484403199890008895243450658541227588666881
            16427171479924442928230863465674813919123162824586
            17866458359124566529476545682848912883142607690042
            24219022671055626321111109370544217506941658960408
            07198403850962455444362981230987879927244284909188
            84580156166097919133875499200524063689912560717606
            05886116467109405077541002256983155200055935729725
            71636269561882670428252483600823257530420752963450
    """

const val EULER011_MATRIX =
    """
            08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
            49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
            81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
            52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
            22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
            24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
            32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
            67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
            24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
            21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
            78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
            16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
            86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
            19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
            04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
            88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
            04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
            20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
            20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
            01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48
    """

const val EULER018_TRIANGLE =
    """
            75
            95 64
            17 47 82
            18 35 87 10
            20 04 82 47 65
            19 01 23 75 03 34
            88 02 77 73 07 63 67
            99 65 04 28 06 16 70 92
            41 41 26 56 83 40 80 70 33
            41 48 72 33 47 32 37 16 94 29
            53 71 44 65 25 43 91 52 97 51 14
            70 11 33 28 77 73 17 78 39 68 17 57
            91 71 52 38 17 14 91 43 58 50 27 29 48
            63 66 04 68 89 53 67 30 73 16 69 87 40 31
            04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
    """
