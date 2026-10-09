package cn.edu.sicnu.cs.stu.huangyiyi.second

class LanguageModel {
    fun getLanguageByPosition(position: Int): String {
        return when (position) {
            0 -> "kotlin"
            1 -> "java"
            2 -> "python"
            3 -> "c++"
            4 -> "c#"
            else -> "unknown"
        }
    }
}
