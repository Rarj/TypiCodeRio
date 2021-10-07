# Type Code
Typi Code is a simple app that provide random data user, photo and album provided by ```https://jsonplaceholder.typicode.com/```

## Tech stack we used
* [Kotlin](https://kotlinlang.org/) first and Kotlin only.
* [Coroutines](https://developer.android.com/kotlin/coroutines) for request asynchronous request from API
* [KOIN](https://insert-koin.io/) for provide dependencies
* [Data Binding](https://developer.android.com/topic/libraries/data-binding) for binding data into User Interface
* [View Binding](https://developer.android.com/topic/libraries/view-binding) for reduce some boilerplate. Goodbye ```findViewById``` :rocket:
* [Live Data](https://developer.android.com/topic/libraries/architecture/livedata) for observe changes from user input
* [Retrofit2](https://square.github.io/retrofit/) for HTTP request to API using different method ```@GET```, ```HTTP```, ```POST```, ```PUT```, ```PATCH```, ```DELETE ```, ```OPTIONS``` and ```HEAD```
* [GSON](https://github.com/google/gson) for convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object.
 
## Feature Table with Screenshot
| Feature       | Screenshot    |
| ------------- | ------------- |
| Home          | <img width="200" alt="Home" src="https://user-images.githubusercontent.com/23600466/136391985-ac832fdd-389f-46de-a76d-edb84fa3a26f.png">    |
| Detail User   | <img width="200" alt="Detail User" src="https://user-images.githubusercontent.com/23600466/136392244-0b5ee7b7-0b75-44e6-a8c2-1fbe1b20d3e4.png">    |
| Detail Company| <img width="200" alt="Detail Company" src="https://user-images.githubusercontent.com/23600466/136392378-dc9c2dc5-f83e-43ac-a341-ff85a7c87003.png">    |
| More Albums   | <img width="200" alt="More Albums" src="https://user-images.githubusercontent.com/23600466/136392412-5bfcd914-1626-455f-a265-1ebe68597931.png">    |
| Comments      | <img width="200" alt="Comments" src="https://user-images.githubusercontent.com/23600466/136392419-2e9fc4de-c337-45c5-b137-17c2a27db596.png">    |
