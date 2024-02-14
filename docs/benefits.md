# Address Book Challenge - Task 1

This page lists benefits, risks and solutions of an Address Book application in Java.


Table of Contents
=================
* [Project Deliverables](#project-deliverables)
  * [Project Objectives](#project-objectives)
  * [Project Approach](#project-approach)
  * [Project Results](#project-results)
* [What problems will the software will solve?](#what-problems-will-the-software-will-solve)
  * [Problem 1](#problem)
  * [Solution 1](#solution)
  * [Problem 2](#problem-1)
  * [Solution 2](#solution-1)
  * [Problem 3](#problem-2)
  * [Solution 3](#solution-2)
  * [Problem 4](#problem-3)
  * [Solution 4](#solution-3)
* [Benefits the software will bring to the user](#benefits-the-software-will-bring-to-the-user)
* [Impact the software will have on the customer's business](#impact-the-software-will-have-on-the-customers-business)


## Project Deliverables
### Project Objectives
* WHAT - The client wishes to have help a solution for a console banking application.
* WHY - The client is doing this project in order to improve efficiency for its customers and the business.
* WHEN - The client has specified it wants the software ready for review by Monday 12 February 2024.

### Project Approach
The software will:
* Be developed in Java using IntelliJ IDEA as the IDE.
* Adopt an Agile approach to get continuous feedback.
* Use Trello to present a Kanban board for workflow processes such as backlog, design, code review or testing.
* Be developed through Test-Driven Development and Behaviour Driven Development.
* Meet a minimum acceptance criteria specified in the README.

### Project Results
* A developed software application meeting all requirements will be deliverable by the timescale listed in the Project Objectives.
* Completed comprehensive documentation in docs folder.
* Jamie A., Software Engineer, will be trained further through doing the Challenge.

## What problems will the software will solve?
### Problem
* The customer may not complete all of a contact's details.

### Solution
* The software will be able to throw an exception if a contact is incomplete.
```Java
public class IncompleteContactException extends Throwable {
  public IncompleteContactException(String message) {
    super(message);
  }
}
``` 
### Problem
* The customer may not be able to find a contact.

### Solution
* The software will be able to throw an exception if a contact is not found.
```Java
public class ContactNotFoundException extends Throwable {
  public ContactNotFoundException(String message) {
    super(message);
  }
}
```
### Problem
* The customer may add a contact with an invalid email or phone number.

### Solution
* The software will be able to throw an exception if a contact has an invalid email or phone number.
* The exceptions could be separate classes for each type of invalid contact.
  * InvalidNameException
  * InvalidEmailException
  * InvalidPhoneNumberException
```Java
public class InvalidContactException extends Throwable {
  public InvalidContactException(String message) {
    super(message);
  }
}
```

### Problem
* The customer may unknowingly add duplicate contacts.

### Solution
* The software will check for duplicate contacts before adding a new contact.
```Java
public class DuplicateContactException extends Throwable {
  public DuplicateContactException(String message) {
    super(message);
  }
}
```

## Benefits the software will bring to the user
* The customer will benefit from using a menu interface that shows results immediately in real time.
* The customer will now be able to do the following with ease:
  * Add a new contact.
  * Remove an existing contact.
  * Update an existing contact.
  * Search for a contact.
  * Print a list of all contacts.
* These activities are easier than ever before because customer data is stored in the address book, allowing them to easily track contacts.

## Impact the software will have on the customer's business
* The business may benefit from higher customer and employee satisfaction as the new software improves efficiency and speed.
* The customer will be able to keep track of contacts more easily, which will result in better customer service.
* The business will be able to reduce the time spent on manual data entry and searching for contacts.
  * The business will be able to cut down on operation costs as a direct result.
* Economies of scale; the software could be deployed to other businesses.
* Data: The business may be able to reduce operational costs with the reliable data saving the software brings.
* This can result in bigger profit margins to the business.



