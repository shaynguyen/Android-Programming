# GeoQuiz
A simple true/false quiz

## 1: Your first applicaton

### Create a new project

### Laying out the UI
* recreate this [example](01-1.png)

### Wiring up Widgets
* Wired up the UI you created previously
* Clicking on the true/false button show display a toast

### Challenges
all challenges are on a seperate branch
* display toast on top of the screen instead of the bottom



## 2: Android and MVC
* use a data class to store your questions
* add a next button
* remove hard coded question, all questions are assigned programmatically
* on click, cycle through the next question
* the questions:
```
<string name="question_australia">Canberra is the capital of Australia.</string>
<string name="question_oceans">The Pacific Ocean is larger than
  the Atlantic Ocean.</string>
<string name="question_mideast">The Suez Canal connects the Red Sea
  and the Indian Ocean.</string>
<string name="question_africa">The source of the Nile River is in Egypt.</string>
<string name="question_americas">The Amazon River is the longest river
  in the Americas.</string>
<string name="question_asia">Lake Baikal is the world\'s oldest and deepest
  freshwater lake.</string>
```
* the answers:
```
Question(R.string.question_australia, true),
Question(R.string.question_oceans, true),
Question(R.string.question_mideast, false),
Question(R.string.question_africa, false),
Question(R.string.question_americas, true),
Question(R.string.question_asia, true))

```
* display a toast, indicating if the answer is correct or not
* get a right arrow for your "next" button from
    * [http://www.bignerdranch.com/solutions/AndroidProgramming4e.zip](http://www.bignerdranch.com/solutions/AndroidProgramming4e.zip)

### Challenges
challenges are on a seperate branch
* clicking on the text should navigate to the next question
* add a previous button
* change the next/prev button to a image button, no text
