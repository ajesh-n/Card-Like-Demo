package com.example.cardlikedemo

class FakeDataSource {
    companion object {
        val POSTS = listOf(
            Post(
                id = "1",
                title = "Android Dev Summit ’22: Coming to you, online and around the world! ⛰️",
                content = "Android Dev Summit is back, so join us online or in person — for the first time since 2019 — at locations around the world. We’ll be sharing the sessions live on YouTube in three tracks spread across three weeks.",
                imageUrl = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh1VWQmqQu6wDswls9f_5NpEQnq4eR57g2NwzWvhKItcKtV6rb_Cyo75XSyL6vvmCIo4tzQn-8taNagEp7QG0KU1L4yMqwbYozNMzBMEFxEN2XintAhy5nLI4RQDaOXr8dgiIFdGOBMdl577Ndelzc0tDBzjI6mz7e4MF8_Tn09KWguZi6I-bS5NbJn/w1200-h630-p-k-no-nu/unnamed%20%2816%29.png",
            ),
            Post(
                id = "2",
                title = "The new Google Pixel Watch is here  — start building for Wear OS! ⌚",
                content = "We launched the Google Pixel Watch, powered by Wear OS 3.5, at the Made by Google event — the perfect device to showcase apps built with Compose for Wear OS. With Compose for Wear OS, the Tiles Material library, and the tools in Android Studio Dolphin, it’s now simpler and more efficient than ever to make apps for WearOS.",
                imageUrl = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhH63icac2kmydOI8Fs2I09KiuRA3GUo2pfZ1Wpf0M5JIEoVQ8dj9LYSl8jpxSQlmlsUVXoeXbwN4UbHMCf5p0M7FHh_EXzMeFRAJ-6feI9-7eIyhBmtGZSD5o-MItwFLH_ESi15Cxd01AlznWaGy9WDqhK0NWtMQwiWELg3xE1I7hba-_7eVqs747V/w1200-h630-p-k-no-nu/WhasNewinPixelDevices_Social.png",
            ),
            Post(
                id = "3",
                title = "Listen to our major Text to Speech upgrades for 64 bit devices \uD83D\uDCAC",
                content = "An upgrade to Speech Services by Google is rolling out to 64-bit Android devices via Google Play over the next few weeks, providing clearer, more natural voices. All 421 voices in 67 languages are being upgraded with a new voice model and synthesizer. The post includes more on this update, including demonstrations of some voice upgrades, along with guidance on how to use text to speech in your projects.",
                imageUrl = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjrHro6d3BTw7ZZ4IXgfb6_8aESB7-SsWfelDSSInZVamiMSnYpBZzGBaZBBrWxWwYgLqOHuOtroGvGjxrwzdUkhjwuIvM1u6chIblGKS1gQ6JVkjXr-Vztyk2zoYb1ylvhNgLgC5q6M-7LaiXT1xnAT96DvkPx89APNb8JEaz-1mnMRcfaOYYBHzQL/w1200-h630-p-k-no-nu/Text%20to%20Speech%20-%20Social%20-%201024x512.png",
            ),
            Post(
                id = "4",
                title = "MAD Skills Compose: Powerful Toolkit",
                content = "Learn about the powerful toolkit of UI components that ship with Compose enabling you to build rich UIs and interactions.",
                imageUrl = "https://miro.medium.com/max/1200/1*3FZeNmAPZDYUCmgL0cBXoA.png",
            ),
            Post(
                id = "5",
                title = "MAD Skills Compose: Accelerate development with tooling",
                content = "Learn how to accelerate your Compose development process with a dive into Android Studio tooling support, including live templates, gutter icons for drawables and colors, composable preview functions, multipreview, preview on device, live edits of literals, and the Layout Inspector.",
                imageUrl = "https://miro.medium.com/max/1200/1*WVUBQsNgePqQxmrHjaID4g.png",
            )
        )
    }
}
