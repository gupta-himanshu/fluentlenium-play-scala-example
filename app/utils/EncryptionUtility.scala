package utils

import java.security.MessageDigest

object EncryptionUtility {

  /**
   * Generate HexString For Password Encryption
   * @param messageDigest is the byteArray that will return a hex-string
   */
  def getHexString(messageDigest: Array[Byte]): String = {
    val hexString: StringBuffer = new StringBuffer
    messageDigest foreach { digest =>
      val hex = Integer.toHexString(0xFF & digest)
      if (hex.length == 1) hexString.append('0')
      else hexString.append(hex)
    }
    hexString.toString
  }

  /**
   * Password Hashing Using Message Digest Algorithm
   * @param password that needs to be encrypted
   */
  def encryptPassword(password: String): String = {
    val algorithm: MessageDigest = MessageDigest.getInstance("SHA-512")
    val defaultBytes: Array[Byte] = password.getBytes
    algorithm.reset
    algorithm.update(defaultBytes)
    val messageDigest: Array[Byte] = algorithm.digest
    getHexString(messageDigest)
  }
 
}