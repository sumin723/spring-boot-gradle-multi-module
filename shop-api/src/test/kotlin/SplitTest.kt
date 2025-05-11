import org.junit.jupiter.api.Test

class SplitTest {
    @Test
    fun `test split string`() {
        val str = "Hello,World,This,Is,A,Test"
        val result = str.split(",")
        println(result) // Output: [Hello, World, This, Is, A, Test]
    }
}
