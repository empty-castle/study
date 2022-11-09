import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.SelectionKey
import java.nio.channels.Selector
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SocketChannel
import java.nio.charset.Charset

fun main(args: Array<String>) {

    // 클리이언트 관리 Set
    val allClient = HashSet<SocketChannel>()

    // 서버 소켓 채널 생성 + 포트 연결, 논블로킹 모드 설정
    val serverSocketChannel = ServerSocketChannel.open().apply {
        bind(InetSocketAddress(15000))
        configureBlocking(false)
    }

    // 채널 관리자(Selector) 생성 및 채널 등록
    val selector = Selector.open()
    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT)

    println("[서버 접속 준비 완료]")

    val inputBuffer = ByteBuffer.allocate(1024)
    val outputBuffer = ByteBuffer.allocate(1024)

    while (true) {

        // 이벤트 발생할 때까지 스레드 블로킹
        selector.select()

        // 발생한 이벤트 모두 Iterator 에
        val iterator = selector.selectedKeys().iterator()

        // 발생한 이벤트를 순차적으로 처리
        while (iterator.hasNext()) {

            // 처리할 이벤트를 임시 저장 이후 삭제
            val key = iterator.next()
            iterator.remove()

            // 연결 요청 이벤트인 경우
            if (key.isAcceptable) {

                val server = key.channel() as ServerSocketChannel
                val clientSocket = server.accept().apply {
                    configureBlocking(false)
                }

                allClient.add(clientSocket)

                clientSocket.write(ByteBuffer.wrap("아이디를 입력해주세요 : ".toByteArray()))

                clientSocket.register(selector, SelectionKey.OP_READ, ClientInfo())

                // 읽기 이벤트
            } else if (key.isReadable) {

                val readSocket = key.channel() as SocketChannel
                val info = key.attachment() as ClientInfo

                try {
                    readSocket.read(inputBuffer)
                } catch (e: Exception) {
                    key.cancel()
                    allClient.remove(readSocket)

                    val end = "${info.id}님의 연결이 종료되었습니다.\n"
                    println(end)

                    outputBuffer.put(end.toByteArray())
                    allClient.forEach {
                        if (readSocket != it) {
                            outputBuffer.flip()
                            it.write(outputBuffer)
                        }
                    }

                    outputBuffer.clear()
                    continue
                }

                if (info.isId()) {
                    inputBuffer.limit(inputBuffer.position() - 1)
                    inputBuffer.position(0)
                    val b = ByteArray(inputBuffer.limit())
                    inputBuffer.get(b)
                    info.id = String(b)

                    val enter = "${info.id}님이 입장하셨습니다.\n"
                    println(enter)

                    outputBuffer.put(enter.toByteArray())

                    allClient.forEach {
                        outputBuffer.flip()
                        it.write(outputBuffer)
                    }

                    inputBuffer.clear()
                    outputBuffer.clear()
                    continue
                }

                inputBuffer.flip()
                outputBuffer.put("${info.id} : ".toByteArray())
                outputBuffer.put(inputBuffer)
                outputBuffer.flip()

                allClient.forEach {
                    if (readSocket != it) {
                        it.write(outputBuffer)
//                        outputBuffer.flip()??
                    }
                }

                inputBuffer.clear()
                outputBuffer.clear()
            }
        }
    }
}

class ClientInfo {

    private var idCheck: Boolean = true
    var id: String = ""
        set(value) {
            field = value
            setCheck()
        }

    fun isId(): Boolean {
        return idCheck
    }

    private fun setCheck() {
        idCheck = false
    }
}