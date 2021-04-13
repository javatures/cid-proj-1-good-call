# Project 1: ghuD On The Web

## Mehrab's Notes
A Java 8 backend web API and ES6+ HTML/JS web interface with a PostgreSQL database. Submit a README.md with a proposal that matches as many requirements as manageable below. You may use the example proposal below for reference, or as your project itself.

### Tools & APIs
- [] Agile User Stories
- [] Java SE 8
- [] Gradle
- [] JDBC
- [] PostgreSQL
- [] JavaEE Servlet
- [] HTML/JS/CSS
- [] AJAX/Fetch
- [] JUnit
- [] log4j or similar
- [] Jest or similar JS testing framework
- [] Optional:
    - [] Docker, Docker-Compose
    - [] React
    - [] Bootstrap
    - [] Remote hosting (AWS EC2/RDS)
    - [] Jenkins CI automation
    - [] Mockito

### Architecture
- [] Anemic/DDD OR n-tier package & class structure
- [] Design Patterns:
    - [] Dependency Injection
    - [] Data Access Object
    - [] Business Delegate
    - [] Model-View-Controller
    - [] Front Controller
- [] SQL Normalization (3rd form)
- [] PL/pgSQL
- [] Optional:
    - [] Single Page Application

### Functionality
- [] CRUD - Create, Read, Update, Delete
- [] Web App dashboard interface
- [] Asynchronous interface updates
  - : update data using Promises
- [] Login - Authentication & Authorization
- [] Database persistance
- [] Session management
  - : login, logout, timeout

### Presentation
- [] Prepare a demonstration of functionality requirements through a browser
- [] Prepare visual aides (slides) introducing the project requirements and features


`end Mehrab's notes`
* * *

## User Stories

- [ ] As a [ghuD Person](#person), I can...
  - [ ] login to my [ghuD](#ghud) so that 
  - [ ] view my [Headspace](#headspace) so that
  - [ ] logout of my [ghuD](#ghud) so that
  - [ ] submit a [Thought](#thought) so that
  - [ ] upload a [Brain Freeze](#brain-freeze) so that I can build my Muse so that
  - [ ] view an individual [Brain Freeze](#brain-freeze) so that
  - [ ] view my [Muse](#muse)- my collection of [Brain Freezes](#brain-freeze) so that
  - [ ] view my [Scoop](#scoop)- my story for the day so that
  - [ ] can write my [Scoop](#scoop) so that
  - [ ] receive an emailed [Scoop](#scoop) so that

- [ ] As a ghuD Friend, I can...
  - [ ] change my Perspective from Refelctive to Expressive so that
  - [ ] change my Perspective from Expressive to Refelctive so that
  - [ ] view my collection of Souls so that
  - [ ] create a Vibe so that
  - [ ] view all Vibes so that
  - [ ] view a Brain Freeze of a Soul so that
  - [ ] view a Wavelength of Vibes between myself and a Soul so that
  - [ ] update a Vibe so that

### Glossary

### ghuD System

A system for tackling the quotidian- the day-to-day data... for the day.
Optimal in its most ethereal form- a simple mental construct.
Think of all ghuD Technology as training wheels for ghuD Persons to eventually operate completely independent of external devices/constructs.

#### Key Componenents Of A ghuD System:

##### Frames Of Mind
   1. Love
   2. Live
   3. Learn
   4. Earn

##### Headspace Locations
   1. Top Of Mind
   2. Front And Center
   3. Bottom Line
   4. Forgotten

#### ghuD

Great Heads Up Display- a tool to help one implement the ghuD System.
A ghuD is meant to get ghuD Persons in, out and about- very simply and very quickly.
Use it to get started, but don't be distracted from what truly matters- what is in front of you and behind the screen.

##### Person

Synonymous with a user, but ghuD Developers are people-first people, so person is preferred over user... to each their own.
Important to note that the [Perspective](#perspective) here is [Reflective](#reflective).


##### Headspace

***Where the magic happens***

May be likened to a [Kanban](https://g.co/kgs/RH6BEy) filled with [Thoughts](#thought)- consider using [Headspace Locations](#headspace-locations) as stages and [Frames Of Mind](#frames-of-mind) as lanes.
It's a ghuD idea to keep this organized and full- but only enough so that one may end each day with it cleared.
It's very important to keep the [Theory Of Constraints](https://g.co/kgs/KsBXz3) in mind.

###### Suggested readings:

- [The Phoenix Project](https://g.co/kgs/bWy9x7)
- [The Goal](https://g.co/kgs/MK9D6Z)

##### Thought

May be likened to a task.
These fill one's [Headspace](#headspace) until cleared- an experience of joy when done so, especially expeditiously.

##### Brain Freeze

A portrait of a [Soul](#soul)

##### Muse

A collection of [Brain Freezes](#brain-freeze)
From [Wikipedia](https://simple.wikipedia.org/wiki/Muse): *The word muse is also sometimes used for a person who inspires somebody else, or any other type of inspiring object. Muse can also be used to describe one's creative thoughts, such as poetry or a musical composition.*

##### Soul

A person or Person that is not oneself.

> [You don't *have* a soul, Docter. You *are* a soul. You *have* a body, temporarily.](https://www.goodreads.com/quotes/10682-you-don-t-have-a-soul-doctor-you-are-a-soul)

##### Scoop

A summary of your [Headspace](#headspace)

##### Friend

## Tech Stack

### JavaSerlvet

Servlet:
Java class that generates **static webpages** with **dynamic data**

Performed tasks:
- takes incoming request
- processes request
- generates response
- sends response to user

HttpServlet example:
- takes HTTP request
- processes headers and contet
- writes HTML, CSS and JS into an HTTP response
- Sends response to user's web browser

Servlet container:
Component of an **application server** that interacts with Java servlets
- manages execution of servlets and Jakarta Server Pages (JSP) pages for Java apps
  - JSPs = dynamically generated web pages

```text
User  -->  HTTP Request  -->   Application Server  -->  Servlet Container  
                                                               |
                                                               V   
User  <--  HTTP Response  <--  Application Server    <--   Servlet(s)  
```
![servlets-flowchart](servlets-flowchart.jpg)

#### JavaServlet References
[Java Servlet Technology Overview](https://www.oracle.com/java/technologies/servlet-technology.html)
[Introduction to Servlets - Video Tutorial](https://www.edureka.co/blog/java-servlets)
[Servlet Documentation - Oracle](https://javaee.github.io/servlet-spec/downloads/servlet-3.1/Final/servlet-3_1-final.pdf)

### Apache Tomcat

Application server:
Runs servlet and JSP-based web apps
- **Open-source** implementation of the Java Servlet, JSPs, Java Expression Language and WebSocket technologies.
- default port = **8080**

### Apache Tomcat References
[Apache Tomcat 9 Docs](https://tomcat.apache.org/tomcat-9.0-doc/)
[Apache Tomcat 9 Configuration Reference](https://tomcat.apache.org/tomcat-9.0-doc/config/index.html)