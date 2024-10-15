Technologies Uses in project:
Dependency Injection with Hilt
Coroutines 
Retrofit
Flow 
Design Pattern in project:
MVVM
Clean Architecture
Why use these all approach:
○	I have used MVVM design with repository and data source class to improve reusability, shared data access, easier data integration. In Data source class we define network operation 
○	Implement interceptors to handle Api calls and to add headers like authentication token.
○	Dependency Injection, MVVM with repositories, Live Data, Flow and Retrofit Strategies used to enhance performance
○	Implement live data which is life cycle aware which will not create memory leak and always provide updated data to UI.
○	Implement dependency injection to achieve Inversion of Control (IoC) between classes and their dependencies, it assure lose coupling 
○	Implement Retrofit for network calling because it includes error handling in network call, Asynchronous and Synchronous Calls and not blocking operations and keep the UI responsive also it has caching mechanisms, which can improve performance and reduce network usage and improve response time
○	Repositories, Api Service Interface, Base Response, View Models and dependency injection all assure the separation of concern and indicates clean architecture.
○	Optimise coroutine usage with the different scope of like in View Model use View Model scope and in activity use lifecycle scope which will not blocking the operations. In Repository use Co routines back ground Dispatchers 
○	Implement Dependency Updates Gradle plugin to monitor available updates for all libraries.
○	Use Target SDK version 34 and ensure compatibility with the latest SDK requirements.


