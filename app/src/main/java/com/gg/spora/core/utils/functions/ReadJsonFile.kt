import java.io.File

fun readJsonFile(
    jsonFile: String
): String {
    val file = File(jsonFile)
    return file.readText()
}