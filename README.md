# GameEngine
Simple game engine

There are some generic propeties of this game engine and some things are configurable. 
Basic format of the gamr is , you have to choose a character then you have to clear stages. Every stage has 3 ways , 2 of which 
have no problem but one of the way has monster. If player choose that way then he has to deal with monster. For every fight 
he will get some experience. at the end of all the stages he complete the game.

Configurable part.
You can define as many games as number of folder in resources's folder. Topic.properties is the main file where you have to 
defined the active game. with the active game name, the folder is selected from resources and all the message in that folder
will be used during the game. One can store this configuration in the database also. He ahs to implement the ExternalReader 
interface for database reading. By default it is file reader from resource folder.
- What ever plot you want to have can write in Intro Message File.
- You can configure how many character can be there from which user can choose one.
- You can configure how many stages are there. 
- Each stage has to have one system character , that is also configurable.
- Each character can have weapon, how many and which weapon a character can have is again configurable.
- Intial Health of each character is also configurable.

