import java.io.InputStreamReader
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.Channels
import java.nio.channels.SocketChannel
import java.nio.charset.Charset

fun main(args: Array<String>) {

    val systemIn: Thread

    val socket = SocketChannel.open(InetSocketAddress("10.150.39.172", 15000))
    val out = Channels.newChannel(System.out)

    val readBuffer = ByteBuffer.allocate(1024)

    systemIn = Thread(SystemIn(socket))
    systemIn.start()

    while (true) {

        socket.read(readBuffer)
        readBuffer.flip()
        out.write(readBuffer)
        readBuffer.clear()
    }
}

class SystemIn(private val socket: SocketChannel): Runnable {

    override fun run() {

        val inChannel = Channels.newChannel(System.`in`)
        val byteBuffer = ByteBuffer.allocate(1024)

        while (true) {
            inChannel.read(byteBuffer)
            byteBuffer.flip()
            socket.write(byteBuffer)
            byteBuffer.clear()
        }
    }
}