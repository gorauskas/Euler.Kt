package com.gorauskas.euler.exceptions

import java.net.URI

class EulerResourceException(uri: URI, e: Exception) : Exception("Could not access resource $uri", e)
