# EnterpriseAppDevProject

## Introduction
Our goal is to create an interactive fitness application for runners to track their daily adventures. 

This would be beneficial for the runner to have an app provide data on their improvement from month to month or even year to year. 
It will serve as a constant reminder of the goals they are trying to achieve in their active lifestyles. 

## Storyboard

[Storyboard in FluidUI](https://www.fluidui.com/editor/live/project/p_6nCpmMRpduRmGz5P3D2WvnNwxCnlvKJu)

<img width="1594" height="878" alt="Image" src="https://github.com/user-attachments/assets/a380cfea-7b57-4eaa-a74c-779c3c6f8456" /> 

## Requirements

1. As a casual runner, I want an app to track my runs, so that I can set goals and see my improvement over the year.

### Example

**Given**: The user has set a goal to run 4 times a week

**When**: The user completes their 4 runs

**Then**: They receive a badge to extend their weekly goals streak

2. As someone training for a marathon, I want an app to keep track of my progress for my goals, so that I can see my progress towards a full marathon

### Example

**Given**: The user sets a goal to run a specific distance

**When**: The user runs the specified distance

**Then**: they receive a badge to extend their weekly goals streak

3. As someone who runs on a track, I want an ability to record my laps and calculate the distance, so that I can see my progress in a different/clearer format to me

### Example

**Given**: The user runs a certain number of laps around a track

**When**: The user records the number of laps

**Then**: They receive the distance run in miles/kilometers

## Class Diagram

<img width="1821" height="1191" alt="Image" src="https://github.com/user-attachments/assets/c5e08e37-5a88-48c7-bca1-c47e07e0b2ee" />

### Class Diagram Description

**FitnessTrackerController**: starts the flow of information when the app starts. 

**AccountService**: used to find or create a new Account. 

**GoalService**: used to find or create a new Goal. 

**EventService**: used to find or create a new Event. 

**AccountDAO**: used to create, replace, update, or delete a user account, Account information stored in a JSON object. 

**GoalDAO**: used to create, replace, update, or delete a Goal, Goal information stored in a JSON object. 

**EventDAO**: used to create, replace, update, or delete an Event, Event information stored in a JSON object. 

The Account class will take a username, email, and password attribute. The goal will have a generated goalId, a user created goal name, an entry date based on current date when goal is created, and a completion date that is user assigned. The Distance subclass will be used for running goals, this will use the Distance subclass typeId, the goalType string, and distanceToComplete double. The Reps subclass will be used for weight lifting goals, this will use the Reps subclass typeId, the goalType string, and repsToComplete double. The event Class will use the appropriate goalId, generate an eventId, eventType string, a entryDate string, and user input for valueCompleted. 

## JSON Schema

This is what we plan to export

> { 
"title": "Enterprise Fitness Tracker", 
  "type": "object", 
  "additionalProperties": false, 
  "properties": { 
    "account": { "$ref": "#/$defs/Account" }, 
    "goal": { "$ref": "#/$defs/Goal" }, 
    "distanceGoal": { "$ref": "#/$defs/DistanceGoal" }, 
    "repsGoal": { "$ref": "#/$defs/RepsGoal" }, 
    "event": { "$ref": "#/$defs/Event" } 
  }, 

 > "$defs": { 
    "Account": { 
      "title": "Account", 
      "type": "object", 
      "additionalProperties": false, 
      "required": ["accountId", "accountName", "email", "password"], 
      "properties": { 
        "accountId": { "type": "integer" }, 
        "accountName": { "type": "string", "minLength": 1 }, 
        "email": { "type": "string", "format": "email" }, 
        "password": { "type": "string", "minLength": 1 } 
      } 
    }, 
    
   >   "Goal": { 
      "title": "Goal", 
      "type": "object", 
      "additionalProperties": false, 
      "required": ["goalId", "goalName", "entryDate", "completionDate"], 
      "properties": { 
        "goalId": { "type": "integer" }, 
        "goalName": { "type": "string", "minLength": 1 }, 
        "entryDate": { "type": "string", "format": "date" }, 
        "completionDate": { "type": "string", "format": "date" } 
      } 
    }, 
    
>    "DistanceGoal": { 
      "title": "DistanceGoal", 
      "allOf": [ 
        { "$ref": "#/$defs/Goal" }, 
        { 
          "type": "object", 
          "additionalProperties": false, 
          "required": ["typeID", "goalType", "distanceToComplete"], 
          "properties": { 
            "typeID": { "type": "integer" }, 
            "goalType": { "type": "string", "minLength": 1 }, 
            "distanceToComplete": { "type": "number" } 
          } 
        } 
      ] 
    }, 
    
  >  "RepsGoal": { 
      "title": "RepsGoal", 
      "allOf": [ 
        { "$ref": "#/$defs/Goal" }, 
        { 
          "type": "object", 
          "additionalProperties": false, 
          "required": ["typeID", "goalType", "repsToComplete"], 
          "properties": { 
            "typeID": { "type": "integer" }, 
            "goalType": { "type": "string", "minLength": 1 }, 
            "repsToComplete": { "type": "integer" } 
          } 
        } 
      ] 
    },

 >   "Event": { 
      "title": "Event", 
      "type": "object", 
      "additionalProperties": false, 
      "required": ["eventId", "goalId", "eventType", "entryDate", "valueCompleted"], 
      "properties": { 
        "eventId": { "type": "integer" }, 
        "goalId": { "type": "integer" }, 
        "eventType": { "type": "string", "minLength": 1 }, 
        "entryDate": { "type": "string", "format": "date" }, 
        "valueCompleted": { "type": "number" } 
      } 
    } 
  } 
}
>

## Team Members and Roles

UI Specialist: Chris Dougall

Business Logic/Persistence: Tate Mount, Patrick Tanner

GitHub Administrator/DevOps/Product Owner/Scrum Master: Ryan Wagner 

## Milestones

[Milestone 1](https://github.com/Ryan9056/EnterpriseAppDevProject/milestone/1)

## Standup

[We meet 3:45 EST on Thursday](https://teams.microsoft.com/l/meetup-join/19%3ameeting_ZTYyNmIwYzctZTdmMi00ZjdjLTllZDctYjhhNTU0MDc0NjU2%40thread.v2/0?context=%7b%22Tid%22%3a%22f5222e6c-5fc6-48eb-8f03-73db18203b63%22%2c%22Oid%22%3a%222eb11487-bf13-4938-9fb8-e0c6c9471f42%22%7d)

