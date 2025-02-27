# Schedule Package

- [Schedule Package](#schedule-package)
  - [Classes](#classes)
    - [Seat](#seat)
    - [Game](#game)
    - [Schedule](#schedule)
  - [Functions](#functions)
    - [Seat](#seat-1)
    - [Game](#game-1)
    - [Schedule](#schedule-1)
  - [Work in Progress?](#work-in-progress)
    - [Game](#game-2)
    - [Schedule](#schedule-2)


## Classes

The Schedule java file has 3 classes:

1. Seat
2. Game
3. Schedule

### Seat

Seat represents a row in a game_X database.

A Seat contains:

* id
* section
* price
* status
  * "available" or "unavailable"

### Game

Game represents a game_X database as a whole.

A Game contains:

* id
* name
  * As in "Toronto Dinosaurs vs Lebron James"
* date
  * As in "YYYYMMDD" integer
    * We can sort easily this way
* time
  * We should use 24 hour (MMHH) time to sort these easily
* seats
  * Stores all the Seat objects as a list we can index/iterate

### Schedule

Schedule represents the schedule database as a whole.

A Schedule contains:

* games
  * Stores all the Game objects as a list we can index/iterate

## Functions

Make sure to include functions after the object

* For example, 'SeatObject'.seatInfo() provides the seat info for a seat

### Seat

```
init (int id, String section, double price, String status)
```
* Sets the Seat attributes with the provided arguments

```
seatInfo()
```
* Returns a readable list of the Seat attributes
  * Without this, accessing a Seat returns the actual object

### Game

```
init(int id, String name, int date, int time)
```
* Sets the Game attributes with the provided arguments

```
loadSeats()
```
* Loads the Game object with the most up-to-date information from the game_X database

```
gameInfo()
```
* Returns a readable list of the Game attributes
  * Without this, accessing a Game returns the actual object

```
getDate()
```
* Returns the Game's date

```
getTime()
```
* Returns the Game's time

```
getSeat(int id)
```
* Returns the Seat with the id index in the Game's seats list

### Schedule

```
loadGames()
```
* Loads the Schedule object with the most up-to-date information from the schedule AND game_X database

```
scheduleInfo()
```
* Returns a readable list of the Schedule attributes
  * Without this, accessing a Schedule returns the actual object

```
getGames()
```
* Returns a list of the Schedule's games list

```
sortedSchedule()
```
* Sorts the schedule by date and time
  * Uses the SortByDate comparator class to do this

## Work in Progress?

### Game

* Get individual game
* Destructure date and time
* Set/unset individual seats
* Set/unset sections
* Price individual seats
* Price seat sections

### Schedule

* Adding a game
  * Includes setting all the seats
* Modify a game
* Deleting a game