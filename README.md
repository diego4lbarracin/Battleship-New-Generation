![LOGO]()
# Battleship-New-Generation
Battleship New Generation is an implementation of the world-famous game “Battleship” in Java using a console-based
graphical user interface. I applied all the concepts that I learned during my object-oriented programming class in
my second semester of my career.

## Features
- Log In as an Administrator: To create a championship, an administrator must log in before do it.
  ![logInFeature](https://github.com/diego4lbarracin/Battleship-New-Generation/blob/main/imagesMD/LOGIn.gif?raw=true)  
- Create a Championship: From 1 to N players can try to win the battle against the computer. It is important to highlight
that only an administrator can create a championship.
  ![createChampionship](https://github.com/diego4lbarracin/Battleship-New-Generation/blob/main/imagesMD/CGAme.gif?raw=true)
- Place the Ships on the Board: Each player can place its 10 ships in random locations on its own board as long as the given coordinates
are correct based on the size of each of the 10 ships, and those coordinates do not correspond to a position where another ship had been 
placed already.
  ![placeShips](https://github.com/diego4lbarracin/Battleship-New-Generation/blob/main/imagesMD/PlacingShips.gif?raw=true) 
## Game Mechanics
In the video game, a player can attack the computers board and, based on the result of that attack, a different message is displayed
and a different number of points are added to the player's points.
- Successful Attack: The player earns 2 points.
  ![successfulAttack](https://github.com/diego4lbarracin/Battleship-New-Generation/blob/main/imagesMD/SUAttack.png?raw=true)
- Unsuccessful Attack: This message will be displayed whether the attack coordinates given by the player where attacked before, or that
the position attacked does not correspond to a ship. The player's points are reduced by 1 point.
  ![UNsuccessfulAttack](https://github.com/diego4lbarracin/Battleship-New-Generation/blob/main/imagesMD/UNSAttack.png?raw=true)
- Sunken Ship: This message will be shown if, after an attack operation, a ship is completely destroyed and, indeed, sunken. The player's
points are increased by 4.
  ![SunkenShip](https://github.com/diego4lbarracin/Battleship-New-Generation/blob/main/imagesMD/SunkenShip.png?raw=true)
## Winner and Final Scores
A championship is ended once is determined either the current player or the computer has lost all its ships. Once a championship has concluded,
the final scores and the winner are displayed.
    ![gameReport](https://github.com/diego4lbarracin/Battleship-New-Generation/blob/main/imagesMD/FinalResults.png?raw=true)
## Class Diagram
Since this video game was developed for my Object-Oriented Programming class, in the following image you will find the class diagram, which
is a UML representation of the video game.
    ![classDiagram](https://github.com/diego4lbarracin/Battleship-New-Generation/blob/main/imagesMD/DiagramaDeClasesMV.png?raw=true)