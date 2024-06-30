package com.gorauskas.euler.exceptions

import com.gorauskas.euler.Euler
import com.gorauskas.euler.extensions.getData
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path

class ExceptionsTest {
    @Test
    fun testEulerResourceException() {
        val mockPath = mockk<Path>()
        every { mockPath.toUri() } returns javaClass.getResource("/file_does_not_exist.txt")!!.toURI()

        mockkStatic(Files::class)
        every { Files.readAllLines(any()) } throws IOException("Mocked IO Exception")

        val exception = Assertions.assertThrows(EulerResourceException::class.java) {
            mockPath.toUri().getData()
        }

        Assertions.assertTrue(exception.message!!.startsWith("Could not access resource"))
    }

    @Test
    fun testEulerProblemException() {
        val mockClassLoader = mockk<ClassLoader>()
        every { mockClassLoader.loadClass(any()) } throws ClassNotFoundException("Mocked Class Not Found Exception")

        val exception = Assertions.assertThrows(EulerProblemException::class.java) {
            Euler().main(arrayOf("-p", "9999"))
        }

        Assertions.assertTrue(exception.message!!.startsWith("Unable to load Euler Problem"))
    }
}
