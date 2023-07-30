# KATA_Testing_Java

## Prerequisite
* Have Java installed (tested with version 1.8.0)
* Have Maven installed (tested with version 3.6.3)
* Have geckodriver (`https://github.com/mozilla/geckodriver/releases`) or chromedriver (`https://chromedriver.chromium.org/downloads`) installed on your machine and added in the Path to your environment variables

## Framework structure

The below framework can be used for UI automation, using Java, Selenium, Maven and Cucumber

### test > java > pages

In this folder you will add classes for each of your project pages (following the POM structure)
We have already added `HomePage.java` where you can add the methods and elements (together with their locators) for the HomePage/MainPage of this application

### test > java > features > step_definitions

In this folder you will store all the step definitions for the BDD scenarios created

### java > utils

In this folder you can find different classes related to driver configuration or helpers methods 

## Instructions

Using our scenario as an example, write and execute BDD scenarios for the following situations:

Book a room from https://automationintesting.online/#/ for a period of 2 nights by filling the information needed (first name, last name, email, phone) and clicking Book now. Test is successful if you get a pop-up "Booking successful. Congratulations! Your booking has been confirmed for: xxx-xxx(period)"
Check that the date in the successful booking pop-up corresponds with the date that you have selected

<em>Below scenario only required for advanced</em>
* If the desired period is already occupied, select a different one (e.g.: In the below example the period 3-5 May appears as Unavailable, so we will select the period immediate after that is available e.g. 5-7 May)
<img width="487" alt="proof" src="https://user-images.githubusercontent.com/12544803/115431373-8253d380-a205-11eb-9339-39a57af24679.PNG">

