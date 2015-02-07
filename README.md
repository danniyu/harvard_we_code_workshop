# harvard_we_code_workshop
-----------

This application builds a visulization for an NSF data set about college freshman intentions to major in S&E fields: 2012.
The original data can be found here: http://www.nsf.gov/statistics/2015/nsf15311/tables.cfm

This project is build with Java Spring and the D3.js


Project Dependencies:
-----------
- Java 8 - You can install the correct version for your system here: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
- gradle - Follow these instructions to install: http://spring.io/guides/gs/gradle/#initial

1. Fork the project. Github has some good documentation on how to do this: https://help.github.com/articles/fork-a-repo/.

2. Run it with this task: gradle run


Next Steps
-----------

### 1. Run the tests!

When you start a new project, tests can be a good source of documentation. They help define both the functionality of an application and the current state of the codebase.
Many projects will use a continuous integration server like Jenkins, TeamCity or GoCD to run their suite of tests.

    To run the tests just type: gradle test
    Oops, something is wrong; we've got a failing test!

Before we can add any new functionality we'll need to fix the test and make a commit. [git command hints can be found here](http://gitref.org/)

### 2. Visualize the freshman intentions to major by gender.

The data currently showing represents the percentages of all students intending to major in a science or engineering field. We would like to also display the intentions by gender.

    Hint #1: Look through [this](http://bl.ocks.org/mbostock/3888852) tutorial to see how [d3.js](d3js.org) is being used.

Sometimes a hard part of open source projects is wrapping your head around the layout, data and architecture, in general. Frameworks like Spring and Ruby on Rails attempt to ease this pain
by having conventions and standards to follow. This way when you move from one project to another, you are accustomed to the layout.

    Still not sure where to look?
    Hint #2: The gender specific information is already being returned by the "/students" endpoint. You will need to add two more donuts to represent this data.

### 3. Add clickable links to data for each race/ethnicity.

Right now we're returning a portion of the data set for simplicity sake. We'd like to add a list of all races and ethnicity groups. Each item in the list should allow the user to click on
the title and the data set for that group should appear (the total and each gender set). First, don't forget to add a test in the StudentControllerTest! Before we add functionality we want a test to indicate what behavior we intend to implement.

    Hint:
    @Test
    public void shouldReturnMajorIntentionsForRaceOrEthnicity() {
      // Create the StudentController object here
      // Call the method we are trying to write
      // (hint: it will not have a method in the class, you will need to add it so the compiler doesn't complain)
      // Assert on the data that is returned. For starters, we can assert that we get a list of 3 items
    }

Awesome - we've got a new endpoint to utilize from our javascript. Don't forget to add the @RequestMapping annotation above the method so we can access the data.
Now we need to modify the javascript slightly to utilize our new endpoint.