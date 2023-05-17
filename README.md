
# Tech News App - Hilt + MVVM + Retrofit

Tech News App which displays list of tech news articles from around the world in card form which when tapped opens the original news article in custom chrome tab inside the app.

- **Using this repo** :
    - Clone this repo to Android Studio.
    - Go to https://newsapi.org/ to get API key.
    - make `apikey.properties` file in root project. In the file, add `API_KEY="xx"`. Replace xx with your API Key.
    - Run App.

(Never upload API Keys to Public Repos. Refer this article - <a href="https://github.com/codepath/android_guides/wiki/Storing-Secret-Keys-in-Android">Storing Secret Keys in Android</a>)

## Project overview
- Project follows **MVVM Architecture**.
- App code is divided into 4 Libraries.
    - data : contains Repository & Data class
    - di : contains dependency injection related Module
    - networking : contains Interceptor & Api Service
    - ui : contains Activity, Fragment, Addapter, ViewHolder, ViewModel, etc.

<img src=https://github.com/hsinha610/news-app-hilt-mvvm/blob/master/Screenshot_20230518_012611_Tech%20News.jpg width="200" height="400"/>
<img src=https://github.com/hsinha610/news-app-hilt-mvvm/blob/master/Screenshot_20230518_012629_Chrome.jpg width="200" height="400"/>



## Libraries used

    1. Networking 
        1. Retrofit
        2. Gson
    2. Dependency Injection
        1. Hilt
    3. Image Loading
        1. Coil 
    4. Concurrency
        1. Coroutines
    5. Custom Chrome Tab

## Articles for reference

<a href="https://www.section.io/engineering-education/image-processing-with-coil-in-android/">Image Processing with Coil in Android</a>

<a href="https://www.digitalocean.com/community/tutorials/retrofit-android-example-tutorial">Retrofit Android Example Tutorial</a>


<a href="https://amitshekhar.me/blog/okhttp-interceptor">OkHttp Interceptor</a>

<a href="https://futurestud.io/tutorials/retrofit-2-how-to-add-query-parameters-to-every-request">How to Add Query Parameters to Every Request - Retrofit - Okhttp</a>

<a href="https://medium.com/@hissain.khan/parsing-with-google-gson-library-in-android-kotlin-7920e26f5520">Parsing between JSON and Kotlin Object with Google Gson Library
</a>

<a href="https://www.geeksforgeeks.org/how-to-use-custom-chrome-tabs-in-android/">Using Custom Chrome Tabs</a>

<a href="https://proandroiddev.com/kotlin-coroutines-in-andriod-ff0b3b399fa0">Kotlin Coroutines in Android</a>

<a href="https://www.section.io/engineering-education/hilt-android-tutorial/">Using Hilt Dependecy Injection Framework in Android</a>

<a href="https://github.com/codepath/android_guides/wiki/Storing-Secret-Keys-in-Android">Storing Secret Keys in Android</a>


