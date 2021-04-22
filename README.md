Project 1: ghuD On The Web

A Java 8 backend web API and ES6+ HTML/JS web interface with a PostgreSQL database. Submit a README.md with a proposal that matches as many requirements as manageable below. You may use the example proposal below for reference, or as your project itself.
Tools & APIs

    Agile User Stories
    [x] Java SE 8
    [x] Gradle
    [x] JDBC
    [x] PostgreSQL
    [x] JavaEE Servlet
    [x] HTML/JS/CSS
    [x] AJAX/Fetch
    [] JUnit
    [x] log4j or similar
    [] Jest or similar JS testing framework
    [] Optional:
        [x] Docker, Docker-Compose
        [] React
        [] Bootstrap
        [] Remote hosting (AWS EC2/RDS)
        [] Jenkins CI automation
        [] Mockito

Architecture

    [] Anemic/DDD OR n-tier package & class structure
    [] Design Patterns:
        [] Dependency Injection
        [x] Data Access Object
        [] Business Delegate
        [] Model-View-Controller
        [x] Front Controller
    [x] SQL Normalization (3rd form)
    [x] PL/pgSQL
    [] Optional:
        [] Single Page Application

Functionality

    [] CRUD - Create, Read, Update, Delete
    [x] Web App dashboard interface
    [x] Asynchronous interface updates
        : update data using Promises
    [] Login - Authentication & Authorization
    [] Database persistance
    [] Session management
        : login, logout, timeout

Presentation

    [] Prepare a demonstration of functionality requirements through a browser
    [] Prepare visual aides (slides) introducing the project requirements and features

end Mehrab's notes
User Stories

    As a ghuD Person, I can...
        [x] login to my ghuD so that
        [x] view my Headspace so that
        logout of my ghuD so that
        submit a Thought so that
        upload a Brain Freeze so that I can build my Muse so that
        view an individual Brain Freeze so that
        view my Muse- my collection of Brain Freezes so that
        view my Scoop- my story for the day so that
        can write my Scoop so that
        receive an emailed Scoop so that

    As a ghuD Friend, I can...
        change my Perspective from Refelctive to Expressive so that
        change my Perspective from Expressive to Refelctive so that
        view my collection of Souls so that
        create a Vibe so that
        view all Vibes so that
        view a Brain Freeze of a Soul so that
        view a Wavelength of Vibes between myself and a Soul so that
        update a Vibe so that

Glossary
ghuD System

A system for tackling the quotidian- the day-to-day data... for the day. Optimal in its most ethereal form- a simple mental construct. Think of all ghuD Technology as training wheels for ghuD Persons to eventually operate completely independent of external devices/constructs.
Key Componenents Of A ghuD System:
Frames Of Mind

    Love
    Live
    Learn
    Earn

Headspace Locations

    Top Of Mind
    Front And Center
    Bottom Line
    Forgotten

ghuD

Great Heads Up Display- a tool to help one implement the ghuD System. A ghuD is meant to get ghuD Persons in, out and about- very simply and very quickly. Use it to get started, but don't be distracted from what truly matters- what is in front of you and behind the screen.
Person

Synonymous with a user, but ghuD Developers are people-first people, so person is preferred over user... to each their own. Important to note that the Perspective here is Reflective.
Headspace

Where the magic happens

May be likened to a Kanban filled with Thoughts- consider using Headspace Locations as stages and Frames Of Mind as lanes. It's a ghuD idea to keep this organized and full- but only enough so that one may end each day with it cleared. It's very important to keep the Theory Of Constraints in mind.
Suggested readings:

    The Phoenix Project
    The Goal

Thought

May be likened to a task. These fill one's Headspace until cleared- an experience of joy when done so, especially expeditiously.
Brain Freeze

A portrait of a Soul
Muse

A collection of Brain Freezes From Wikipedia: The word muse is also sometimes used for a person who inspires somebody else, or any other type of inspiring object. Muse can also be used to describe one's creative thoughts, such as poetry or a musical composition.
Soul

A person or Person that is not oneself.

    You don't have a soul, Docter. You are a soul. You have a body, temporarily.

Scoop

A summary of your Headspace
Friend
Tech Stack
JavaSerlvet

Servlet: Java class that generates static webpages with dynamic data

Performed tasks:

    takes incoming request
    processes request
    generates response
    sends response to user

HttpServlet example:

    takes HTTP request
    processes headers and contet
    writes HTML, CSS and JS into an HTTP response
    Sends response to user's web browser

Servlet container: Component of an application server that interacts with Java servlets

    manages execution of servlets and Jakarta Server Pages (JSP) pages for Java apps
        JSPs = dynamically generated web pages

User  -->  HTTP Request  -->   Application Server  -->  Servlet Container  
                                                               |
                                                               V   
User  <--  HTTP Response  <--  Application Server    <--   Servlet(s)  

servlets-flowchart
JavaServlet References

Java Servlet Technology Overview Introduction to Servlets - Video Tutorial Servlet Documentation - Oracle
Apache Tomcat

Application server: Runs servlet and JSP-based web apps

    Open-source implementation of the Java Servlet, JSPs, Java Expression Language and WebSocket technologies.
    default port = 8080

Apache Tomcat References

Apache Tomcat 9 Docs Apache Tomcat 9 Configuration Reference